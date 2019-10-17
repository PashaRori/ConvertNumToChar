package util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static util.NumberProcessing.checkNegativityNumber;
import static util.NumberProcessing.numberSegments;

class NumberProcessingTest {
    private static final String MINUS_ONE_HUNDRED = "-100";
    private static final String ONE_HUNDRED = "100";
    private static final String ONE_THOUSAND = "1000";
    private static final String NULL = null;
    private static final String ONE_TO_NINE = "123456789";
    private static final List<String> ONE_TO_NINE_SEGMENT = Arrays.asList("123", "456", "789");
    private static final List<String> ONE_TO_SIX_SEGMENT = Arrays.asList("123", "456");

    @Test
    public void compareConvertedOneHundredAndMinusOneHundred() {
        assertEquals(ONE_HUNDRED, checkNegativityNumber(MINUS_ONE_HUNDRED));
    }

    @Test
    public void compareConvertedOneHundredAndOneHundred() {
        assertEquals(ONE_HUNDRED, checkNegativityNumber(ONE_HUNDRED));
    }

    @Test
    public void compareConvertedOneHundredAndOneThousand() {
        assertNotEquals(ONE_HUNDRED, checkNegativityNumber(ONE_THOUSAND));
    }

    @Test
    public void checkNullPointerExceptionInCheckNegativity() {
        assertThrows(NullPointerException.class, () -> {
            checkNegativityNumber(NULL);
        });
    }

    @Test
    public void compareConvertedOneToNineAndOneToNineSegment() {
        assertEquals(ONE_TO_NINE_SEGMENT, numberSegments(ONE_TO_NINE));
    }

    @Test
    public void compareConvertedOneToNineAndOneToSixSegment() {
        assertNotEquals(ONE_TO_SIX_SEGMENT, numberSegments(ONE_TO_NINE));
    }

    @Test
    public void checkNullPointerExceptionInNumberSegments() {
        assertThrows(NullPointerException.class, () -> {
            numberSegments(NULL);
        });
    }
}