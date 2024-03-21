import Test.HUnit
import Container (Container(..), newC)
import Stack
import Vessel
import Route
import Data.Typeable

import Control.Exception
import System.IO.Unsafe







{-testGroup "Stacks" = [
   TestCase "Añadir container a stack lleno" $ assertEqual 1 1
   
    ]

testCells1 = TestCase (assertBool"El stack lleno no debería aceptar 1 container más" (not (testF(stackS stack1lleno cBue))))


stackTests = TestList [TestLabel "test1" testCells1] -}