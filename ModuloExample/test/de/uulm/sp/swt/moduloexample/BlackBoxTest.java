package de.uulm.sp.swt.moduloexample;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class BlackBoxTest {

    @Test
    void moduloEquivalenceTest1() {
        // a negative, b negative, result == 0
        assertEquals(0,ModuloExampleRevised.modulo(-3,-3));
    }

    @Test
    void moduloEquivalenceTest2() {
        // a positive, b positive, result > 0
        assertEquals(1,ModuloExampleRevised.modulo(1,2));
    }

    //@Disabled("Disabled because of endless loop")
    @Test
    void moduloEquivalenceTest3() {
        try {
            ModuloExampleRevised.modulo(2,0);
        }
        catch (ArithmeticException e) {
            return;
        }
        fail();
    }

    @Test
    void moduloBoundaryTest1() {
        // a smallest negative, b largest negative, smallest result
        assertEquals(0,ModuloExampleRevised.modulo(Integer.MIN_VALUE,-1));
    }

    @Test
    void moduloBoundaryTest2() {
        // a largest negative, b largest positive, largest result
        assertEquals(Integer.MAX_VALUE-1,ModuloExampleRevised.modulo(-1,Integer.MAX_VALUE));
    }

    @Test
    void moduloBoundaryTest3() {
        // a smallest positive, b smallest negative, smallest result
        assertEquals(0,ModuloExampleRevised.modulo(0,Integer.MIN_VALUE));
    }

    @Test
    void moduloBoundaryTest4() {
        // a largest positive, b smallest positive, smallest result
        assertEquals(0,ModuloExampleRevised.modulo(Integer.MAX_VALUE,1));
    }

}