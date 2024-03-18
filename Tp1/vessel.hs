module Vessel ( Vessel, newV, freeCellsV, loadV, unloadV, netV )
 where
import Stack
import Route
import Container
import Stack (netS)

data Vessel = Ves [ Stack ] Route deriving (Eq, Show)




listaStack :: Int -> Int -> [Stack]   -- CHEQUEAR
listaStack n1 n2 =  n1 == []
        otherwise newS n2 : listaStack (n1-1)

newV :: Int -> Int -> Route -> Vessel  -- construye un barco según una cantida de bahias, la altura de las mismas y una ruta
newV cantidad altura ruta|cantidad == 0 = []
                         |otherwise = Ves [Stack.newS altura] ++ newV (cantidad - 1) altura ruta


freeCellsV :: Vessel -> Int            -- responde la celdas disponibles en el barco
freeCellsV (Ves st r)  = sum (map freeCellsS st)

loadV :: Vessel -> Container -> Vessel -- carga un contenedor en el barco

unloadV :: Vessel -> String -> Vessel  -- responde un barco al que se le han descargado los contenedores que podían descargarse en la ciudad
unloadV (Ves st i) s = (Ves [popS y s|y <- st] i)

netV :: Vessel -> Int                  -- responde el peso neto en toneladas de los contenedores en el barco
netV (Ves st _) = sum (map netS st)
