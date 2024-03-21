import Container 
import Stack
import Vessel
import Route
import Data.Typeable

import Control.Exception
import System.IO.Unsafe

testF :: Show a => a -> Bool
testF action = unsafePerformIO $ do
    result <- tryJust isException (evaluate action)
    return $ case result of
        Left _ -> True
        Right _ -> False
    where
        isException :: SomeException -> Maybe ()
        isException _ = Just ()


mdq = "MDQ"
rsl = "RSL"
bhi = "BHI"
bue = "BUE"
qeq = "QEQ"
mvd = "MVD"
cMdq = newC mdq 5
cBue = newC bue 7
cQeq = newC qeq 9

rutaLarga = newR [ bhi, qeq, mdq, bue, rsl ]


stack1vacio = newS 1 -- Stack con 1 espacio vacio
stack1lleno = stackS stack1vacio cMdq -- Stack con 1 espacio lleno


testStack = [ testF(stackS stack1lleno cBue), -- Chequea si no se puede apilar un contenedor en un stack lleno -- NO FUNCIONA PORQUE EL ERROR ESTA EN HOLDSS
             not(testF(stackS stack1vacio cBue))    -- Chequea que se pueda apilar un contenedor cuando hay espacio -- POR AHI CAMBIAR METODO DE TESTEO
             -- chequear todos los casos de holdsS, 
                --1) maxWeight, 
                --2)freecellss,
                --3) el orden de la ruta
            -- netS
            --popS
    ]


