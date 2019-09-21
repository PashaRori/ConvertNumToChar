import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//Класс в котором происходит открытие "Справочника" из Excel и заполнение массива с информацией из него.
public class ExcelOpen {
    public String[] excelArray() throws IOException {
        String[] directoryArray;
        //открытие файла
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("справочник.xls");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert fis != null;
        Workbook wb = new HSSFWorkbook(fis);
        //заполнеие массива с названиями из файла
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