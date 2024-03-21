--import Test.HUnit
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
cMdq = newC mdq 5
cBue = newC bue 7
cQeq = newC qeq 9

rutaLarga = newR [ bhi, qeq, mdq, bue, rsl ]


stack1vacio = newS 1
stack1lleno = stackS stack1vacio cMdq

testStack = [ testF(stackS stack1lleno cBue),
    not testF(stackS stack1vacio cBue)
    ]