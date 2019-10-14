package ddt;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import services.ConvertNumberToRussianWord;
import utils.ExcelCellValuesToString;
import utils.ExcelOpen;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

import static org.testng.Assert.assertEquals;

public class ConvertNumberToRussianWordDdtTestOnRussian {

    private final static Logger logger = Logger.getLogger(ConvertNumberToRussianWordDdtTestOnRussian.class);

    @Test(dataProvider = "getValuesFromExcel")
    public void compareNumberConvertedToWordsAndWords(String numberConvertedToWords, String referenceWords){
        ConvertNumberToRussianWord convertNumberToRussianWord = new ConvertNumberToRussianWord(numberConvertedToWords,"Rus");
        String convertedValueOfNumberToWords = convertNumberToRussianWord.createFinalRussianWord();
        assertEquals(referenceWords, convertedValueOfNumberToWords);
    }

    @DataProvider
    public Object[][] getValuesFromExcel(){
        ClassLoader classLoader = ExcelOpen.class.getClassLoader();
        FileInputStream fileInputStream = null;
        Workbook workbook = null;

        try {
            fileInputStream = new FileInputStream(Objects.requireNonNull(classLoader.getResource("ExcelDDTTestOnRussian.xls")).getFile());
            try {
                workbook = new HSSFWorkbook(fileInputStream);
            }
            catch (IOException e) {
                logger.error("Error input stream file in workbook");
            }
        }
        catch (FileNotFoundException e) {
            logger.error("File not found");
        }
        Object[][] arrayWithValuesFromExcel = new Object[workbook.getSheetAt(0).getLastRowNum() + 1][2];
        for (int i = 0; i < workbook.getSheetAt(0).getLastRowNum() + 1; i++) {
                arrayWithValuesFromExcel[i][0] = String.valueOf((long)workbook.getSheetAt(0).getRow(i).getCell(0).getNumericCellValue());
                arrayWithValuesFromExcel[i][1] = ExcelCellValuesToString.convertCell(workbook.getSheetAt(0).getRow(i).getCell(1));
        }
        try {
            if (fileInputStream != null) fileInputStream.close();
        }
        catch (Exception e) {
            logger.error("File not closed");
        }
        return arrayWithValuesFromExcel;
    }
}