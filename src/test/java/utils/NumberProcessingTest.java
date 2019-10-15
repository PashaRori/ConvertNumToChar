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
    public void testNegativityNumber_compareValueToEqualsThem() {
        inputNumber = "-100";
        outputNumber = "100";
        String result = NumberProcessing.checkNegativityNumber(inputNumber);
        assertEquals(outputNumber, result);
    }

    @Test
    public void testNegativityNumber_compareValueToEqualsThem_More() {
        inputNumber = "100";
        outputNumber = "100";
        String result = NumberProcessing.checkNegativityNumber(inputNumber);
        assertEquals(outputNumber, result);
    }

    @Test
    public void testNegativityNumber_compareValueToNotEqualsThem() {
        inputNumber = "1000";
        outputNumber = "100";
        String result = NumberProcessing.checkNegativityNumber(inputNumber);
        assertNotEquals(outputNumber, result);
    }

    @Test
    public void testNegativityNumber_checkExceptionValueWithNull() {
        inputNumber = null;
        assertThrows(NullPointerException.class, () -> {
            NumberProcessing.checkNegativityNumber(inputNumber);
        });
    }

    @Test
    public void numberSegments_compareValueToEqualsThem() {
        inputNumber = "123456789";
        expectedListNumber = Arrays.asList("123", "456", "789");
        outputListNumber = NumberProcessing.numberSegments(inputNumber);
        assertEquals(expectedListNumber, outputListNumber);
    }

    @Test
    public void numberSegments_compareValueToNotEqualsThem() {
        inputNumber = "123456789";
        expectedListNumber = Arrays.asList("123", "456");
        outputListNumber = NumberProcessing.numberSegments(inputNumber);
        assertNotEquals(expectedListNumber, outputListNumber);
    }

    @Test
    public void numberSegments_checkExceptionValueWithNull() {
        inputNumber = null;
        assertThrows(NullPointerException.class, () -> {
            NumberProcessing.numberSegments(inputNumber);
        });
    }
}