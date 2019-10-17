package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertNumberToRussianWord {
    private static final String LANGUAGE = "Rus";
    private static final String ONE_HUNDRED = "100";
    private static final String ONE_HUNDRED_WORD = "сто";
    private static final String TEN = "10";
    private static final String ONE_HUNDRED_WITH_ZEROS_AT_BEGIN = "00000100";
    private static final String ONE_MILLION_ONE = "1000001";
    private static final String ONE_MILLION_ONE_WORD = "один миллион один";
    private static final String NULL = null;
    private static final String NOT_NUMBER_VALUE = "Доброе Утро!!!";
    private static final String NUMBER_WHO_OUT_OF_EXCEL_DIRECTORY = "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890";
    private static ConvertNumberToWord convertedOneHundred;
    private static ConvertNumberToWord convertedTen;
    private static ConvertNumberToWord convertOneHundredWithZerosAtBegin;
    private static ConvertNumberToWord convertOneMillionOne;
    private static ConvertNumberToWord convertNullReceived;
    private static ConvertNumberToWord convertTextReceived;
    private static ConvertNumberToWord convertOutOfExcelDirectory;

    @BeforeAll
    public static void createMemoryToClass() {
        convertedOneHundred = new ConvertNumberToWord(ONE_HUNDRED, LANGUAGE);
        convertedTen = new ConvertNumberToWord(TEN, LANGUAGE);
        convertOneHundredWithZerosAtBegin = new ConvertNumberToWord(ONE_HUNDRED_WITH_ZEROS_AT_BEGIN, LANGUAGE);
        convertOneMillionOne = new ConvertNumberToWord(ONE_MILLION_ONE, LANGUAGE);
    }

    @Test
    public void compareConvertedOneHundredAndOneHundredTheWord() {
        assertEquals(ONE_HUNDRED_WORD, convertedOneHundred.createFinalWord());
    }

    @Test
    public void compareConvertedTendAndOneHundredTheWord() {
        assertNotEquals(ONE_HUNDRED_WORD, convertedTen.createFinalWord());
    }

    @Test
    public void compareConvertedOneHundredWithZeroSignsAndOneHundredTheWord() {
        assertEquals(ONE_HUNDRED_WORD, convertOneHundredWithZerosAtBegin.createFinalWord());
    }

    @Test
    public void compareConvertedOneMillionOneAndOneMillionOneTheWord() {
        assertEquals(ONE_MILLION_ONE_WORD, convertOneMillionOne.createFinalWord());
    }

    @Test
    public void checkNullPointerExceptionWithNullValue() {
        convertNullReceived = new ConvertNumberToWord(NULL, LANGUAGE);
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            convertNullReceived.createFinalWord();
        });
    }

    @Test
    public void checkNumberFormatExceptionWithNotNumberValue() {
        convertTextReceived = new ConvertNumberToWord(NOT_NUMBER_VALUE, LANGUAGE);
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            convertTextReceived.createFinalWord();
        });
    }

    @Test
    public void checkArrayIndexOutOfBoundsExceptionWithNumberOutedOfBoundsExcel() {
        convertOutOfExcelDirectory = new ConvertNumberToWord(NUMBER_WHO_OUT_OF_EXCEL_DIRECTORY, LANGUAGE);
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            convertOutOfExcelDirectory.createFinalWord();
        });
    }
}