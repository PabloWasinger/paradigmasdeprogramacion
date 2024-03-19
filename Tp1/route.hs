module Route ( Route, newR, inOrderR )
 where


import Data.List

data Route = Rou [ String ] deriving (Eq, Show)

newR :: [ String ] -> Route                    -- construye una ruta segun una lista de ciudades
newR = Rou 


inOrderR :: Route -> String -> String -> Bool  -- indica si la primer ciudad consultada esta antes que la segunda ciudad en la ruta (en caso de que sean iguales devuelve True)
inOrderR (Rou xs) c1 c2  |c1 == c2 = True
                         |otherwise = elemIndex c1 xs < elemIndex c2 xs