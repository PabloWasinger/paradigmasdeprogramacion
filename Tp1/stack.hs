module Stack ( Stack,newS, freeCellsS, stackS)
 where

--import Route
--import Container


data Container = Con String Int deriving (Eq, Show)
data Stack = Sta [ Container ] Int deriving (Eq, Show)
data Route = Rou [ String ] deriving (Eq, Show)



newS :: Int -> Stack                          -- construye una Pila con la capacidad indicada 
newS x = Sta [] x

freeCellsS :: Stack -> Int                    -- responde la celdas disponibles en la pila
freeCellsS (Sta xs x) = x - length xs 

stackS :: Stack -> Container -> Stack         -- apila el contenedor indicado en la pila
stackS (Sta xs n) (Con s i) = Sta (xs ++ [Con s i]) n


listaP :: [Container] -> [Int]                -- Recibe una lista de containers y devuelve una lista con los pesos de cada container
listaP xs = [peso y|y<-xs]

peso :: Container -> Int                      -- Recibe un container y devuelve su peso
peso (Con s i) = i

netS :: Stack -> Int                          -- responde el peso neto de los contenedores en la pila
netS (Sta xs n) = sum [listaP]




holdsS :: Stack -> Container -> Route -> Bool -- indica si la pila puede aceptar el contenedor considerando las ciudades en la ruta


listaD :: [Container] -> [Int]                -- Recibe una lista de containers y devuelve una lista con los pesos de cada container
listaD xs = [destino y|y<-xs]

destino :: Container -> Int                      -- Recibe un container y devuelve su peso
destino (Con s i) = s


popS :: Stack -> String -> Stack              -- quita del tope los contenedores con destino en la ciudad indicada
popS (Sta xs i) 


['a','a']



