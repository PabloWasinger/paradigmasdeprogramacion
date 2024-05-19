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
        assertThrowsLike("No se puede disminuir la velocidad cuando el motor está detenido" ,() -> newBoat().process('s'));}

    @Test void test05RotatesAndIncrementsSpeed() {
        assertEquals(10 , newBoat().process('l').process('i').speed() );
    }

    @Test void test06HeadingStartsNorth() {
        assertEquals('N' , newBoat().heading() );
    }

    @Test void test07ProbeStartsNotDeployed() {
        assertEquals("retracted" , newBoat().probe() );
    }

    @Test void test08tToSlowToDeploy() {
        assertThrowsLike("No se puede soltar la sonda cuando el motor esta detenido" ,() -> newBoat().process('d'));
    }

    @Test void test09RotatesLeftCorrectly() {
        assertEquals('W' , newBoat().process('l').heading());
    }

    @Test void test10RotatesRightCorrectly(){
        assertEquals('E', newBoat().process('r').heading());
    }

    @Test void test11CantRotateRightWithProbeDeployed(){
        assertThrowsLike("probe deployed", () -> newBoat().process('i').process('d').process('r'));
    }
    @Test void test12CantRotateLeftWithProbeDeployed(){
        assertThrowsLike("probe deployed", () -> newBoat().process('i').process('d').process('l'));
    }


    @Test void test13ProbeDeploysCorrectly(){
        assertEquals("deployed", newBoat().process('i').process('d').probe());
    }

    @Test void test14CantDeployProbeWhenProbeIsDeployed() {
        assertThrowsLike("Can't deploy probe when probe is deployed", () -> newBoat().process('i').process('d').process('d'));
    }
       @Test void test15CantRetractProbeWhenProbeIsNotDeployed(){
        assertThrowsLike("Can't retract probe when probe is not deployed", () -> newBoat().process('f'));
    }
    @Test void test16RetractsProbeCorrectly(){
        assertEquals("retracted", newBoat().process('i').process('d').process('f').probe());
    }
    @Test void test17CanSlowDownWhenProbeIsDeployed(){
        assertEquals(10, newBoat().process('i').process('i').process('d').process('s').speed());
    }

    @Test void test18CantStopWhenProbeIsDeployed(){
        assertThrowsLike("Can't stop when probe is deployed", () -> newBoat().process('i').process('d').process('s'));
    }



    private Axiom2 newBoat() {return new Axiom2();}
    private static void assertThrowsLike(String ErrorMessage, Executable bodyToEval) {
        assertEquals(ErrorMessage,
                assertThrows(Exception.class,  bodyToEval).getMessage());
    }
}

