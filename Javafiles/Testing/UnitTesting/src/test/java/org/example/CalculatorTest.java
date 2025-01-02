package org.example;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;


@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class CalculatorTest {

    private static final org.slf4j.Logger log
            = org.slf4j.LoggerFactory.getLogger(CalculatorTest.class);

    private Calculator calc;

    @BeforeAll
    static void init() {
        log.info("Test Begin..");  // log is fast then sout.
    }

    @BeforeEach
    void setup() {
        calc = new Calculator();
        log.info("Calculator object created..");
    }

    @AfterEach
    void tearDown() {
        calc = null;
        log.info("Calculator object destroyed..");
    }

    @AfterAll
    static void complete() {
        log.info("Test Ends..");
    }

    //@Disable
    @Test
    @EnabledOnJre(JRE.JAVA_21)
    @EnabledOnOs(OS.MAC)
    void addTest() {

        int res=calc.add(20,30);
        Assertions.assertEquals(50,res);
        Assertions.assertEquals(-10,calc.add(10,-20));
        Assertions.assertEquals(-10,calc.divides(100,-10));
        // Assertions.assertEquals(0,calc.divides(10,0)); wrong way
        Assertions.assertThrows(Exception.class,()->calc.divides(10,0));
        Assertions.assertThrowsExactly(ArithmeticException.class,()->calc.divides(10,0)); //pass
        // Assertions.assertThrowsExactly(Exception.class,()->calc.divides(10,0)); //fails
    }

    @Nested
    class DivideTests {

        @Test
        void divideTest() {

            Assertions.assertEquals(5, calc.divides(10, 2));
            Assertions.assertEquals(-10, calc.divides(100, -10));
            Assertions.assertEquals(0, calc.divides(0, 10));

        }

        @Test
        void divideTestForException() {
            Assertions.assertThrows(Exception.class, () -> calc.divides(10, 0));
        }
    }


}
