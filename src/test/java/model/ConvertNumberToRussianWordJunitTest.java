package model;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertNumberToRussianWordJunitTest {

    private static String language;
    private static String standardWordsOneHundred;
    private static ConvertNumberToWord convertedOneHundred;
    private static ConvertNumberToWord convertedTen;
    private static ConvertNumberToWord convertOneHundredWithZerosAtBegin;
    private static ConvertNumberToWord convertOneMillionOne;
    private static ConvertNumberToWord convertNullReceived;
    private static ConvertNumberToWord convertTextReceived;
    private static ConvertNumberToWord convertOutOfExcelDirectory;


    @BeforeAll
    public static void createLanguageAndStandardNumber() {
        language = "Rus";
        standardWordsOneHundred = "сто";
    }

    @AfterAll
    public static void clearMemoryTestedClass() {
        convertedOneHundred = null;
        convertedTen = null;
        convertOneHundredWithZerosAtBegin = null;
        convertOneMillionOne = null;
        convertNullReceived = null;
        convertTextReceived = null;
        convertOutOfExcelDirectory = null;
    }

    @Test
    public void compareValueToEqualsThem() {
        convertedOneHundred = new ConvertNumberToWord("100", language);
        String wordAfterConvertedOneHundred = convertedOneHundred.createFinalWord();
        assertEquals(standardWordsOneHundred, wordAfterConvertedOneHundred);
    }

    @Test
    public void compareValuesToNotEqualsThem() {
        convertedTen = new ConvertNumberToWord("10", language);
        String wordAfterConvertedTen = convertedTen.createFinalWord();
        assertNotEquals(standardWordsOneHundred, wordAfterConvertedTen);
    }

    @Test
    public void compareValueWithZeroSignsToEqualsThem() {
        convertOneHundredWithZerosAtBegin = new ConvertNumberToWord("00000100", language);
        String wordAfterConvertedOneHundredWithZerosAtBegin = convertOneHundredWithZerosAtBegin.createFinalWord();
        assertEquals(standardWordsOneHundred, wordAfterConvertedOneHundredWithZerosAtBegin);
    }

    @Test
    public void compareValueWithMaxWithMinNumberToEqualsThem() {
        convertOneMillionOne = new ConvertNumberToWord("1000001", language);
        String wordAfterConvertedOneMillionOne = convertOneMillionOne.createFinalWord();
        assertEquals("один миллион один", wordAfterConvertedOneMillionOne);
    }

    @Test
    public void checkExceptionValueWithNull() {
        convertNullReceived = new ConvertNumberToWord(null, language);
        assertThrows(NullPointerException.class, () -> {
            convertNullReceived.createFinalWord();
        });
    }

    @Test
    public void checkExceptionValueWithNotNumberValue() {
        convertTextReceived = new ConvertNumberToWord("Good morning!!!", language);
        assertThrows(NumberFormatException.class, () -> {
            convertTextReceived.createFinalWord();
        });
    }

    @Test
    public void checkExplosionValueWithNumberWhoOutOfExcelDirectory() {
        convertOutOfExcelDirectory = new ConvertNumberToWord("1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890", language);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            convertOutOfExcelDirectory.createFinalWord();
        });
    }
}