package utils;

import static java.lang.System.arraycopy;

public class CreateArraysWithNumbersInWordFormat {

    public static String[] fromZeroToTen(String languageConvert) {
        String[] arrayFromZeroToTen = new String[10];
        arraycopy(ExcelOpen.fillArrayWithValues(languageConvert), 0, arrayFromZeroToTen, 0, 10);
        return arrayFromZeroToTen;
    }

    public static String[] fromZeroToTwenty(String languageConvert) {
        String[] arrayFromZeroToTwenty = new String[20];
        arraycopy(ExcelOpen.fillArrayWithValues(languageConvert), 0, arrayFromZeroToTwenty, 0, 20);
        return arrayFromZeroToTwenty;
    }

    public static String[] fromTwentyToNinety(String languageConvert) {
        String[] arrayFromTwentyToNinety = new String[8];
        arraycopy(ExcelOpen.fillArrayWithValues(languageConvert), 20, arrayFromTwentyToNinety, 0, 8);
        return arrayFromTwentyToNinety;
    }

    public static String[] fromZeroToOneHundred(String languageConvert) {
        String[] arrayFromZeroToOneHundred = new String[100];

        String[] arrayFromZeroToTen = fromZeroToTen(languageConvert);
        String[] arrayFromZeroToTwenty = fromZeroToTwenty(languageConvert);
        String[] arrayFromTwentyToNinety = fromTwentyToNinety(languageConvert);

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

    public static String[] fromOneHundredToOneThousand(String languageConvert) {
        String[] arrayFromOneHundredToNineHundred = new String[9];
        arraycopy(ExcelOpen.fillArrayWithValues(languageConvert), 28, arrayFromOneHundredToNineHundred, 0, 9);
        return arrayFromOneHundredToNineHundred;
    }

    public static String[] fromOneThousandToMaximumAvailableNumber(String languageConvert) {
        String[] arrayFromExcelFile = ExcelOpen.fillArrayWithValues(languageConvert);
        int sizeQuantityRowExcelFile = arrayFromExcelFile.length;
        String[] arrayFromOneThousandToMaximumAvailableNumber = new String[sizeQuantityRowExcelFile - 37];
        arraycopy(arrayFromExcelFile, 37, arrayFromOneThousandToMaximumAvailableNumber, 0, sizeQuantityRowExcelFile - 37);
        return arrayFromOneThousandToMaximumAvailableNumber;
    }
}