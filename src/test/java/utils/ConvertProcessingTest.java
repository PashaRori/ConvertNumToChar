package utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConvertProcessingTest {
    private static final String ONE_HUNDRED_TWENTY_THREE = "123";
    private static final String ONE_HUNDRED_TWENTY_THREE_RUSSIAN_WORD = " сто двадцать три";
    private static final String ONE_HUNDRED_TWENTY_THREE_ENGLISH_WORD = " one hundred and twenty three";
    private static final String ONE_HUNDRED_TWENTY_THREE_THOUSAND_RUSSIAN_WORD = " сто двадцать три тысячи";
    private static final String ONE_HUNDRED_TWENTY_THREE_THOUSAND_ENGLISH_WORD = " one hundred twenty three thousand";
    private static final String ONE_HUNDRED = "100";
    private static final String ONE_HUNDRED_RUSSIAN_WORD = " сто";
    private static final String ONE_HUNDRED_ENGLISH_WORD = " one hundred";
    private static final String LANGUAGE_RUSSIAN = "Rus";
    private static final String LANGUAGE_ENGLISH = "Eng";
    private static final String NULL = null;
    private static final String NOT_NUMBER_FORMAT = "MMM";
    private static final int UNIT_CLASSES = 0;
    private static final int THOUSAND_CLASSES = 1;
    private static StringBuilder actualNumber;

    @BeforeEach
    public void createMemoryForTest() {
        actualNumber = new StringBuilder();
    }

    @AfterEach
    public void clearMemoryForTest() {
        actualNumber = null;
    }

    @Test
    public void compareValueOneHundredTwentyThreeWihThatRussianWord() {
        actualNumber = ConvertProcessing.createOnRussian(ONE_HUNDRED_TWENTY_THREE, UNIT_CLASSES, LANGUAGE_RUSSIAN);
        assertEquals(ONE_HUNDRED_TWENTY_THREE_RUSSIAN_WORD, actualNumber.toString());
    }

    @Test
    public void compareValueOneHundredTwentyThreeThousandWihThatRussianWord() {
        actualNumber = ConvertProcessing.createOnRussian(ONE_HUNDRED_TWENTY_THREE, THOUSAND_CLASSES, LANGUAGE_RUSSIAN);
        assertEquals(ONE_HUNDRED_TWENTY_THREE_THOUSAND_RUSSIAN_WORD, actualNumber.toString());
    }

    @Test
    public void compareValueOneHundredWithThatRussianWord() {
        actualNumber = ConvertProcessing.createOnRussian(ONE_HUNDRED, UNIT_CLASSES, LANGUAGE_RUSSIAN);
        assertEquals(ONE_HUNDRED_RUSSIAN_WORD, actualNumber.toString());
    }

    @Test
    public void checkExplosionValueWithNumberWhoNullOnRussianMethod() {
        assertThrows(AssertionError.class, () -> {
            ConvertProcessing.createOnRussian(ONE_HUNDRED_TWENTY_THREE, UNIT_CLASSES, NULL);
        });
    }

    @Test
    public void checkExplosionValueWithNumberWhoNotNumberFormatOnRussianMethod() {
        assertThrows(NumberFormatException.class, () -> {
            ConvertProcessing.createOnRussian(NOT_NUMBER_FORMAT, UNIT_CLASSES, LANGUAGE_RUSSIAN);
        });
    }

    @Test
    public void compareValueOneHundredTwentyThreeWihThatEnglishWord() {
        actualNumber = ConvertProcessing.createOnEnglish(ONE_HUNDRED_TWENTY_THREE, UNIT_CLASSES, LANGUAGE_ENGLISH);
        assertEquals(ONE_HUNDRED_TWENTY_THREE_ENGLISH_WORD, actualNumber.toString());
    }

    @Test
    public void compareValueOneHundredTwentyThreeThousandWithThatEnglishWord() {
        actualNumber = ConvertProcessing.createOnEnglish(ONE_HUNDRED_TWENTY_THREE, THOUSAND_CLASSES, LANGUAGE_ENGLISH);
        assertEquals(ONE_HUNDRED_TWENTY_THREE_THOUSAND_ENGLISH_WORD, actualNumber.toString());
    }

    @Test
    public void compareValueOneHundredWithThatEnglishWord() {
        actualNumber = ConvertProcessing.createOnEnglish(ONE_HUNDRED, UNIT_CLASSES, LANGUAGE_ENGLISH);
        assertEquals(ONE_HUNDRED_ENGLISH_WORD, actualNumber.toString());
    }

    @Test
    public void checkExplosionValueWithNumberWhoNullOnEnglishMethod() {
        assertThrows(AssertionError.class, () -> {
            ConvertProcessing.createOnEnglish(ONE_HUNDRED_TWENTY_THREE, UNIT_CLASSES, NULL);
        });
    }

    @Test
    public void checkExplosionValueWithNumberWhoNotNumberFormatOnEnglishMethod() {
        assertThrows(NumberFormatException.class, () -> {
            ConvertProcessing.createOnEnglish(NOT_NUMBER_FORMAT, UNIT_CLASSES, LANGUAGE_ENGLISH);
        });
    }
}