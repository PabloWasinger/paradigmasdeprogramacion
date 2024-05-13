package axiom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AxiomTest {

    @Test void test01SpeedStartsNull() {
            assertEquals(0, newBoat().speed() );}

    @Test void test02IncrementsSpeedCorrectly() {assertEquals(10, newBoat().process('i').speed() );}

    @Test void test03DecreasesSpeedCorrectly( ) {
        assertEquals(0, newBoat().process('i').process('s').speed() );}

    @Test void test04CantDecreaseSpeedWhenStopped() {
        assertThrowsLike("parado" ,() -> newBoat().process('s'));}

    @Test void test05() {
        assertEquals(10 , newBoat().process('l').process('i').speed() );
    }

    @Test void test06HeadingStartsNorh() {
        assertEquals('N' , newBoat().heading() );
    }

    @Test void test06ProbeStartsNotDeployed() {
        assertEquals("not deployed" , newBoat().probe() );
    }

    @Test void test07tToSlowToDeploy() {
        assertThrowsLike("too slow" ,() -> newBoat().process('d'));
    }

    @Test void test05RotatesLeftCorrectly() {
        assertEquals('E' , newBoat().rotate('l') );
    }

    // Test 08: Rotates right correctly
    // Test 09: Cant rotate when probe is deployed
    // Test 10: Cant slow down when probe is deployed
    // Test 11: Probe deploys correctly
    // Test 12: Cant deploy probe when probe is deployed
    // Test 13: Cant retract probe when probe is not deployed
    // Test 14: Retracts probe correctly








    private Axiom newBoat() {
        return new Axiom();
    }
    private static void assertThrowsLike(String ErrorMessage, Executable bodyToEval) {
        assertEquals(ErrorMessage,
                assertThrows(Exception.class,  bodyToEval).getMessage());
    }
}

