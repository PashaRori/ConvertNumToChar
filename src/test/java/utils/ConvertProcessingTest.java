package utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void compareValueOneHundredTwentyThreeWihThatRussianWord() {
        numberSegment = "123";
        quantityOfNumberClasses = 0;
        language = "Rus";
        expectedNumber = " сто двадцать три";
        actualNumber = ConvertProcessing.createOnRussian(numberSegment, quantityOfNumberClasses, language);
        String actualNumber1 = actualNumber.toString();
        assertEquals(expectedNumber, actualNumber1);
    }

    @Test
    void compareValueOneHundredTwentyThreeThousandWihThatRussianWord() {
        numberSegment = "123";
        quantityOfNumberClasses = 1;
        language = "Rus";
        expectedNumber = " сто двадцать три тысячи";
        actualNumber = ConvertProcessing.createOnRussian(numberSegment, quantityOfNumberClasses, language);
        String actualNumber1 = actualNumber.toString();
        assertEquals(expectedNumber, actualNumber1);
    }

    /*
        @Test
        void createOnRussian() {
            language = "Rus";
            ConvertProcessing.createOnRussian(numberSegment,quantityOfNumberClasses,language);
        }
    */
    @Test
    void compareValueOneHundredTwentyThreeWihThatEnglishWord() {
        numberSegment = "123";
        quantityOfNumberClasses = 0;
        language = "Eng";
        expectedNumber = " one hundred and twenty three";
        actualNumber = ConvertProcessing.createOnEnglish(numberSegment, quantityOfNumberClasses, language);
        String actualNumber1 = actualNumber.toString();
        assertEquals(expectedNumber, actualNumber1);
    }

    @Test
    void compareValueOneHundredTwentyThreeThousandWihThatEnglishWord() {
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
    void createOnEnglish() {
        language = "Eng";
        ConvertProcessing.createOnRussian(numberSegment,quantityOfNumberClasses,language);
    }*/
}