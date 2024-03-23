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

ruta = newR [ bhi, qeq, mdq, bue, rsl ]


cont1 = newC mdq 20
cont2 = newC rsl 7
cont3 = newC bhi 18
cont4 = newC bhi 5
cont5 = newC qeq 17
cont6 = newC qeq 1


testContainer = [ 
    not (testF (newC mdq 20)),          --"Crear Container con peso <= 20 y > 0 
    testF (newC qeq 25),                --"Crear Container con peso > 20"
    testF (newC bhi (-5)),              --testCase "Crear Container con peso < 0"
    testF (newC bue 0),                 --testCase "Crear Container con peso = 0"
    destinationC cont5 == qeq,          --teste
    netC cont5 == 17,
    
    True]

trueContainer = foldr (&&) True testContainer

testRuta = [
    not (testF (newR [ bhi, qeq, mdq, bue, rsl ])),     --chequea si la ruta se creo bien (si no tira error)
    inOrderR ruta bhi qeq,                              --chequea si funciona el inOrderR (si estan en orden)
    not (inOrderR ruta rsl mdq),                        --chequea si funciona inOrderR (si no estan en orden deberia dar True)
    testF(inOrderR ruta bhi "CABA"),                    --tira error si una ciudad no esta en la ruta 
    testF(newR []),                                     -- creo una ruta vacia, tendria que dar error
    True]

trueRuta = foldr (&&) True testRuta

stack1vacio = newS 1 -- Stack con 1 espacio vacio
stack1lleno = stackS stack1vacio  cont2-- Stack con 1 espacio lleno
stack2vacio = newS 2
stack2cont4 = stackS stack2vacio cont4 --stack con un contenedor destino bhi
stack2cont2 = stackS stack2vacio cont2 --stack con un contenedor peso 7
stack2lleno = stackS stack2cont2 cont4 --stack lleno con peso 12
stack2descargado = popS stack2lleno bhi --stack anterior si le saco el container de bhi


testStack = [ 
             not(testF(stackS stack1vacio cont2)),    -- Chequea que se pueda apilar un contenedor cuando hay espacio
             not(holdsS stack1lleno cont3 ruta), -- me fijo si puedo apilar un contenedor un un stack lleno (tendria que dar true por el not)
             not(holdsS stack2cont4 cont2 ruta), --me fijo si puedo apilar un contenedor sobre otro con un destino anterior (tendria que dar true por el not)
             not(holdsS stack2cont2 cont3 ruta), --me fijo si puedo apilar un contenedor sobre otro cuando el peso es >20 (tendria que dar true por el not)
             netS stack2cont2 == 7,                -- chequeo si el peso del stack es efectivamente el que tendria que ser 
             netS stack2lleno == 12,             -- chequeo si el peso del stack es efectivamente el que tendria que ser luego de aplicar stackS
             netS stack2descargado == 7,         -- chequeo si el peso del stack es efectivamente el que tendria que ser luego de aplicar popS
             popS stack2lleno qeq == stack2lleno --chequeo que popS no haga nada cuando le paso una ciudad que no esta en el stack

            ]   

trueStack = foldr (&&) True testStack

barco1stack = newV 1 1 ruta -- barco con un stack vacio
barco1stackLleno = loadV barco1stack cont4 --barco con un stack lleno, peso del container 5, destino bhi
barco2altura = newV 1 2 ruta --barco con un stack 2 de altura vacio
barco1lugarlibre = loadV barco2altura cont2 -- barco un stack de 2 de altura, peso del container 7, destino rsl
barcosinlugar = loadV barco1lugarlibre cont4 --barco con un stack 2 de altuura lleno, peso 12 y ultimo container destino bhi
barcosincont4 = unloadV barcosinlugar bhi --es mismo barco que barco1lugarlibre (al nterior le saque cont4)
barco1stack3cell = newV 1 3 ruta --barco un stack 3 altura
barco1stack2cell = loadV barco1stack3cell cont6 --barco con un stack 2 lugares libres peso del container 1, destino qeq
barco1stack1cell = loadV barco1stack2cell cont4 -- barco con un stack, 1 lugar libre. primer container con peso 1 destino qeq, segundo container con peso 5 destino bhi
barco1stack0cell = loadV barco1stack2cell cont4 -- barco con un stack, 0 lugar libre. primer container con peso 1 destino qeq, segundo y tercer container con peso 5 destino bhi

barco3stack3cell = newV 3 1 ruta --barco 3 stack 1 altura c/u
barco3stack2cell = loadV barco3stack3cell cont5 -- Se le carga al barco 1 container qeq peso 17
barco3stack1cell = loadV barco3stack2cell cont4 -- Se le carga al barco 1 container bhi peso 5



testVessel = [
    not (testF (newV 1 1 ruta)),
    testF (newV 0 1 ruta),                -- Chequea que no se pueda crear un barco con 0 bahías
    testF (newV (-1) 2 ruta),               -- Chequea que no se pueda crear un barco con bahías negativas
    testF (newV 1 0 ruta),                -- Chequea que no se pueda crear un barco con bahías de altura 0
    testF (newV 1 (-1) ruta),               -- Chequea que no se pueda crear un barco con bahías de altura negativa
    testF (netV(loadV barco1stackLleno cont5)), --stack lleno
    not (testF (loadV barco2altura cont2)),
    testF (netV(loadV barco1lugarlibre cont3)), --se pasa de peso
    netV barcosinlugar == 12,             --me fijo si el peso del barco es igual a la suma del peso de los containers
    netV barcosincont4 == 7,              --chequea si el barco se descargo bien SUFICIENTE?
    freeCellsV barco1stack2cell == 2,           --chequea si el barco se cargó bien
    freeCellsV barco1stackLleno /= freeCellsV (unloadV barco1stackLleno bhi),  -- Chequea que efectivamente, la función unloadV descargue un contenedor en la ciudad correcta
    barco1stack == unloadV barco1stack mdq,--chequea que al llamar unloadV a un barco con un stack vacío, devuelve el mismo barco con el stack vacío
    barco1stackLleno == unloadV barco1stackLleno mdq, -- Chequea que al llamar unloadV en una ciudad sobre la cual el barco no tiene contenedores, no se produzcan cambios
    barco1stack2cell == unloadV barco1stack0cell qeq, -- chequea si descarga los contenedores debidos cuando corresponde
    not (testF (loadV barco3stack1cell cont2))-- chequea que en caso de que un stack no tenga más espacio, se le puede cargar a otros stacks el contenedor deseado si es que lo admiten
    ]

trueVessel = foldr (&&) True testVessel

testGeneral = [
    trueRuta,
    trueStack,
    trueContainer,
    trueVessel

    ]