import org.junit.jupiter.api.*;
import org.testng.annotations.BeforeTest;
import static org.junit.Assert.*;

import static org.junit.Assert.*;

public class MaxAndMinValuesTest {
    MaxAndMinValues m;

    @BeforeEach
    public void init(){
        m = new MaxAndMinValues();
    }

    @Nested
    class TestArray1 {
        @BeforeEach
        public void initArray1(){
            Integer arr[] = {3, 6, 1, 7, 2, 743, 5, -2};
            m.initArray(arr);
        }
        @Test
        @DisplayName("Finding min value")
        public void MinTest(){
            assertEquals(m.Min(), new Integer(-2));
        }
        @Test
        @DisplayName("Finding max value")
        public void MaxTest(){
            assertEquals(m.Max(), new Integer(743));
        }
    }

    @Nested
    class TestArray2 {
        @BeforeEach
        public void initArray2(){
            Integer arr[] = {19,324,9,0,345};
            m.initArray(arr);
        }
        @Test
        @DisplayName("Finding min value")
        public void MinTest(){
            assertEquals(m.Min(), new Integer(0));
        }
        @Test
        @DisplayName("Finding max value")
        public void MaxTest(){
            assertEquals(m.Max(), new Integer(345));
        }
    }

    @AfterEach
    public void cleanup(){
        m = null;
    }
}