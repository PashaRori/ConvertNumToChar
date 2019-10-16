package utils;

public class ConvertProcessing {
    private final static String zeros = "000";
    private final static String space = " ";
    private final static String and = " and";
    private final static String one = " одна ";
    private final static String two = " две ";
    private final static String of = "ов";
    private final static String a = "а";
    private final static String i = "и";
    private static int hundredOfNumber;
    private static int dozenOfNumber;
    private static int unitOfNumber;
    private static String hundredFromWords;
    private static String dozenFromWords;

    private ConvertProcessing(){}

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

        if (quantityOfNumberClasses == 0 && !receivedSegment.equals(zeros)) {
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

        if (quantityOfNumberClasses == 0 && !receivedSegment.equals(zeros)) {
            resultCreateWord.append(forHundredEndingOnEnglish(quantityOfNumberClasses));
        }
        if ((hundredOfNumber != 0 || dozenOfNumber != 0) && quantityOfNumberClasses > 0) {
            resultCreateWord.append(forExponentialEndingOnEnglish(quantityOfNumberClasses, languageConvert));
        }
        return resultCreateWord;
    }

    private static String forHundred(String languageConvert) {
        final String[] arrayFromOneHundredToNineHundred = TextDataParsing.fromOneHundredToOneThousand(languageConvert);
        return ((hundredOfNumber == 0) ? "" : space + arrayFromOneHundredToNineHundred[hundredOfNumber - 1]);
    }

    private static String forDozen(String languageConvert) {
        final String[] arrayFromZeroToOneHundred = TextDataParsing.fromZeroToOneHundred(languageConvert);
        return ((hundredOfNumber > 0 && dozenOfNumber == 0) ? "" : space + arrayFromZeroToOneHundred[dozenOfNumber]);
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
                hundredEnding.append(hundredFromWords).append(and).append(dozenFromWords);
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
            thousandEnding.append(hundredFromWords).append(dozenFromWords).append(space).append(valueFromArray);
        } else {
            if (unitOfNumber == 1) {
                thousandEnding.append(hundredFromWords).append(one).append(valueFromArray).append(a);
            }
            if (unitOfNumber == 2) {
                thousandEnding.append(hundredFromWords).append(two).append(valueFromArray).append(i);
            }
            if (unitOfNumber > 2 && unitOfNumber < 5) {
                thousandEnding.append(hundredFromWords).append(dozenFromWords).append(space).append(valueFromArray).append(i);
            }
            if (unitOfNumber >= 5 || unitOfNumber == 0) {
                thousandEnding.append(hundredFromWords).append(dozenFromWords).append(space).append(valueFromArray);
            }
        }
        return thousandEnding;
    }

    private static StringBuilder forExponentialNumberEndingOnRussian(int quantityOfNumberClasses, String languageConvert) {
        StringBuilder exponentialNumberEnding = new StringBuilder();
        final String[] arrayFromOneThousandToMaximumAvailableNumber = TextDataParsing.fromOneThousandToMaximumAvailableNumber(languageConvert);
        final String valueFromArray = arrayFromOneThousandToMaximumAvailableNumber[quantityOfNumberClasses - 1];

        if (dozenOfNumber > 10 && dozenOfNumber < 20) {
            exponentialNumberEnding.append(hundredFromWords).append(dozenFromWords).append(space).append(valueFromArray).append(of);
        } else {
            if (unitOfNumber == 1) {
                exponentialNumberEnding.append(hundredFromWords).append(dozenFromWords).append(space).append(valueFromArray);
            }
            if (unitOfNumber > 1 && unitOfNumber < 5) {
                exponentialNumberEnding.append(hundredFromWords).append(dozenFromWords).append(space).append(valueFromArray).append(a);
            }
            if (unitOfNumber >= 5 || unitOfNumber == 0) {
                exponentialNumberEnding.append(hundredFromWords).append(dozenFromWords).append(space).append(valueFromArray).append(of);
            }
        }
        return exponentialNumberEnding;
    }

    private static StringBuilder forExponentialEndingOnEnglish(int quantityOfNumberClasses, String languageConvert) {
        StringBuilder exponentialNumberEnding = new StringBuilder();
        final String[] arrayFromOneThousandToMaximumAvailableNumber = TextDataParsing.fromOneThousandToMaximumAvailableNumber(languageConvert);
        exponentialNumberEnding.append(hundredFromWords).append(dozenFromWords).append(space)
                .append(arrayFromOneThousandToMaximumAvailableNumber[quantityOfNumberClasses - 1]);
        return exponentialNumberEnding;
    }
}
