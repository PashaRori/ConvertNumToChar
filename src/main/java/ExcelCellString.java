import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
//Определение и последующее приобразование типа ячейки Excel в String
public class ExcelCellString {
    public static String getCellText(Cell cell)
    {
        String rezult = "";
        switch (cell.getCellType()) {
            case STRING:
                rezult = cell.getRichStringCellValue().getString();
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    rezult = cell.getDateCellValue().toString();
                } else {
                    rezult = Double.toString(cell.getNumericCellValue());
                }
                break;
            case BOOLEAN:
                rezult = Boolean.toString(cell.getBooleanCellValue());
                break;
            case FORMULA:
                rezult = cell.getCellFormula();
                break;
            default:
                break;
        }
        return rezult;
    }
}