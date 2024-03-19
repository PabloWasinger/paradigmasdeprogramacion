module Vessel ( Vessel, newV, freeCellsV, loadV, unloadV, netV )
 where
import Stack
import Route
import Container


data Vessel = Ves [ Stack ] Route deriving (Eq, Show)



createC :: Int -> Int -> [Stack]          -- Crea una lista con la cantidad de bahías indicadas y su altura respectiva
createC altura cantidad = [newS altura|y <- [1..cantidad]]
                        

newV :: Int -> Int -> Route -> Vessel  -- construye un barco según una cantida de bahias, la altura de las mismas y una ruta
newV cantidad altura ruta = Ves (createC altura cantidad) ruta


freeCellsV :: Vessel -> Int            -- responde la celdas disponibles en el barco
freeCellsV (Ves stacks ruta)  = sum (map freeCellsS stacks)

loadV :: Vessel -> Container -> Vessel -- carga un contenedor en el barco
loadV (Ves stacks ruta) container = Ves stacks ruta --HACER

unloadV :: Vessel -> String -> Vessel  -- responde un barco al que se le han descargado los contenedores que podían descargarse en la ciudad
unloadV (Ves stacks r) ciudad = Ves [popS y ciudad|y <- stacks] r

netV :: Vessel -> Int                  -- responde el peso neto en toneladas de los contenedores en el barco
netV (Ves stacks ruta) = sum (map netS stacks)
