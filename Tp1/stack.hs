module Stack ( Stack,newS, freeCellsS, stackS, netS, holdsS, popS )
 where

import Route
import Container


data Stack = Sta [ Container ] Int deriving (Eq, Show)


newS :: Int -> Stack                          -- construye una Pila con la capacidad indicada 
newS x = Sta [] x

freeCellsS :: Stack -> Int                    -- responde la celdas disponibles en la pila
freeCellsS (Sta xs x) = x - length xs 

stackS :: Stack -> Container -> Stack         -- apila el contenedor indicado en la pila
stackS (Sta xs n) c = Sta (xs ++ [c]) n


listaP :: [Container] -> [Int]                -- Recibe una lista de containers y devuelve una lista con los pesos de cada container
listaP xs = [netC y|y<-xs]

netS :: Stack -> Int                          -- responde el peso neto de los contenedores en la pila
netS (Sta xs n) = sum (listaP xs)

holdsS :: Stack -> Container -> Route -> Bool -- indica si la pila puede aceptar el contenedor considerando las ciudades en la ruta
holdsS s c r = True -- HACER


listaD :: [Container] -> String -> Int               -- Recibe una lista de containers y devuelve un int que refiere a la cantidad de containers a quitar
listaD xs s = length xs - length [destinationC y|y<-xs, destinationC y == s]


nuevaLista :: [Container] -> String -> [Container]
nuevaLista xs s = take (listaD xs s) xs

popS :: Stack -> String -> Stack              -- quita del tope los contenedores con destino en la ciudad indicada
popS (Sta xs i) s = (Sta (nuevaLista xs s) i)




