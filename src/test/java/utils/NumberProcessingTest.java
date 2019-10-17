package utils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static utils.NumberProcessing.checkNegativityNumber;
import static utils.NumberProcessing.numberSegments;

class NumberProcessingTest {
    private static final String MINUS_ONE_HUNDRED = "-100";
    private static final String ONE_HUNDRED = "100";
    private static final String ONE_THOUSAND = "1000";
    private static final String NULL = null;
    private static final String ONE_TO_NINE = "123456789";
    private static final List<String> ONE_TO_NINE_SEGMENT = Arrays.asList("123", "456", "789");
    private static final List<String> ONE_TO_SIX_SEGMENT = Arrays.asList("123", "456");

    @Test
    public void compareValueNegativityNumberWithPositivityNumberToEqualsThem() {
        assertEquals(ONE_HUNDRED, checkNegativityNumber(MINUS_ONE_HUNDRED));
    }

    @Test
    public void compareValuePositivityNumberWithPositivityNumberToEqualsThem() {
        assertEquals(ONE_HUNDRED, checkNegativityNumber(ONE_HUNDRED));
    }

    @Test
    public void compareValuePositivityNumberWhoMoreLikeOtherNumberToNotEqualsThem() {
        assertNotEquals(ONE_HUNDRED, checkNegativityNumber(ONE_THOUSAND));
    }

    @Test
    public void checkExceptionValueWithNullForCheckNegativity() {
        assertThrows(NullPointerException.class, () -> {
            checkNegativityNumber(NULL);
        });
    }

    @Test
    public void compareValueInputNumberWithClassesArrayToEqualsThem() {
        assertEquals(ONE_TO_NINE_SEGMENT, numberSegments(ONE_TO_NINE));
    }

    @Test
    public void compareValueInputNumberWithClassesArrayToNotEqualsThem() {
        assertNotEquals(ONE_TO_SIX_SEGMENT, numberSegments(ONE_TO_NINE));
    }

    @Test
    public void checkExceptionValueWithNullForSegments() {
        assertThrows(NullPointerException.class, () -> {
            numberSegments(NULL);
        });
    }
}