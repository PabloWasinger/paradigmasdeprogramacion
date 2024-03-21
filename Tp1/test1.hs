--mport Test.HUnit
import Container (Container(..), newC)
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

rutaLarga = newR [ bhi, qeq, mdq, bue, rsl ]

{-cont1 = mdq 20
cont2 = rsl 5
cont3 = bhi -5
cont4 = bue 0
cont5 = qeq 25
-}

testContainer = [ 
    not (testF (newC mdq 20)),          --"Crear Container con peso <= 20 y > 0 
    testF (newC qeq 25),                --"Crear Container con peso > 20"
    testF (newC bhi (-5)),                --testCase "Crear Container con peso < 0"
    testF (newC bue 0),                 --testCase "Crear Container con peso = 0"
    
    True]

testRuta = [
    not (testF newR [ bhi, qeq, mdq, bue, rsl ]),                            --chequea si la ruta se creo bien (si no tira error)

True]

