package junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.ConvertNumberToEnglishWord;

import static org.junit.jupiter.api.Assertions.*;

class ConvertNumberToEnglishWordJunitTest {

    private String standardWordsOneHundred;
    private ConvertNumberToEnglishWord convertedOneHundred;
    private ConvertNumberToEnglishWord convertedTen;
    private ConvertNumberToEnglishWord convertOneHundredWithZerosAtBegin;
    private ConvertNumberToEnglishWord convertOneMillionOne;
    private ConvertNumberToEnglishWord convertNullReceived;
    private ConvertNumberToEnglishWord convertTextReceived;
    private ConvertNumberToEnglishWord convertOutOfExcelDirectory;


    private String wordAfterConvertedOneHundred;
    private String wordAfterConvertedTen;
    private String wordAfterConvertedOneHundredWithZerosAtBegin;
    private String wordAfterConvertedOneMillionOne;


    @BeforeEach
    void beforeTest() {
        String language = "Rus";
        standardWordsOneHundred = "сто";
        convertedOneHundred = new ConvertNumberToEnglishWord("100", language);
        wordAfterConvertedOneHundred = convertedOneHundred.createFinalEnglishWord();
        convertedTen = new ConvertNumberToEnglishWord("10", language);
        wordAfterConvertedTen = convertedTen.createFinalEnglishWord();
        convertOneHundredWithZerosAtBegin = new ConvertNumberToEnglishWord("00000100", language);
        wordAfterConvertedOneHundredWithZerosAtBegin = convertOneHundredWithZerosAtBegin.createFinalEnglishWord();
        convertOneMillionOne = new ConvertNumberToEnglishWord("1000001", language);
        wordAfterConvertedOneMillionOne = convertOneMillionOne.createFinalEnglishWord();
        convertNullReceived = new ConvertNumberToEnglishWord(null, language);
        convertTextReceived = new ConvertNumberToEnglishWord("Good morning!!!", language);
        convertOutOfExcelDirectory = new ConvertNumberToEnglishWord("1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890", language);
    }

    @AfterEach
    void clearMemoryTestedClass() {
        convertedOneHundred = null;
        convertedTen = null;
        convertOneHundredWithZerosAtBegin = null;
        convertOneMillionOne = null;
        convertNullReceived = null;
        convertTextReceived = null;
        convertOutOfExcelDirectory = null;
    }

    @Test
    void compareValueToConcurrenceThem() {
        assertEquals(standardWordsOneHundred, wordAfterConvertedOneHundred);
    }

    @Test
    void compareValuesToMismatchThem() {
        assertNotEquals(standardWordsOneHundred, wordAfterConvertedTen);
    }

    @Test
    void compareValueWithZeroSigns() {
        assertEquals(standardWordsOneHundred, wordAfterConvertedOneHundredWithZerosAtBegin);
    }

    @Test
    void compareMaxWithMinNumber() {
        assertEquals("один миллион один", wordAfterConvertedOneMillionOne);
    }

    @Test
    void checkExceptionByNullValue() {
        assertThrows(NullPointerException.class, () -> {
            convertNullReceived.createFinalEnglishWord();
        });
    }

    @Test
    void checkExceptionOfNotNumberValue() {
        assertThrows(NumberFormatException.class, () -> {
            convertTextReceived.createFinalEnglishWord();
        });
    }

    @Test
    void checkExplosionOutOfExcelDirectory() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            convertOutOfExcelDirectory.createFinalEnglishWord();
        });
    }
}