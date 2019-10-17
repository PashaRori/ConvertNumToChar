package util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class ExcelOpen {
    private static final Logger LOGGER = Logger.getLogger(ExcelOpen.class);
    private static final String RUSSIAN = "Rus";
    private static final String RUSSIAN_DIRECTORY = "DirectoryRussianWordsNumber.xls";
    private static final String ENGLISH_DIRECTORY = "DirectoryEnglishWordsNumber.xls";
    private static final String LOG4J_FILE = "log4j.properties";
    private static final String FILE_NOT_FOUND = "File not found";
    private static final String ERROR_INPUT_STREAM = "Error input stream file in workbook";
    private static final String ERROR_CLOSE_STREAM = "Error close stream";

    private ExcelOpen() {
    }

    private static String getDocumentName(String languageConvert) {
        return ((languageConvert.equals(RUSSIAN)) ? RUSSIAN_DIRECTORY : ENGLISH_DIRECTORY);
    }

    public static String convertCell(Cell cell) {
        String resultConvert = null;

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

    private static Workbook openFile(String languageConvert) {
        ClassLoader classLoader = ExcelOpen.class.getClassLoader();
        FileInputStream fileInputStream = null;
        Workbook workbook = null;

        try {
            fileInputStream = new FileInputStream(Objects.requireNonNull(classLoader.getResource(getDocumentName(languageConvert))).getFile());
            try {
                workbook = new HSSFWorkbook(fileInputStream);
            } catch (IOException e) {
                PropertyConfigurator.configure(classLoader.getResource(LOG4J_FILE));
                LOGGER.error(ERROR_INPUT_STREAM);
            } finally {
                try {
                    assert workbook != null;
                    workbook.close();
                } catch (IOException e) {
                    PropertyConfigurator.configure(classLoader.getResource(LOG4J_FILE));
                    LOGGER.error(ERROR_CLOSE_STREAM);
                }
            }
        } catch (FileNotFoundException e) {
            PropertyConfigurator.configure(classLoader.getResource(LOG4J_FILE));
            LOGGER.error(FILE_NOT_FOUND);
        } finally {
            try {
                assert fileInputStream != null;
                fileInputStream.close();
            } catch (IOException e) {
                PropertyConfigurator.configure(classLoader.getResource(LOG4J_FILE));
                LOGGER.error(ERROR_CLOSE_STREAM);
            }
        }
        return workbook;
    }

    public static String[] getArrayWithValues(String languageConvert) {
        Workbook workbook = openFile(languageConvert);
        assert workbook != null;
        int quantityRow = workbook.getSheetAt(0).getLastRowNum() + 1;
        String[] resultArray = new String[quantityRow];

        for (int i = 0; i < quantityRow; i++) {
            resultArray[i] = convertCell(workbook.getSheetAt(0).getRow(i).getCell(0));
        }
        return resultArray;
    }
}