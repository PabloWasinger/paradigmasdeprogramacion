package axiom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AxiomTest {

    @Test void testStringAsAComand(){
        assertEquals('S', newAxiom().process("iirr").heading());
    }
    @Test void testInvalidComandAfterValidCommand(){
        assertThrowsLike("Invalid command",
                () -> newAxiom().process("iirrj"));
    }

    @Test void testSpeedStartsNull() {
            assertEquals(0, newAxiom().speed() );}

    @Test void testIncrementsSpeedCorrectly() {assertEquals(10, newAxiom().process("i").speed() );}

    @Test void testDecreasesSpeedCorrectly( ) {
        assertEquals(0, newAxiom().process("is").speed() );}

    @Test void testCantDecreaseSpeedWhenStopped() {
        assertThrowsLike("Can't decrease speed when the axiom is stopped" ,
                () -> newAxiom().process("s"));}

    @Test void testRotatesAndIncrementsSpeed() {
        assertEquals(10 , newAxiom().process("li").speed() );
    }

    @Test void testHeadingStartsNorth() {
        assertEquals('N' , newAxiom().heading() );
    }

    @Test void testProbeStartsNotDeployed() {
        assertEquals("retracted" , newAxiom().probe() );
    }

    @Test void testToSlowToDeploy() {
        assertThrowsLike("Can't deploy probe when the axiom is stopped" ,
                () -> newAxiom().process("d"));
    }

    @Test void testRotatesLeftCorrectly() {
        assertEquals('W' , newAxiom().process("l").heading());
    }

    @Test void testRotatesRightCorrectly(){
        assertEquals('E', newAxiom().process("r").heading());
    }

    @Test void testCantRotateRightWithProbeDeployed(){
        assertThrowsLike("probe deployed",
                () -> newAxiom().process("idr"));
    }
    @Test void testCantRotateLeftWithProbeDeployed(){
        assertThrowsLike("probe deployed",
                () -> newAxiom().process("idl"));
    }


    @Test void testProbeDeploysCorrectly(){
        assertEquals("deployed", newAxiom().process("id").probe());
    }

    @Test void testCantDeployProbeWhenProbeIsDeployed() {
        assertThrowsLike("Can't deploy probe when probe is deployed",
                () -> newAxiom().process("idd"));
    }
       @Test void testCantRetractProbeWhenProbeIsNotDeployed(){
        assertThrowsLike("Can't retract probe when probe is not deployed",
                () -> newAxiom().process("f"));
    }
    @Test void testRetractsProbeCorrectly(){assertEquals("retracted", newAxiom().process("idf").probe());
    }
    @Test void testCanSlowDownWhenProbeIsDeployed(){
        assertEquals(10, newAxiom().process("iids").speed());
    }

    @Test void testCantStopWhenProbeIsDeployed(){
        assertThrowsLike("Can't stop when probe is deployed",
                () -> newAxiom().process("ids"));
    }

    @Test void testSingleInvalidCommand(){
        assertThrowsLike("Invalid command",
                () -> newAxiom().process("x"));
    }




    private Axiom newAxiom() {return new Axiom();}
    private static void assertThrowsLike(String ErrorMessage, Executable bodyToEval) {
        assertEquals(ErrorMessage,
                assertThrows(Exception.class,  bodyToEval).getMessage());
    }
}

