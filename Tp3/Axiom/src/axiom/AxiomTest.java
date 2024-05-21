package axiom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AxiomTest {

    @Test void testStringAsAComand(){
        assertEquals('S', newBoat().process("iirr").heading());
    }
    @Test void testInvalidComandAfterValidCommand(){
        assertThrowsLike("Invalid command",() -> newBoat().process("iirrj"));
    }

    @Test void testSpeedStartsNull() {
            assertEquals(0, newBoat().speed() );}

    @Test void testIncrementsSpeedCorrectly() {assertEquals(10, newBoat().process("i").speed() );}

    @Test void testDecreasesSpeedCorrectly( ) {
        assertEquals(0, newBoat().process("is").speed() );}

    @Test void testCantDecreaseSpeedWhenStopped() {
        assertThrowsLike("Can't decrease speed when the axiom is stopped" ,() -> newBoat().process("s"));}

    @Test void testRotatesAndIncrementsSpeed() {
        assertEquals(10 , newBoat().process("li").speed() );
    }

    @Test void testHeadingStartsNorth() {
        assertEquals('N' , newBoat().heading() );
    }

    @Test void testProbeStartsNotDeployed() {
        assertEquals("retracted" , newBoat().probe() );
    }

    @Test void testToSlowToDeploy() {
        assertThrowsLike("Can't deploy probe when the axiom is stopped" ,() -> newBoat().process("d"));
    }

    @Test void testRotatesLeftCorrectly() {
        assertEquals('W' , newBoat().process("l").heading());
    }

    @Test void testRotatesRightCorrectly(){
        assertEquals('E', newBoat().process("r").heading());
    }

    @Test void testCantRotateRightWithProbeDeployed(){
        assertThrowsLike("probe deployed", () -> newBoat().process("idr"));
    }
    @Test void testCantRotateLeftWithProbeDeployed(){
        assertThrowsLike("probe deployed", () -> newBoat().process("idl"));
    }


    @Test void testProbeDeploysCorrectly(){
        assertEquals("deployed", newBoat().process("id").probe());
    }

    @Test void testCantDeployProbeWhenProbeIsDeployed() {
        assertThrowsLike("Can't deploy probe when probe is deployed", () -> newBoat().process("idd"));
    }
       @Test void testCantRetractProbeWhenProbeIsNotDeployed(){
        assertThrowsLike("Can't retract probe when probe is not deployed", () -> newBoat().process("f"));
    }
    @Test void testRetractsProbeCorrectly(){
        assertEquals("retracted", newBoat().process("idf").probe());
    }
    @Test void testCanSlowDownWhenProbeIsDeployed(){
        assertEquals(10, newBoat().process("iids").speed());
    }

    @Test void testCantStopWhenProbeIsDeployed(){
        assertThrowsLike("Can't stop when probe is deployed", () -> newBoat().process("ids"));
    }

    @Test void testSingleInvalidCommand(){
        assertThrowsLike("Invalid command", () -> newBoat().process("x"));
    }




    private Axiom2 newBoat() {return new Axiom2();}
    private static void assertThrowsLike(String ErrorMessage, Executable bodyToEval) {
        assertEquals(ErrorMessage,
                assertThrows(Exception.class,  bodyToEval).getMessage());
    }
}

