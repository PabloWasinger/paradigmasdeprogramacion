module Stack ( Stack,newS, freeCellsS, stackS, netS, holdsS, popS )
 where

import Route
import Container


data Stack = Sta [ Container ] Int deriving (Eq, Show)


newS :: Int -> Stack                          -- construye una Pila con la capacidad indicada 
newS x | x <= 0 = error "La pila tiene que tener capacidad mayor a 0" 
       |otherwise = Sta [] x

freeCellsS :: Stack -> Int                    -- responde la celdas disponibles en la pila
freeCellsS (Sta xs x) = x - length xs

{-stackS :: Stack -> Container -> Stack         -- apila el contenedor indicado en la pila
stackS (Sta xs n) c  | freeCellsS (Sta xs n) /= 0 = Sta (xs ++ [c]) n
                     |otherwise = error "No hay lugar en la pila"-}

stackS :: Stack -> Container -> Stack         -- apila el contenedor indicado en la pila
stackS (Sta xs n) c  = Sta (xs ++ [c]) n
                     
netS :: Stack -> Int                          -- responde el peso neto de los contenedores en la pila
netS (Sta xs n) = sum (map netC xs)

{-holdsS :: Stack -> Container -> Route -> Bool -- indica si la pila puede aceptar el contenedor considerando las ciudades en la ruta
holdsS (Sta conts i) container ruta | length conts == 0 = True
                                    | otherwise = inOrderR ruta (destinationC container) (destinationC (last conts))-}

maxWeight :: Stack -> Container -> Bool                  -- Se fija si el stack más el nuevo container excede el peso máximo
maxWeight stack container = (netS stack) + (netC container) <= 20

orden :: Stack -> Container -> Route -> Bool
orden (Sta conts i) container ruta = inOrderR ruta (destinationC container) (destinationC (last conts))

holdsS :: Stack -> Container -> Route -> Bool -- indica si la pila puede aceptar el contenedor considerando las ciudades en la ruta
holdsS (Sta conts i) container ruta | length conts == 0 && netC container <= 20= True
       | otherwise =  orden (Sta conts i) container ruta && freeCellsS (Sta conts i) /= 0 && maxWeight (Sta conts i) container


listaD :: [Container] -> String -> Int               -- Recibe una lista de containers y devuelve un int que refiere a la cantidad de containers a quitar
listaD xs s = length xs - length [destinationC y|y<-xs, destinationC y == s]


nuevaLista :: [Container] -> String -> [Container] -- Elimina los ultimos containers con la ciudad indicada de la lista
nuevaLista xs s = take (listaD xs s) xs

popS :: Stack -> String -> Stack              -- quita del tope los contenedores con destino en la ciudad indicada
popS (Sta xs i) s = Sta (nuevaLista xs s) i





