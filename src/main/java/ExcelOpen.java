import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelOpen {
    public String[] excelArray() throws IOException {
        String[] directoryArray;

        FileInputStream fis = null;
        try {
            fis = new FileInputStream("справочник.xls");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert fis != null;
        Workbook wb = new HSSFWorkbook(fis);

        ExcelCellString excelCellString = new ExcelCellString();
        int sizeExcelRow = wb.getSheetAt(0).getLastRowNum() + 1;
        directoryArray = new String[sizeExcelRow];
        for (int i = 0; i < sizeExcelRow; i++) {
            directoryArray[i] = excelCellString.getCellText(wb.getSheetAt(0).getRow(i).getCell(0));
        }
        fis.close();
        return directoryArray;
    }
}