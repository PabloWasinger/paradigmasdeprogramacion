module Stack ( Stack, newS, freeCellsS )
 where

import Container
import Route
import Data.ByteString (length)

data Stack = Sta [ Container ] Int deriving (Eq, Show)

newS :: Int -> Stack                          -- construye una Pila con la capacidad indicada 
newS x = (Sta [] x) 

freeCellsS :: Stack -> Int                    -- responde la celdas disponibles en la pila
freeCellsS (Sta xs x) = x - length xs 

stackS :: Stack -> Container -> Stack         -- apila el contenedor indicado en la pila
stackS (Sta x n) (Con s i) = (Sta [x ++ [(Con s i)]] n)