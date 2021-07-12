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

    @Test
    public void testNewLineAsSeparator(){
        assertEquals("6", calculator.add("1\n2,3"));
    }

    @Test
    public void testNewLineAsSeparatorInvalid(){
        assertEquals("Number expected but '\\n' found at position 6.",
                calculator.add("175.2,\n35"));
    }

    @Test
    public void testMissingNumberInLastPosition(){
        assertEquals("Number expected but EOF found.", calculator.add("1,2,"));
    }

    @Test
    public void testCustomSeparators(){
        assertEquals("3", calculator.add("//;\n1;2"));
    }

    @Test
    public void testNegativeNumbers(){
        assertEquals("-1", calculator.add("-1,2"));
    }
}
