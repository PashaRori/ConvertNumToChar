package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;

public class ExcelCellValuesToString {

    public static String convertCell(Cell cell){
        String resultConvert = "";
        switch (cell.getCellType()) {
            case STRING:
                resultConvert = cell.getRichStringCellValue().getString();
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    resultConvert = cell.getDateCellValue().toString();
                } else {
                    resultConvert = Double.toString(cell.getNumericCellValue());
                }
                break;
            case BOOLEAN:
                resultConvert = Boolean.toString(cell.getBooleanCellValue());
                break;
            case FORMULA:
                resultConvert = cell.getCellFormula();
                break;
            default:
                break;
        }
        return resultConvert;
    }
}