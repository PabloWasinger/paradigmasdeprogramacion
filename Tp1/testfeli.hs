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

ruta = newR [ bhi, qeq, mdq, bue, rsl ]


cont1 = newC mdq 20
cont2 = newC rsl 5
cont3 = newC bhi 18
cont4 = newC bhi 5
cont5 = newC qeq 17


testContainer = [ 
    not (testF (newC mdq 20)),          --"Crear Container con peso <= 20 y > 0 
    testF (newC qeq 25),                --"Crear Container con peso > 20"
    testF (newC bhi (-5)),                --testCase "Crear Container con peso < 0"
    testF (newC bue 0),                 --testCase "Crear Container con peso = 0"
    
    True]

testRuta = [
    not (testF (newR [ bhi, qeq, mdq, bue, rsl ])),     --chequea si la ruta se creo bien (si no tira error)
    inOrderR ruta bhi qeq,                              --chequea si funciona el inOrderR (si estan en orden)
    not (inOrderR ruta qeq bhi),                        --chequea si funciona inOrderR (si no estan en orden deberia dar True)                           
    True]



barco1stack = newV 1 1 ruta
barco1stackLleno = loadV barco1stack cont4
barco2altura = newV 1 2 ruta
barco1lugarlibre = loadV barco2altura cont4


testVessel = [
    not (testF (newV 1 1 ruta)),
    testF (newV 0 1 ruta),
    testF (newV 1 0 ruta),
    testF (loadV barco1stackLleno cont5),
    testF (loadV barco2altura cont2),
    True]