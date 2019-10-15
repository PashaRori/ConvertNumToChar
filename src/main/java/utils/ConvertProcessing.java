package utils;

public class ConvertProcessing {
    private static int hundredOfNumber;
    private static int dozenOfNumber;
    private static int unitOfNumber;
    private static String hundredFromWords;
    private static String dozenFromWords;

    public static StringBuilder createOnRussian(String receivedSegment, int quantityOfNumberClasses, String languageConvert) {
        StringBuilder resultCreateWord = new StringBuilder();

        int numberSegment = Integer.parseInt(receivedSegment);
        hundredOfNumber = numberSegment / 100;
        hundredFromWords = forHundred(languageConvert);
        dozenOfNumber = numberSegment % 100;
        dozenFromWords = forDozen(languageConvert);
        unitOfNumber = numberSegment % 10;

        if (quantityOfNumberClasses == 0 && !receivedSegment.equals("000")) {
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

        int numberSegment = Integer.parseInt(receivedSegment);
        hundredOfNumber = numberSegment / 100;
        hundredFromWords = forHundred(languageConvert);
        dozenOfNumber = numberSegment % 100;
        dozenFromWords = forDozen(languageConvert);

        if (quantityOfNumberClasses == 0 && !receivedSegment.equals("000")) {
            resultCreateWord.append(forHundredEndingOnEnglish(quantityOfNumberClasses));
        }
        if ((hundredOfNumber != 0 || dozenOfNumber != 0) && quantityOfNumberClasses > 0) {
            resultCreateWord.append(forExponentialEndingOnEnglish(quantityOfNumberClasses, languageConvert));
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
            if(dozenOfNumber != 0) {
                hundredEnding.append(hundredFromWords).append(" and").append(dozenFromWords);
            } else {
                hundredEnding.append(hundredFromWords).append(dozenFromWords);
            }
        }
        return hundredEnding;
    }

    private static StringBuilder forThousandEndingOnRussian(int quantityOfNumberClasses, String languageConvert) {
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

    private static StringBuilder forExponentialNumberEndingOnRussian(int quantityOfNumberClasses, String languageConvert) {
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

    private static StringBuilder forExponentialEndingOnEnglish(int quantityOfNumberClasses, String languageConvert) {
        StringBuilder exponentialNumberEnding = new StringBuilder();
        String[] arrayFromOneThousandToMaximumAvailableNumber = TextDataParsing.fromOneThousandToMaximumAvailableNumber(languageConvert);
        exponentialNumberEnding.append(hundredFromWords).append(dozenFromWords).append(" ")
                .append(arrayFromOneThousandToMaximumAvailableNumber[quantityOfNumberClasses - 1]);
        return exponentialNumberEnding;
    }
}
