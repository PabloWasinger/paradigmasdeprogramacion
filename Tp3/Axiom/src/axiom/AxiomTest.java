import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AxiomTest {

    @Test void test01SpeedStartsNull() {
        assertEquals(0, newBoat().speed() );

    }

    @Test void test02IncrementsSpeedCorrectly() {assertEquals(10, newBoat().process('i').speed() );}
}

@Test void test03DecreasesSpeedCorrectly( ) { assertEquals(0, newBoat().process('i').speed().process('s') );}

@Test void test04CantDecreaseSpeedWhenStopped() {
    assertThrowsLike("parado" ,() -> newBoat().process('s');
}

@Test void test05HeadingStartsNorh() {
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






private Axiom newBoat() {
    return new Axiom();
}
private static void assertThrowsLike(String ErrorMessage, Executable bodyToEval) {
    assertEquals(ErrorMessage,
            assertThrows(Exception.class,  bodyToEval).getMessage());
}
}