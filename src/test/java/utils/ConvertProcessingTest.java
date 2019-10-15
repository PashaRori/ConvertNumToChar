package utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConvertProcessingTest {
    private static String numberSegment;
    private static int quantityOfNumberClasses;
    private static String language;
    private static String expectedNumber;
    private static StringBuilder actualNumber;

    @BeforeEach
    public void createMemoryForTest() {
        actualNumber = new StringBuilder();
    }

    @AfterEach
    public void clearMemoryForTest() {
        expectedNumber = null;
        actualNumber = null;
    }

    @Test
    public void compareValueOneHundredTwentyThreeWihThatRussianWord() {
        numberSegment = "123";
        quantityOfNumberClasses = 0;
        language = "Rus";
        expectedNumber = " сто двадцать три";
        actualNumber = ConvertProcessing.createOnRussian(numberSegment, quantityOfNumberClasses, language);
        String actualNumber1 = actualNumber.toString();
        assertEquals(expectedNumber, actualNumber1);
    }

    @Test
    public void compareValueOneHundredTwentyThreeThousandWihThatRussianWord() {
        numberSegment = "123";
        quantityOfNumberClasses = 1;
        language = "Rus";
        expectedNumber = " сто двадцать три тысячи";
        actualNumber = ConvertProcessing.createOnRussian(numberSegment, quantityOfNumberClasses, language);
        String actualNumber1 = actualNumber.toString();
        assertEquals(expectedNumber, actualNumber1);
    }

    @Test
    public void compareValueOneHundredWithThatRussianWord() {
        numberSegment = "100";
        quantityOfNumberClasses = 0;
        language = "Rus";
        expectedNumber = " сто";
        actualNumber = ConvertProcessing.createOnRussian(numberSegment, quantityOfNumberClasses, language);
        String actualNumber1 = actualNumber.toString();
        assertEquals(expectedNumber, actualNumber1);
    }

    @Test
    public void checkExplosionValueWithNumberWhoNullOnRussianMethod() {
        numberSegment = "123";
        quantityOfNumberClasses = 0;
        language = null;
        assertThrows(NullPointerException.class, () -> {
            ConvertProcessing.createOnRussian(numberSegment, quantityOfNumberClasses, language);
        });
    }

    @Test
    public void checkExplosionValueWithNumberWhoNotNumberFormatOnRussianMethod() {
        numberSegment = "MMM";
        quantityOfNumberClasses = 0;
        language = "Rus";
        assertThrows(NumberFormatException.class, () -> {
            ConvertProcessing.createOnRussian(numberSegment, quantityOfNumberClasses, language);
        });
    }

    @Test
    public void compareValueOneHundredTwentyThreeWihThatEnglishWord() {
        numberSegment = "123";
        quantityOfNumberClasses = 0;
        language = "Eng";
        expectedNumber = " one hundred and twenty three";
        actualNumber = ConvertProcessing.createOnEnglish(numberSegment, quantityOfNumberClasses, language);
        String actualNumber1 = actualNumber.toString();
        assertEquals(expectedNumber, actualNumber1);
    }

    @Test
    public void compareValueOneHundredTwentyThreeThousandWithThatEnglishWord() {
        numberSegment = "123";
        quantityOfNumberClasses = 1;
        language = "Eng";
        expectedNumber = " one hundred twenty three thousand";
        actualNumber = ConvertProcessing.createOnEnglish(numberSegment, quantityOfNumberClasses, language);
        String actualNumber1 = actualNumber.toString();
        assertEquals(expectedNumber, actualNumber1);
    }
/*
    @Test
    public void compareValueOneHundredWithThatEnglishWord() {
        numberSegment = "100";
        quantityOfNumberClasses = 0;
        language = "Eng";
        expectedNumber = " one hundred";
        actualNumber = ConvertProcessing.createOnEnglish(numberSegment, quantityOfNumberClasses, language);
        String actualNumber1 = actualNumber.toString();
        assertEquals(expectedNumber, actualNumber1);
    }*/

    @Test
    public void checkExplosionValueWithNumberWhoNullOnEnglishMethod() {
        numberSegment = "123";
        quantityOfNumberClasses = 0;
        language = null;
        assertThrows(NullPointerException.class, () -> {
            ConvertProcessing.createOnEnglish(numberSegment, quantityOfNumberClasses, language);
        });
    }

    @Test
    public void checkExplosionValueWithNumberWhoNotNumberFormatOnEnglishMethod() {
        numberSegment = "MMM";
        quantityOfNumberClasses = 0;
        language = "Eng";
        assertThrows(NumberFormatException.class, () -> {
            ConvertProcessing.createOnEnglish(numberSegment, quantityOfNumberClasses, language);
        });
    }
}