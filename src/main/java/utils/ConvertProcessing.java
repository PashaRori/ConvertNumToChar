package utils;

public class ConvertProcessing {
    private final static String ZEROS = "000";
    private final static String EMPTY = "";
    private final static String STRING = " ";
    private final static String AND = " and";
    private final static String ONE = " одна ";
    private final static String TWO = " две ";
    private final static String OF = "ов";
    private final static String A = "а";
    private final static String I = "и";
    private static int hundredOfNumber;
    private static int dozenOfNumber;
    private static int unitOfNumber;
    private static String hundredFromWords;
    private static String dozenFromWords;

    private ConvertProcessing() {
    }

    private static void getNumberAndWordFromSegment(String receivedSegment, String languageConvert) {
        int numberSegment = Integer.parseInt(receivedSegment);
        hundredOfNumber = numberSegment / 100;
        hundredFromWords = forHundred(languageConvert);
        dozenOfNumber = numberSegment % 100;
        dozenFromWords = forDozen(languageConvert);
        unitOfNumber = numberSegment % 10;
    }

    public static StringBuilder createOnRussian(String receivedSegment, int quantityOfNumberClasses, String languageConvert) {
        StringBuilder resultCreateWord = new StringBuilder();

        getNumberAndWordFromSegment(receivedSegment, languageConvert);

        if (quantityOfNumberClasses == 0 && !receivedSegment.equals(ZEROS)) {
            resultCreateWord.append(forHundredEndingOnRussian(quantityOfNumberClasses));
        }
        if ((hundredOfNumber != 0 || dozenOfNumber != 0) && quantityOfNumberClasses > 0) {
            if (quantityOfNumberClasses == 1) {
                resultCreateWord.append(forThousandEndingOnRussian(quantityOfNumberClasses, languageConvert));
            }
            if (quantityOfNumberClasses > 1) {
                resultCreateWord.append(forExponentialNumberEndingOnRussian(quantityOfNumberClasses, languageConvert));
            }
        }
        return resultCreateWord;
    }


    public static StringBuilder createOnEnglish(String receivedSegment, int quantityOfNumberClasses, String languageConvert) {
        StringBuilder resultCreateWord = new StringBuilder();

        getNumberAndWordFromSegment(receivedSegment, languageConvert);

        if (quantityOfNumberClasses == 0 && !receivedSegment.equals(ZEROS)) {
            resultCreateWord.append(forHundredEndingOnEnglish(quantityOfNumberClasses));
        }
        if ((hundredOfNumber != 0 || dozenOfNumber != 0) && quantityOfNumberClasses > 0) {
            resultCreateWord.append(forExponentialEndingOnEnglish(quantityOfNumberClasses, languageConvert));
        }
        return resultCreateWord;
    }

    private static String forHundred(String languageConvert) {
        final String[] arrayFromOneHundredToNineHundred = TextDataParsing.fromOneHundredToOneThousand(languageConvert);
        return ((hundredOfNumber == 0) ? "" : STRING + arrayFromOneHundredToNineHundred[hundredOfNumber - 1]);
    }

    private static String forDozen(String languageConvert) {
        final String[] arrayFromZeroToOneHundred = TextDataParsing.fromZeroToOneHundred(languageConvert);
        return ((hundredOfNumber > 0 && dozenOfNumber == 0) ? EMPTY : STRING + arrayFromZeroToOneHundred[dozenOfNumber]);
    }

    private static StringBuilder forHundredEndingOnRussian(int sizeInputNumber) {
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

    private static StringBuilder forHundredEndingOnEnglish(int sizeInputNumber) {
        StringBuilder hundredEnding = new StringBuilder();

        if (hundredOfNumber == 0 && dozenOfNumber == 0) {
            if (sizeInputNumber == 0) {
                hundredEnding.append(hundredFromWords).append(dozenFromWords);
            }
        } else {
            if (dozenOfNumber != 0) {
                hundredEnding.append(hundredFromWords).append(AND).append(dozenFromWords);
            } else {
                hundredEnding.append(hundredFromWords).append(dozenFromWords);
            }
        }
        return hundredEnding;
    }

    private static StringBuilder forThousandEndingOnRussian(int quantityOfNumberClasses, String languageConvert) {
        StringBuilder thousandEnding = new StringBuilder();
        final String[] arrayFromOneThousandToMaximumAvailableNumber = TextDataParsing.fromOneThousandToMaximumAvailableNumber(languageConvert);
        final String valueFromArray = arrayFromOneThousandToMaximumAvailableNumber[quantityOfNumberClasses - 1];

        if (dozenOfNumber > 10 && dozenOfNumber < 20) {
            thousandEnding.append(hundredFromWords).append(dozenFromWords).append(STRING).append(valueFromArray);
        } else {
            if (unitOfNumber == 1) {
                thousandEnding.append(hundredFromWords).append(ONE).append(valueFromArray).append(A);
            }
            if (unitOfNumber == 2) {
                thousandEnding.append(hundredFromWords).append(TWO).append(valueFromArray).append(I);
            }
            if (unitOfNumber > 2 && unitOfNumber < 5) {
                thousandEnding.append(hundredFromWords).append(dozenFromWords).append(STRING).append(valueFromArray).append(I);
            }
            if (unitOfNumber >= 5 || unitOfNumber == 0) {
                thousandEnding.append(hundredFromWords).append(dozenFromWords).append(STRING).append(valueFromArray);
            }
        }
        return thousandEnding;
    }

    private static StringBuilder forExponentialNumberEndingOnRussian(int quantityOfNumberClasses, String languageConvert) {
        StringBuilder exponentialNumberEnding = new StringBuilder();
        final String[] arrayFromOneThousandToMaximumAvailableNumber = TextDataParsing.fromOneThousandToMaximumAvailableNumber(languageConvert);
        final String valueFromArray = arrayFromOneThousandToMaximumAvailableNumber[quantityOfNumberClasses - 1];

        if (dozenOfNumber > 10 && dozenOfNumber < 20) {
            exponentialNumberEnding.append(hundredFromWords).append(dozenFromWords).append(STRING).append(valueFromArray).append(OF);
        } else {
            if (unitOfNumber == 1) {
                exponentialNumberEnding.append(hundredFromWords).append(dozenFromWords).append(STRING).append(valueFromArray);
            }
            if (unitOfNumber > 1 && unitOfNumber < 5) {
                exponentialNumberEnding.append(hundredFromWords).append(dozenFromWords).append(STRING).append(valueFromArray).append(A);
            }
            if (unitOfNumber >= 5 || unitOfNumber == 0) {
                exponentialNumberEnding.append(hundredFromWords).append(dozenFromWords).append(STRING).append(valueFromArray).append(OF);
            }
        }
        return exponentialNumberEnding;
    }

    private static StringBuilder forExponentialEndingOnEnglish(int quantityOfNumberClasses, String languageConvert) {
        StringBuilder exponentialNumberEnding = new StringBuilder();
        final String[] arrayFromOneThousandToMaximumAvailableNumber = TextDataParsing.fromOneThousandToMaximumAvailableNumber(languageConvert);
        exponentialNumberEnding.append(hundredFromWords).append(dozenFromWords).append(STRING)
                .append(arrayFromOneThousandToMaximumAvailableNumber[quantityOfNumberClasses - 1]);
        return exponentialNumberEnding;
    }
}
