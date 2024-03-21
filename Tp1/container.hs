module Container (Container, newC, destinationC, netC)
 where

data Container = Con String Int deriving (Eq, Show)



newC :: String -> Int -> Container   -- construye un Contenedor dada una ciudad de destino y un peso en toneladas
newC  string peso  | peso <= 0 || peso > 20 = error "peso invalido"
                    |otherwise = (Con string peso) 


destinationC :: Container -> String  -- responde la ciuda destino del contenedor
destinationC (Con c p) = c

netC :: Container -> Int             -- responde el peso en toneladas del contenedor
netC (Con c p) = p 





