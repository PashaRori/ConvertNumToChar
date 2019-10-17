package model;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelOpen;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

import static org.testng.Assert.assertEquals;

public class ConvertNumberToWordDDTTestTEst {

    private final static Logger LOGGER = Logger.getLogger(ConvertNumberToWordDDTTestTEst.class);

    @DataProvider
    public Object[][] getValuesFromRussianExcel() {
        ClassLoader classLoader = ExcelOpen.class.getClassLoader();
        FileInputStream fileInputStream = null;
        Workbook workbook = null;

        try {
            fileInputStream = new FileInputStream(Objects.requireNonNull(classLoader.getResource("ExcelDDTTestOnRussian.xls")).getFile());
            try {
                workbook = new HSSFWorkbook(fileInputStream);
            } catch (IOException e) {
                LOGGER.error("Error input stream file in workbook");
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("File not found");
        }
        Object[][] arrayWithValuesFromExcel = new Object[workbook.getSheetAt(0).getLastRowNum() + 1][2];
        for (int i = 0; i < workbook.getSheetAt(0).getLastRowNum() + 1; i++) {
            arrayWithValuesFromExcel[i][0] = String.valueOf((long) workbook.getSheetAt(0).getRow(i).getCell(0).getNumericCellValue());
            arrayWithValuesFromExcel[i][1] = String.valueOf(workbook.getSheetAt(0).getRow(i).getCell(1));
        }
        try {
            if (fileInputStream != null) fileInputStream.close();
        } catch (Exception e) {
            LOGGER.error("File not closed");
        }
        return arrayWithValuesFromExcel;
    }

    @DataProvider
    public Object[][] getValuesFromEnglishExcel() {
        ClassLoader classLoader = ExcelOpen.class.getClassLoader();
        FileInputStream fileInputStream = null;
        Workbook workbook = null;

        try {
            fileInputStream = new FileInputStream(Objects.requireNonNull(classLoader.getResource("ExcelDDTTestOnEnglish.xls")).getFile());
            try {
                workbook = new HSSFWorkbook(fileInputStream);
            } catch (IOException e) {
                LOGGER.error("Error input stream file in workbook");
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("File not found");
        }
        Object[][] arrayWithValuesFromExcel = new Object[workbook.getSheetAt(0).getLastRowNum() + 1][2];
        for (int i = 0; i < workbook.getSheetAt(0).getLastRowNum() + 1; i++) {
            arrayWithValuesFromExcel[i][0] = String.valueOf((long) workbook.getSheetAt(0).getRow(i).getCell(0).getNumericCellValue());
            arrayWithValuesFromExcel[i][1] = String.valueOf(workbook.getSheetAt(0).getRow(i).getCell(1));
        }
        try {
            if (fileInputStream != null) fileInputStream.close();
        } catch (Exception e) {
            LOGGER.error("File not closed");
        }
        return arrayWithValuesFromExcel;
    }

    @Test(dataProvider = "getValuesFromRussianExcel")
    public void compareNumberConvertedToWordsAndWordsOnRussian(String numberConvertedToWords, String referenceWords) {
        ConvertNumberToWord convertNumberToWord = new ConvertNumberToWord(numberConvertedToWords, "Rus");
        String convertedValueOfNumberToWords = convertNumberToWord.createFinalWord();
        assertEquals(referenceWords, convertedValueOfNumberToWords);
    }

    @Test(dataProvider = "getValuesFromEnglishExcel")
    public void compareNumberConvertedToWordsAndWordsOnEnglish(String numberConvertedToWords, String referenceWords) {
        ConvertNumberToWord convertNumberToWord = new ConvertNumberToWord(numberConvertedToWords, "Eng");
        String convertedValueOfNumberToWords = convertNumberToWord.createFinalWord();
        assertEquals(referenceWords, convertedValueOfNumberToWords);
    }
}