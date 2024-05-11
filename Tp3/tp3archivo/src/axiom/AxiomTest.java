package axiom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AxiomTest {

    @Test void test01() {
        assertEquals(0, newBoat().speed() );

    }
    @Test void test02() {
        assertEquals('N' , newBoat().heading() );
    }

    @Test void test03() {
        assertEquals(0 , newBoat().process('s').speed() );
    }

    @Test void test04() {
        assertThrowsLike("too slow" ,() -> newBoat().process('d'));
    }

    @Test void test05() {
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