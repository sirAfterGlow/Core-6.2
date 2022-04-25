import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MainTests {
    Main sut;

    @BeforeEach
    public void init() {
        System.out.println("test started");
        sut = new Main();
    }

    @BeforeAll
    public static void started() {
        System.out.println("tests started");
    }

    @AfterEach
    public void finished() {
        System.out.println("test completed");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("tests completed");
    }

    @Test
    public void calcProfitTaxTest() {
        int a = 100;
        int expected = 6;
        int result = sut.calcProfitTax(a);

        assertThat(result, equalTo(expected));
    }

//    @Test
//    public void calcDiffTaxThrowTest() {
//        //assert
//        assertDoesNotThrow(() -> sut.calcDiffTax(0));
//    }

//    @Test
//    public void  calcDiffTaxThrowTest() {
//        assertThat(() -> sut.calcDiffTax(0), not(Exception.class));
//    }


    @Test
    public void calcDiffTaxNotZeroTest() {
        int a = 10;
        int unexpected = 0;
        int result = sut.calcDiffTax(a);

        assertThat(result, not(unexpected));
    }

    @Test
    public void isProfitTaxLessThenDiff_ThenCorrect() {
        int a = 30;
        int profTaxResult = sut.calcProfitTax(a);
        int diffTaxResult = sut.calcDiffTax(a);

        assertThat(profTaxResult, lessThan(diffTaxResult));
     }

     @Test
    public void qwe() {
        int a = 10;

        assertThat(sut.calcProfitTax(10), not(nullValue()));
     }
}
