package utils;

import java.util.ArrayList;
import java.util.Collections;

public class CreateWordConversionNumberWork {

    public static String testNegativityNumber(String conversionNumber){
        if (conversionNumber.charAt(0) == '-' && !(conversionNumber.equals("-0") || conversionNumber.equals("-"))) {
                conversionNumber = conversionNumber.substring(1);
        }
        return conversionNumber;
    }

    public static ArrayList<String> numberSegments(String conversionNumberToWord){
        ArrayList<String> numberSegments = new ArrayList<>();
        int quantityTriplesInputNumber = conversionNumberToWord.length() / 3;
        int quantityTriples = 0;
        while (quantityTriplesInputNumber > 0) {
            numberSegments.add(conversionNumberToWord.substring(conversionNumberToWord.length() - 3 - (3 * quantityTriples), conversionNumberToWord.length() - 3 * quantityTriples));
            quantityTriplesInputNumber--;
            quantityTriples++;
        }
        if (conversionNumberToWord.length() - 3 * quantityTriples != 0) {
            numberSegments.add(conversionNumberToWord.substring(0, conversionNumberToWord.length() - 3 * quantityTriples));
        }
        Collections.reverse(numberSegments);
        return numberSegments;
    }

    public static StringBuilder createOnRussian(int drainFromNumberSegment, int quantityTriplesNumber, String languageConvert) {
        StringBuilder resultCreateWord = new StringBuilder();

        int hundredOfNumber = drainFromNumberSegment / 100;
        String hundredFromWords = FillingWordWithCertainParameters.forHundred(hundredOfNumber, languageConvert);
        int dozenOfNumber = drainFromNumberSegment % 100;
        String dozenFromWords = FillingWordWithCertainParameters.forDozen(hundredOfNumber, dozenOfNumber, languageConvert);
        int unitOfNumber = drainFromNumberSegment % 10;

        if (quantityTriplesNumber == 0) {
            resultCreateWord.append(FillingWordWithCertainParameters.forHundredEndingOnRussian(hundredOfNumber, dozenOfNumber, dozenFromWords, hundredFromWords, quantityTriplesNumber));
        }
        if ((hundredOfNumber != 0 || dozenOfNumber != 0) && quantityTriplesNumber > 0) {
            if (quantityTriplesNumber == 1) {
                resultCreateWord.append(FillingWordWithCertainParameters.forThousandEndingOnRussian(unitOfNumber, dozenOfNumber, quantityTriplesNumber, dozenFromWords, hundredFromWords, languageConvert));
            }
            if (quantityTriplesNumber > 1) {
                resultCreateWord.append(FillingWordWithCertainParameters.forExponentialNumberEndingOnRussian(unitOfNumber, dozenOfNumber, quantityTriplesNumber, dozenFromWords, hundredFromWords, languageConvert));
            }
        }
        return resultCreateWord;
    }

    public static StringBuilder createOnEnglish(int drainFromNumberSegment, int quantityTriplesNumber, String languageConvert) {
        StringBuilder resultCreateWord = new StringBuilder();

        int hundredOfNumber = drainFromNumberSegment / 100;
        String hundredFromWords = FillingWordWithCertainParameters.forHundred(hundredOfNumber, languageConvert);
        int dozenOfNumber = drainFromNumberSegment % 100;
        String dozenFromWords = FillingWordWithCertainParameters.forDozen(hundredOfNumber, dozenOfNumber, languageConvert);

        if (quantityTriplesNumber == 0) {
            resultCreateWord.append(FillingWordWithCertainParameters.forHundredEndingOnEnglish(hundredOfNumber, dozenOfNumber, dozenFromWords, hundredFromWords, quantityTriplesNumber));
        }
        if ((hundredOfNumber != 0 || dozenOfNumber != 0) && quantityTriplesNumber > 0) {
            resultCreateWord.append(FillingWordWithCertainParameters.forExponentialEndingOnEnglish(quantityTriplesNumber, dozenFromWords, hundredFromWords, languageConvert));
        }
        return resultCreateWord;
    }
}
