package axiom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AxiomTest {

    @Test void test01SpeedStartsNull() {
            assertEquals(0, newBoat().speed() );}

    @Test void test02IncrementsSpeedCorrectly() {assertEquals(10, newBoat().process("i").speed() );}

    @Test void test03DecreasesSpeedCorrectly( ) {
        assertEquals(0, newBoat().process("is").speed() );}

    @Test void test04CantDecreaseSpeedWhenStopped() {
        assertThrowsLike("No se puede disminuir la velocidad cuando el motor está detenido" ,() -> newBoat().process("s"));}

    @Test void test05RotatesAndIncrementsSpeed() {
        assertEquals(10 , newBoat().process("li").speed() );
    }

    @Test void test06HeadingStartsNorth() {
        assertEquals('N' , newBoat().heading() );
    }

    @Test void test07ProbeStartsNotDeployed() {
        assertEquals("retracted" , newBoat().probe() );
    }

    @Test void test08tToSlowToDeploy() {
        assertThrowsLike("No se puede soltar la sonda cuando el motor esta detenido" ,() -> newBoat().process("d"));
    }

    @Test void test09RotatesLeftCorrectly() {
        assertEquals('W' , newBoat().process("l").heading());
    }

    @Test void test10RotatesRightCorrectly(){
        assertEquals('E', newBoat().process("r").heading());
    }

    @Test void test11CantRotateRightWithProbeDeployed(){
        assertThrowsLike("probe deployed", () -> newBoat().process("idr"));
    }
    @Test void test12CantRotateLeftWithProbeDeployed(){
        assertThrowsLike("probe deployed", () -> newBoat().process("idl"));
    }


    @Test void test13ProbeDeploysCorrectly(){
        assertEquals("deployed", newBoat().process("id").probe());
    }

    @Test void test14CantDeployProbeWhenProbeIsDeployed() {
        assertThrowsLike("Can't deploy probe when probe is deployed", () -> newBoat().process("idd"));
    }
       @Test void test15CantRetractProbeWhenProbeIsNotDeployed(){
        assertThrowsLike("Can't retract probe when probe is not deployed", () -> newBoat().process("f"));
    }
    @Test void test16RetractsProbeCorrectly(){
        assertEquals("retracted", newBoat().process("idf").probe());
    }
    @Test void test17CanSlowDownWhenProbeIsDeployed(){
        assertEquals(10, newBoat().process("iids").speed());
    }

    @Test void test18CantStopWhenProbeIsDeployed(){
        assertThrowsLike("Can't stop when probe is deployed", () -> newBoat().process("ids"));
    }

    @Test void test19SingleInvalidCommand(){
        assertThrowsLike("Invalid command", () -> newBoat().process("x"));
    }

    @Test void test20StringAsAComand(){
        assertEquals('S', newBoat().process("iirr").heading());
    }
    @Test void test21InvalidComandAfterValidCommand(){
        assertThrowsLike("Invalid command",() -> newBoat().process("iirrj"));
    }


    private Axiom2 newBoat() {return new Axiom2();}
    private static void assertThrowsLike(String ErrorMessage, Executable bodyToEval) {
        assertEquals(ErrorMessage,
                assertThrows(Exception.class,  bodyToEval).getMessage());
    }
}

