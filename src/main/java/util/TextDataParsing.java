package util;

import static java.lang.System.arraycopy;

public class TextDataParsing {

    private TextDataParsing() {
    }

    private static String[] getArrayZeroToTen(String languageConvert) {
        final String[] arrayFromZeroToTen = new String[10];
        arraycopy(ExcelOpen.getArrayWithValues(languageConvert), 0, arrayFromZeroToTen, 0, 10);
        return arrayFromZeroToTen;
    }

    private static String[] getArrayZeroToTwenty(String languageConvert) {
        final String[] arrayFromZeroToTwenty = new String[20];
        arraycopy(ExcelOpen.getArrayWithValues(languageConvert), 0, arrayFromZeroToTwenty, 0, 20);
        return arrayFromZeroToTwenty;
    }

    private static String[] getArrayTwentyToNinety(String languageConvert) {
        final String[] arrayFromTwentyToNinety = new String[8];
        arraycopy(ExcelOpen.getArrayWithValues(languageConvert), 20, arrayFromTwentyToNinety, 0, 8);
        return arrayFromTwentyToNinety;
    }

    public static String[] getArrayZeroToOneHundred(String languageConvert) {
        String[] arrayFromZeroToOneHundred = new String[100];

        final String[] arrayFromZeroToTen = getArrayZeroToTen(languageConvert);
        final String[] arrayFromZeroToTwenty = getArrayZeroToTwenty(languageConvert);
        final String[] arrayFromTwentyToNinety = getArrayTwentyToNinety(languageConvert);

        for (int i = 0; i < 100; i++) {
            if (i < 20) {
                arrayFromZeroToOneHundred[i] = arrayFromZeroToTwenty[i];
            } else {
                if (i % 10 == 0) {
                    arrayFromZeroToOneHundred[i] = arrayFromTwentyToNinety[(i / 10) - 2];
                } else {
                    arrayFromZeroToOneHundred[i] = arrayFromTwentyToNinety[(i / 10) - 2] + " " + arrayFromZeroToTen[i % 10];
                }
            }
        }
        return arrayFromZeroToOneHundred;
    }

    public static String[] getArrayOneHundredToOneThousand(String languageConvert) {
        final String[] arrayFromOneHundredToNineHundred = new String[9];
        arraycopy(ExcelOpen.getArrayWithValues(languageConvert), 28, arrayFromOneHundredToNineHundred, 0, 9);
        return arrayFromOneHundredToNineHundred;
    }

    public static String[] getArrayOneThousandToMaximumAvailableNumber(String languageConvert) {
        final String[] arrayFromExcelFile = ExcelOpen.getArrayWithValues(languageConvert);
        int sizeQuantityRowExcelFile = arrayFromExcelFile.length;
        final String[] arrayFromOneThousandToMaximumAvailableNumber = new String[sizeQuantityRowExcelFile - 37];
        arraycopy(arrayFromExcelFile, 37, arrayFromOneThousandToMaximumAvailableNumber, 0, sizeQuantityRowExcelFile - 37);
        return arrayFromOneThousandToMaximumAvailableNumber;
    }
}
