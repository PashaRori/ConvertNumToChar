package utils;

public class FillingWordWithCertainParameters {

    public static String forHundred(int hundredOfNumber, String languageConvert){
        String[] arrayFromOneHundredToNineHundred = CreateArraysWithNumbersInWordFormat.fromOneHundredToOneThousand(languageConvert);
        String hundredOfWords;
        if (hundredOfNumber == 0) {
            hundredOfWords = "";
        } else {
            hundredOfWords = " " + arrayFromOneHundredToNineHundred[hundredOfNumber - 1];
        }
        return hundredOfWords;
    }

    public static String forDozen(int hundredOfNumber, int dozenOfNumber, String languageConvert){
        String[] arrayFromZeroToOneHundred = CreateArraysWithNumbersInWordFormat.fromZeroToOneHundred(languageConvert);
        String dozenOfWords;
        if (hundredOfNumber > 0 && dozenOfNumber == 0) {
            dozenOfWords = "";
        } else {
            dozenOfWords = " " + arrayFromZeroToOneHundred[dozenOfNumber];
        }
        return dozenOfWords;
    }

    public static StringBuilder forHundredEndingOnRussian(int hundredOfNumber, int dozenOfNumber, String dozenFromWords, String hundredFromWords, int sizeInputNumber) {
        StringBuilder hundredEnding = new StringBuilder();

        if (hundredOfNumber == 0 && dozenOfNumber == 0) {
            if (sizeInputNumber == 0) {
                hundredEnding.append(hundredFromWords).append(dozenFromWords);
            }
        } else {
            hundredEnding.append(hundredFromWords).append(dozenFromWords);
        }
        return hundredEnding;
    }

    public static StringBuilder forHundredEndingOnEnglish(int hundredOfNumber, int dozenOfNumber, String dozenFromWords, String hundredFromWords, int sizeInputNumber) {
        StringBuilder hundredEnding = new StringBuilder();

        if (hundredOfNumber == 0 && dozenOfNumber == 0) {
            if (sizeInputNumber == 0) {
                hundredEnding.append(hundredFromWords).append(dozenFromWords);
            }
        } else {
            hundredEnding.append(hundredFromWords).append(" and").append(dozenFromWords);
        }
        return hundredEnding;
    }

    public static StringBuilder forThousandEndingOnRussian(int unitOfNumber, int dozenOfNumber, int quantityTriplesNumber, String dozenFromWords, String hundredFromWords, String languageConvert) {
        StringBuilder thousandEnding = new StringBuilder();
        String[] arrayFromOneThousandToMaximumAvailableNumber = CreateArraysWithNumbersInWordFormat.fromOneThousandToMaximumAvailableNumber(languageConvert);

        if (dozenOfNumber > 10 && dozenOfNumber < 20) {
            thousandEnding.append(hundredFromWords).append(dozenFromWords).append(" ").append(arrayFromOneThousandToMaximumAvailableNumber[quantityTriplesNumber - 1]);
        } else {
            if (unitOfNumber == 1) {
                thousandEnding.append(hundredFromWords).append(" одна ").append(arrayFromOneThousandToMaximumAvailableNumber[quantityTriplesNumber - 1]).append("а");
            }
            if (unitOfNumber == 2) {
                thousandEnding.append(hundredFromWords).append(" две ").append(arrayFromOneThousandToMaximumAvailableNumber[quantityTriplesNumber - 1]).append("и");
            }
            if (unitOfNumber > 2 && unitOfNumber < 5) {
                thousandEnding.append(hundredFromWords).append(dozenFromWords).append(" ").append(arrayFromOneThousandToMaximumAvailableNumber[quantityTriplesNumber - 1]).append("и");
            }
            if (unitOfNumber >= 5 || unitOfNumber == 0) {
                thousandEnding.append(hundredFromWords).append(dozenFromWords).append(" ").append(arrayFromOneThousandToMaximumAvailableNumber[quantityTriplesNumber - 1]);
            }
        }
        return thousandEnding;
    }

    public static StringBuilder forExponentialNumberEndingOnRussian(int unitOfNumber, int dozenOfNumber, int quantityTriplesNumber, String dozenFromWords, String hundredFromWords, String languageConvert) {
        StringBuilder exponentialNumberEnding = new StringBuilder();
        String[] arrayFromOneThousandToMaximumAvailableNumber = CreateArraysWithNumbersInWordFormat.fromOneThousandToMaximumAvailableNumber(languageConvert);
        if (dozenOfNumber > 10 && dozenOfNumber < 20) {
            exponentialNumberEnding.append(hundredFromWords).append(dozenFromWords).append(" ").append(arrayFromOneThousandToMaximumAvailableNumber[quantityTriplesNumber - 1]).append("ов");
        } else {
            if (unitOfNumber == 1) {
                exponentialNumberEnding.append(hundredFromWords).append(dozenFromWords).append(" ").append(arrayFromOneThousandToMaximumAvailableNumber[quantityTriplesNumber - 1]);
            }
            if (unitOfNumber > 1 && unitOfNumber < 5) {
                exponentialNumberEnding.append(hundredFromWords).append(dozenFromWords).append(" ").append(arrayFromOneThousandToMaximumAvailableNumber[quantityTriplesNumber - 1]).append("а");
            }
            if (unitOfNumber >= 5 || unitOfNumber == 0) {
                exponentialNumberEnding.append(hundredFromWords).append(dozenFromWords).append(" ").append(arrayFromOneThousandToMaximumAvailableNumber[quantityTriplesNumber - 1]).append("ов");
            }
        }
        return exponentialNumberEnding;
    }

    public static StringBuilder forExponentialEndingOnEnglish(int quantityTriplesNumber, String dozenFromWords, String hundredFromWords, String languageConvert) {
        StringBuilder exponentialNumberEnding = new StringBuilder();
        String[] arrayFromOneThousandToMaximumAvailableNumber = CreateArraysWithNumbersInWordFormat.fromOneThousandToMaximumAvailableNumber(languageConvert);
        exponentialNumberEnding.append(hundredFromWords).append(dozenFromWords).append(" ").append(arrayFromOneThousandToMaximumAvailableNumber[quantityTriplesNumber - 1]);
        return exponentialNumberEnding;
    }
}
