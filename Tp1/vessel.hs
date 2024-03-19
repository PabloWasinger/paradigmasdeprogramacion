module Vessel ( Vessel, newV, freeCellsV, loadV, unloadV, netV )
 where
import Stack
import Route
import Container
import Data.ByteString (elemIndex)


data Vessel = Ves [ Stack ] Route deriving (Eq, Show)



createC :: Int -> Int -> [Stack]          -- Crea una lista con la cantidad de bahías indicadas y su altura respectiva
createC altura cantidad = [newS altura|y <- [1..cantidad]]
                        


newV :: Int -> Int -> Route -> Vessel  -- construye un barco según una cantida de bahias, la altura de las mismas y una ruta
newV cantidad altura ruta = Ves (createC altura cantidad) ruta


freeCellsV :: Vessel -> Int            -- responde la celdas disponibles en el barco
freeCellsV (Ves stacks ruta)  = sum (map freeCellsS stacks)


maxWeight :: Stack -> Container -> Bool                  -- Se fija si el stack más el nuevo container excede el peso máximo
maxWeight stack container = (netS stack) + (netC container) < 20


pickS :: [Stack] -> Int -> Container -> Route -> Int                       -- devuelve el indice del stack en el que pondremos el contenedor
pickS stacks num container route | num > length stacks - 1 = error "No hay bahías disponibles para este container"
                           |(maxWeight (stacks !! num) container) && (holdsS (stacks !! num) container route)&& (freeCellsS (stacks !! num) /= 0) = num
                           |otherwise = pickS stacks (num + 1) container route


listaS :: [Stack] -> Int -> Container -> [Stack]           
listaS stacks num con = take num stacks ++ [stackS (stacks !! num) con] ++ drop (num + 1) stacks



unloadV :: Vessel -> String -> Vessel  -- responde un barco al que se le han descargado los contenedores que podían descargarse en la ciudad
unloadV (Ves stacks r) ciudad = Ves [popS y ciudad|y <- stacks] r

netV :: Vessel -> Int                  -- responde el peso neto en toneladas de los contenedores en el barco
netV (Ves stacks ruta) = sum (map netS stacks)
