import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static org.apache.poi.ss.usermodel.CellType.NUMERIC;
import static org.junit.jupiter.api.Assertions.*;

public class NumToCharTest {

    //ddt тест
    @Test(dataProvider = "datePro")
    public void convertNumToString(String inputTrueLong, String inputThreat) throws IOException {
        NumToChar numToChar = new NumToChar();
        String inputTrue = numToChar.convertNumToString(Long.valueOf(inputTrueLong));
        assertEquals(inputThreat, inputTrue);
    }

    //junit тест
    @Test
    void convertNumToCharUnit() throws IOException {
        FileInputStream fis = new FileInputStream("ExcelTest.xls");
        Workbook wb = new HSSFWorkbook(fis);
        NumToChar numToChar = new NumToChar();
        ExcelCellString excelCellString = new ExcelCellString();

        for (int i = 1; i < wb.getSheetAt(0).getLastRowNum() + 1; i++) {
            String inputTrueUnit = numToChar.convertNumToString((long)wb.getSheetAt(0).getRow(i).getCell(0).getNumericCellValue());
            String inputThreatUnit = " " + excelCellString.getCellText(wb.getSheetAt(0).getRow(i).getCell(1));
            assertEquals(inputThreatUnit, inputTrueUnit);
        }
        fis.close();
    }

    @DataProvider
    public Object[][] datePro() throws IOException {
        FileInputStream fis = new FileInputStream("ExcelTest.xls");
        Workbook wb = new HSSFWorkbook(fis);
        ExcelCellString excelCellString = new ExcelCellString();
        Object[][] array = new Object[wb.getSheetAt(0).getLastRowNum() + 1][2];
        for (int i = 0; i < wb.getSheetAt(0).getLastRowNum() + 1; i++) {
            if(wb.getSheetAt(0).getRow(i).getCell(0).getCellType() == NUMERIC){
                array[i][0] = String.valueOf((long)wb.getSheetAt(0).getRow(i).getCell(0).getNumericCellValue());
                array[i][1] = " " + excelCellString.getCellText(wb.getSheetAt(0).getRow(i).getCell(1));
            }
            else{
                array[i][0] = "Не число!!!";
                array[i][1] = " " + excelCellString.getCellText(wb.getSheetAt(0).getRow(i).getCell(1));
            }
        }
        fis.close();
        return array;
    }
}