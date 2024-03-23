module Route ( Route, newR, inOrderR )
 where


import Data.List

data Route = Rou [ String ] deriving (Eq, Show)

newR :: [ String ] -> Route                    -- construye una ruta segun una lista de ciudades
newR ciudades   |null ciudades == True = error "la lista esta vacia" 
                |otherwise = Rou ciudades


inOrderR :: Route -> String -> String -> Bool  -- indica si la primer ciudad consultada esta antes que la segunda ciudad en la ruta (en caso de que sean iguales devuelve True)
inOrderR (Rou xs) c1 c2  |notElem c1 xs || notElem c2 xs = error "Alguna de las ciudades no esta en la ruta"
                         |c1 == c2 = True
                         |otherwise = elemIndex c1 xs < elemIndex c2 xs