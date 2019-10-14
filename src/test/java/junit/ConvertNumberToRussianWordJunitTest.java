package junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.ConvertNumberToRussianWord;

import static org.junit.jupiter.api.Assertions.*;

class ConvertNumberToRussianWordJunitTest {

    private String standardWordsOneHundred;
    private ConvertNumberToRussianWord convertedOneHundred;
    private ConvertNumberToRussianWord convertedTen;
    private ConvertNumberToRussianWord convertOneHundredWithZerosAtBegin;
    private ConvertNumberToRussianWord convertOneMillionOne;
    private ConvertNumberToRussianWord convertNullReceived;
    private ConvertNumberToRussianWord convertTextReceived;
    private ConvertNumberToRussianWord convertOutOfExcelDirectory;


    private String wordAfterConvertedOneHundred;
    private String wordAfterConvertedTen;
    private String wordAfterConvertedOneHundredWithZerosAtBegin;
    private String wordAfterConvertedOneMillionOne;


    @BeforeEach
    void beforeTest() {
        String language = "Rus";
        standardWordsOneHundred = "сто";
        convertedOneHundred = new ConvertNumberToRussianWord("100", language);
        wordAfterConvertedOneHundred = convertedOneHundred.createFinalWord();
        convertedTen = new ConvertNumberToRussianWord("10", language);
        wordAfterConvertedTen = convertedTen.createFinalWord();
        convertOneHundredWithZerosAtBegin = new ConvertNumberToRussianWord("00000100", language);
        wordAfterConvertedOneHundredWithZerosAtBegin = convertOneHundredWithZerosAtBegin.createFinalWord();
        convertOneMillionOne = new ConvertNumberToRussianWord("1000001", language);
        wordAfterConvertedOneMillionOne = convertOneMillionOne.createFinalWord();
        convertNullReceived = new ConvertNumberToRussianWord(null, language);
        convertTextReceived = new ConvertNumberToRussianWord("Good morning!!!", language);
        convertOutOfExcelDirectory = new ConvertNumberToRussianWord("1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890", language);
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
            convertNullReceived.createFinalWord();
        });
    }

    @Test
    void checkExceptionOfNotNumberValue() {
        assertThrows(NumberFormatException.class, () -> {
            convertTextReceived.createFinalWord();
        });
    }

    @Test
    void checkExplosionOutOfExcelDirectory() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            convertOutOfExcelDirectory.createFinalWord();
        });
    }
}