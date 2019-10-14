package utils;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class ExcelOpen {

    private static final Logger logger = Logger.getLogger(ExcelOpen.class);

    public static String providingDocumentName(String languageConvert) {
        String documentName;
        if (languageConvert.equals("Rus")) {
            documentName = "DirectoryRusWordsNumber.xls";
        } else {
            documentName = "DirectoryEngWordsNumber.xls";
        }
        return documentName;
    }

    public static Workbook openFile(String languageConvert) {
        ClassLoader classLoader = ExcelOpen.class.getClassLoader();
        Workbook workbook = null;
        try{
            FileInputStream  fileInputStream = new FileInputStream(Objects.requireNonNull(classLoader.getResource(providingDocumentName(languageConvert))).getFile());
            workbook = new HSSFWorkbook(fileInputStream);
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            logger.error("File not found");
        } catch (IOException e) {
            logger.error("Error input stream file in workbook");
        }
        return workbook;
    }

    public static String[] fillArrayWithValues(String directoryExcelName) {
        Workbook workbook = openFile(directoryExcelName);
        int quantityRow = workbook.getSheetAt(0).getLastRowNum() + 1;
        String[] resultArray = new String[quantityRow];
        for (int i = 0; i < quantityRow; i++) {
            resultArray[i] = ExcelCellValuesToString.convertCell(workbook.getSheetAt(0).getRow(i).getCell(0));
        }
        return resultArray;
    }
}