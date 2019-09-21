import java.io.IOException;

import static java.lang.System.arraycopy;
//Класс в котором происходит заполнение массивов с текстом. Для использования их при сопостовлении с введённым числом
public class NamesArray {
    public String[] arrayTo99() throws IOException {
        ExcelOpen excelOpens = new ExcelOpen();
        String[] directoryArray = excelOpens.excelArray();
        String[] stringTo9 = new String[10];
        String[] stringTo19 = new String[20];
        String[] string20To90 = new String[8];
        String[] stringTo99 = new String[100];
        arraycopy(directoryArray, 0, stringTo9, 0, 10);
        arraycopy(directoryArray, 0, stringTo19, 0, 20);
        arraycopy(directoryArray, 20, string20To90, 0, 8);
        arraycopy(stringTo19, 0, stringTo99, 0, 20);
        for (int i = 20; i < 100; i++) {
            if (i % 10 == 0) {
                stringTo99[i] = string20To90[(i / 10) - 2];
            } else stringTo99[i] = string20To90[(i / 10) - 2] + " " + stringTo9[i % 10];
        }
        return stringTo99;
    }

    public String[] array100To900() throws IOException {
        ExcelOpen excelOpens = new ExcelOpen();
        String[] directoryArray = excelOpens.excelArray();
        String[] string100To900 = new String[9];
        arraycopy(directoryArray, 28, string100To900, 0, 9);
        return string100To900;
    }

    public String[] array1000ToInfinity() throws IOException {
        ExcelOpen excelOpens = new ExcelOpen();
        String[] directoryArray = excelOpens.excelArray();
        int sizeExcelRow = directoryArray.length;
        String[] string1000ToInfinity = new String[sizeExcelRow];
        if (sizeExcelRow - 37 >= 0) arraycopy(directoryArray, 37, string1000ToInfinity, 0, sizeExcelRow - 37);
        return string1000ToInfinity;
    }
}
