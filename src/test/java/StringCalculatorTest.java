import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    StringCalculator calculator = new StringCalculator();

    @Test
    public void testStringIsEmpty(){
        assertEquals("0", calculator.add(""));
    }

    @Test
    public void testStringUnicValue(){
        assertEquals("1", calculator.add("1"));
    }

    @Test
    public void testSumOfValues(){
        assertEquals("3.3", calculator.add("1.1,2.2"));
    }

    @Test
    public void testSumAmountOfValues(){
        assertEquals("6", calculator.add("1,2,3"));
    }
}
