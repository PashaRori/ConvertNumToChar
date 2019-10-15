package utils;

public class ConvertProcessing {
    private static int hundredOfNumber;
    private static int dozenOfNumber;
    private static int unitOfNumber;

    //можно попробовать переписать с наследование или тип того
    public static StringBuilder createOnRussian(int drainFromNumberSegment, int quantityOfNumberClasses, String languageConvert) {
        StringBuilder resultCreateWord = new StringBuilder();

        hundredOfNumber = drainFromNumberSegment / 100;
        String hundredFromWords = forHundred(languageConvert);
        dozenOfNumber = drainFromNumberSegment % 100;
        String dozenFromWords = forDozen(languageConvert);
        unitOfNumber = drainFromNumberSegment % 10;

        if (quantityOfNumberClasses == 0) {
            resultCreateWord.append(forHundredEndingOnRussian(dozenFromWords, hundredFromWords, quantityOfNumberClasses));
        }
        if ((hundredOfNumber != 0 || dozenOfNumber != 0) && quantityOfNumberClasses > 0) {
            if (quantityOfNumberClasses == 1) {
                resultCreateWord.append(forThousandEndingOnRussian(quantityOfNumberClasses, dozenFromWords, hundredFromWords, languageConvert));
            }
            if (quantityOfNumberClasses > 1) {
                resultCreateWord.append(forExponentialNumberEndingOnRussian(quantityOfNumberClasses, dozenFromWords, hundredFromWords, languageConvert));
            }
        }
        return resultCreateWord;
    }

    //можно попробовать переписать с наследование или тип того
    public static StringBuilder createOnEnglish(int drainFromNumberSegment, int quantityOfNumberClasses, String languageConvert) {
        StringBuilder resultCreateWord = new StringBuilder();

        hundredOfNumber = drainFromNumberSegment / 100;
        String hundredFromWords = forHundred(languageConvert);
        dozenOfNumber = drainFromNumberSegment % 100;
        String dozenFromWords = forDozen(languageConvert);

        if (quantityOfNumberClasses == 0) {
            resultCreateWord.append(forHundredEndingOnEnglish(dozenFromWords, hundredFromWords, quantityOfNumberClasses));
        }
        if ((hundredOfNumber != 0 || dozenOfNumber != 0) && quantityOfNumberClasses > 0) {
            resultCreateWord.append(forExponentialEndingOnEnglish(quantityOfNumberClasses, dozenFromWords, hundredFromWords, languageConvert));
        }
        return resultCreateWord;
    }

    private static String forHundred(String languageConvert) {
        String[] arrayFromOneHundredToNineHundred = TextDataParsing.fromOneHundredToOneThousand(languageConvert);
        String hundredOfWords;
        if (hundredOfNumber == 0) {
            hundredOfWords = "";
        } else {
            hundredOfWords = " " + arrayFromOneHundredToNineHundred[hundredOfNumber - 1];
        }
        return hundredOfWords;
    }

    private static String forDozen(String languageConvert) {
        String[] arrayFromZeroToOneHundred = TextDataParsing.fromZeroToOneHundred(languageConvert);
        String dozenOfWords;
        if (hundredOfNumber > 0 && dozenOfNumber == 0) {
            dozenOfWords = "";
        } else {
            dozenOfWords = " " + arrayFromZeroToOneHundred[dozenOfNumber];
        }
        return dozenOfWords;
    }

    //можно попробовать переписать с наследование или тип того
    private static StringBuilder forHundredEndingOnRussian(String dozenFromWords, String hundredFromWords, int sizeInputNumber) {
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

    //можно попробовать переписать с наследование или тип того
    private static StringBuilder forHundredEndingOnEnglish(String dozenFromWords, String hundredFromWords, int sizeInputNumber) {
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

    private static StringBuilder forThousandEndingOnRussian(int quantityOfNumberClasses, String dozenFromWords, String hundredFromWords, String languageConvert) {
        StringBuilder thousandEnding = new StringBuilder();
        String[] arrayFromOneThousandToMaximumAvailableNumber = TextDataParsing.fromOneThousandToMaximumAvailableNumber(languageConvert);

        if (dozenOfNumber > 10 && dozenOfNumber < 20) {
            thousandEnding.append(hundredFromWords).append(dozenFromWords).append(" ").append(arrayFromOneThousandToMaximumAvailableNumber[quantityOfNumberClasses - 1]);
        } else {
            if (unitOfNumber == 1) {
                thousandEnding.append(hundredFromWords).append(" одна ").append(arrayFromOneThousandToMaximumAvailableNumber[quantityOfNumberClasses - 1]).append("а");
            }
            if (unitOfNumber == 2) {
                thousandEnding.append(hundredFromWords).append(" две ").append(arrayFromOneThousandToMaximumAvailableNumber[quantityOfNumberClasses - 1]).append("и");
            }
            if (unitOfNumber > 2 && unitOfNumber < 5) {
                thousandEnding.append(hundredFromWords).append(dozenFromWords).append(" ").append(arrayFromOneThousandToMaximumAvailableNumber[quantityOfNumberClasses - 1]).append("и");
            }
            if (unitOfNumber >= 5 || unitOfNumber == 0) {
                thousandEnding.append(hundredFromWords).append(dozenFromWords).append(" ").append(arrayFromOneThousandToMaximumAvailableNumber[quantityOfNumberClasses - 1]);
            }
        }
        return thousandEnding;
    }

    //можно попробовать переписать с наследование или тип того
    private static StringBuilder forExponentialNumberEndingOnRussian(int quantityOfNumberClasses, String dozenFromWords, String hundredFromWords, String languageConvert) {
        StringBuilder exponentialNumberEnding = new StringBuilder();
        String[] arrayFromOneThousandToMaximumAvailableNumber = TextDataParsing.fromOneThousandToMaximumAvailableNumber(languageConvert);

        if (dozenOfNumber > 10 && dozenOfNumber < 20) {
            exponentialNumberEnding.append(hundredFromWords).append(dozenFromWords).append(" ").append(arrayFromOneThousandToMaximumAvailableNumber[quantityOfNumberClasses - 1]).append("ов");
        } else {
            if (unitOfNumber == 1) {
                exponentialNumberEnding.append(hundredFromWords).append(dozenFromWords).append(" ").append(arrayFromOneThousandToMaximumAvailableNumber[quantityOfNumberClasses - 1]);
            }
            if (unitOfNumber > 1 && unitOfNumber < 5) {
                exponentialNumberEnding.append(hundredFromWords).append(dozenFromWords).append(" ").append(arrayFromOneThousandToMaximumAvailableNumber[quantityOfNumberClasses - 1]).append("а");
            }
            if (unitOfNumber >= 5 || unitOfNumber == 0) {
                exponentialNumberEnding.append(hundredFromWords).append(dozenFromWords).append(" ").append(arrayFromOneThousandToMaximumAvailableNumber[quantityOfNumberClasses - 1]).append("ов");
            }
        }
        return exponentialNumberEnding;
    }

    //можно попробовать переписать с наследование или тип того
    private static StringBuilder forExponentialEndingOnEnglish(int quantityOfNumberClasses, String dozenFromWords, String hundredFromWords, String languageConvert) {
        StringBuilder exponentialNumberEnding = new StringBuilder();
        String[] arrayFromOneThousandToMaximumAvailableNumber = TextDataParsing.fromOneThousandToMaximumAvailableNumber(languageConvert);
        exponentialNumberEnding.append(hundredFromWords).append(dozenFromWords).append(" ")
                .append(arrayFromOneThousandToMaximumAvailableNumber[quantityOfNumberClasses - 1]);
        return exponentialNumberEnding;
    }
}
