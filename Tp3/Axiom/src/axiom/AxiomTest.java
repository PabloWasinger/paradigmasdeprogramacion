package axiom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AxiomTest {

    @Test void testStringAsAComand(){
        assertEquals('S', newAxiom().executeCommands("iirr").heading());
    }
    @Test void testInvalidComandAfterValidCommand(){
        assertThrowsLike("Invalid command",
                () -> newAxiom().executeCommands("iirrj"));
    }

    @Test void testSpeedStartsNull() {
            assertEquals(0, newAxiom().speed() );}

    @Test void testIncrementsSpeedCorrectly() {assertEquals(10, newAxiom().executeCommands("i").speed() );}

    @Test void testDecreasesSpeedCorrectly( ) {
        assertEquals(0, newAxiom().executeCommands("is").speed() );}

    @Test void testCantDecreaseSpeedWhenStopped() {
        assertThrowsLike("Can't decrease speed when the axiom is stopped" ,
                () -> newAxiom().executeCommands("s"));}

    @Test void testRotatesAndIncrementsSpeed() {
        assertEquals(10 , newAxiom().executeCommands("li").speed() );
    }

    @Test void testHeadingStartsNorth() {
        assertEquals('N' , newAxiom().heading() );
    }

    @Test void testProbeStartsNotDeployed() {
        assertEquals("retracted" , newAxiom().probe() );
    }

    @Test void testToSlowToDeploy() {
        assertThrowsLike("Can't deploy probe when the axiom is stopped" ,
                () -> newAxiom().executeCommands("d"));
    }

    @Test void testRotatesLeftCorrectly() {
        assertEquals('W' , newAxiom().executeCommands("l").heading());
    }

    @Test void testRotatesRightCorrectly(){
        assertEquals('E', newAxiom().executeCommands("r").heading());
    }

    @Test void testCantRotateRightWithProbeDeployed(){
        assertThrowsLike("probe deployed",
                () -> newAxiom().executeCommands("idr"));
    }
    @Test void testCantRotateLeftWithProbeDeployed(){
        assertThrowsLike("probe deployed",
                () -> newAxiom().executeCommands("idl"));
    }


    @Test void testProbeDeploysCorrectly(){
        assertEquals("deployed", newAxiom().executeCommands("id").probe());
    }

    @Test void testCantDeployProbeWhenProbeIsDeployed() {
        assertThrowsLike("Can't deploy probe when probe is deployed",
                () -> newAxiom().executeCommands("idd"));
    }
       @Test void testCantRetractProbeWhenProbeIsNotDeployed(){
        assertThrowsLike("Can't retract probe when probe is not deployed",
                () -> newAxiom().executeCommands("f"));
    }
    @Test void testRetractsProbeCorrectly(){assertEquals("retracted", newAxiom().executeCommands("idf").probe());
    }
    @Test void testCanSlowDownWhenProbeIsDeployed(){
        assertEquals(10, newAxiom().executeCommands("iids").speed());
    }

    @Test void testCantStopWhenProbeIsDeployed(){
        assertThrowsLike("Can't stop when probe is deployed",
                () -> newAxiom().executeCommands("ids"));
    }

    @Test void testSingleInvalidCommand(){
        assertThrowsLike("Invalid command",
                () -> newAxiom().executeCommands("x"));
    }




    private Axiom newAxiom() {return new Axiom();}
    private static void assertThrowsLike(String ErrorMessage, Executable bodyToEval) {
        assertEquals(ErrorMessage,
                assertThrows(Exception.class,  bodyToEval).getMessage());
    }
}

