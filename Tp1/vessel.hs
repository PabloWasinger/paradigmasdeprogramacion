module Vessel ( Vessel, newV, freeCellsV, loadV, unloadV, netV )
 where

data Vessel = Ves [ Stack ] Route deriving (Eq, Show)



data Container = Con String Int deriving (Eq, Show)
data Stack = Sta [ Container ] Int deriving (Eq, Show)
data Route = Rou [ String ] deriving (Eq, Show)

listaStack :: Int -> Int -> [Stack]   -- CHEQUEAR
listaStack n1 n2 =  n1 == []
        otherwise newS n2 : listaStack (n1-1)

newV :: Int -> Int -> Route -> Vessel  -- construye un barco según una cnatida de bahias, la altura de las mismas y una ruta
newV i1 i2 r = Ves (listaStack i1 i2) r

--pruebo los cambios

freeCellsV :: Vessel -> Int            -- responde la celdas disponibles en el barco
loadV :: Vessel -> Container -> Vessel -- carga un contenedor en el barco
unloadV :: Vessel -> String -> Vessel  -- responde un barco al que se le han descargado los contenedores que podían descargarse en la ciudad
netV :: Vessel -> Int                  -- responde el peso neto en toneladas de los contenedores en el barco
