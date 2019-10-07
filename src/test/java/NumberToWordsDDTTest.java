import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.apache.poi.ss.usermodel.CellType.NUMERIC;
import static org.junit.jupiter.api.Assertions.*;

public class NumberToWordsDDTTest {

    @Test(dataProvider = "datePro")
    public void convertNumberToWords(String inputTrueLong, String inputThreat) throws IOException {
        NumberToWords numberToWords = new NumberToWords();
        String inputTrue = numberToWords.convertNumberToWords(Long.valueOf(inputTrueLong));
        assertEquals(inputThreat, inputTrue);
    }

    @DataProvider
    public Object[][] datePro() throws IOException {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("ExcelTest.xls");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert fis != null;
        Workbook wb = new HSSFWorkbook(fis);
        ExcelCellString excelCellString = new ExcelCellString();
        Object[][] array = new Object[wb.getSheetAt(0).getLastRowNum() + 1][2];
        for (int i = 0; i < wb.getSheetAt(0).getLastRowNum() + 1; i++) {
            if(wb.getSheetAt(0).getRow(i).getCell(0).getCellType() == NUMERIC){
                array[i][0] = String.valueOf((long)wb.getSheetAt(0).getRow(i).getCell(0).getNumericCellValue());
                array[i][1] = excelCellString.getCellText(wb.getSheetAt(0).getRow(i).getCell(1));
            }
            else{
                array[i][0] = "Не число!!!";
                array[i][1] = excelCellString.getCellText(wb.getSheetAt(0).getRow(i).getCell(1));
            }
        }
        fis.close();
        return array;
    }
}