import org.junit.jupiter.api.*;
import org.testng.annotations.BeforeTest;
import static org.junit.Assert.*;

public class EvenOrOddTest {
    EvenOrOdd x;

    @BeforeEach
    public void init(){
        x = new EvenOrOdd();
    }

    @Nested
    class EvenTest {
        @Test
        public void TwoThousandIsEven() {
            x.initNum(2000);
        }
        @Test
        public void SixIsEven() {
            x.initNum(6);
        }
        @Test
        public void TwoIsEven() {
            x.initNum(2);
        }
        @Test
        public void ZeroIsEven() {
            x.initNum(0);
        }

        @AfterEach
        public void TestEven(){
            assertEquals(x.isEven(), true);
            assertEquals(x.isOdd(), false);
            assertEquals(x.evenOrOdd(), "even");
        }
    }

    @Nested
    class OddTest {
        @Test
        public void FiveThouOneIsOdd() {
            x.initNum(5001);
        }
        @Test
        public void FiveIsOdd() {
            x.initNum(5);
        }
        @Test
        public void OneIsOdd() {
            x.initNum(1);
        }

        @AfterEach
        public void TestNotEvenOrOdd(){
            assertEquals(x.isEven(), false);
            assertEquals(x.isOdd(), true);
            assertEquals(x.evenOrOdd(), "odd");
        }
    }

    @Nested
    class NotEvenOrOddTest {
        @Test
        public void NegTwoThousandIsNot() {
            x.initNum(-2000);
        }
        @Test
        public void NegSixIsNot() {
            x.initNum(-6);
        }
        @Test
        public void NegTwoIsNot() {
            x.initNum(-2);
        }
        @Test
        public void NegOneIsNot() {
            x.initNum(-1);
        }

        @AfterEach
        public void TestNotEvenOrOdd(){
            assertEquals(x.isEven(), false);
            assertEquals(x.isOdd(), false);
            assertEquals(x.evenOrOdd(), "neither");
        }
    }

    @AfterEach
    public void cleanUp() {
        x = null;
    }


}