package utils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberProcessingTest {

    private static String inputNumber;
    private static String outputNumber;
    private static List<String> expectedListNumber;
    private static List<String> outputListNumber;

    @Test
    public void compareValueNegativityNumberWithPositivityNumberToEqualsThem() {
        inputNumber = "-100";
        outputNumber = "100";
        String result = NumberProcessing.checkNegativityNumber(inputNumber);
        assertEquals(outputNumber, result);
    }

    @Test
    public void compareValuePositivityNumberWithPositivityNumberToEqualsThem() {
        inputNumber = "100";
        outputNumber = "100";
        String result = NumberProcessing.checkNegativityNumber(inputNumber);
        assertEquals(outputNumber, result);
    }

    @Test
    public void compareValuePositivityNumberWhoMoreLikeOtherNumberToNotEqualsThem() {
        inputNumber = "1000";
        outputNumber = "100";
        String result = NumberProcessing.checkNegativityNumber(inputNumber);
        assertNotEquals(outputNumber, result);
    }

    @Test
    public void checkExceptionValueWithNullForCheckNegativity() {
        inputNumber = null;
        assertThrows(NullPointerException.class, () -> {
            NumberProcessing.checkNegativityNumber(inputNumber);
        });
    }

    @Test
    public void compareValueInputNumberWithClassesArrayToEqualsThem() {
        inputNumber = "123456789";
        expectedListNumber = Arrays.asList("123", "456", "789");
        outputListNumber = NumberProcessing.numberSegments(inputNumber);
        assertEquals(expectedListNumber, outputListNumber);
    }

    @Test
    public void compareValueInputNumberWithClassesArrayToNotEqualsThem() {
        inputNumber = "123456789";
        expectedListNumber = Arrays.asList("123", "456");
        outputListNumber = NumberProcessing.numberSegments(inputNumber);
        assertNotEquals(expectedListNumber, outputListNumber);
    }

    @Test
    public void checkExceptionValueWithNullForSegments() {
        inputNumber = null;
        assertThrows(NullPointerException.class, () -> {
            NumberProcessing.numberSegments(inputNumber);
        });
    }
}