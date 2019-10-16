package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberProcessing {
    private static final String MINUS_ZERO = "-0";
    private static final String MINUS = "-";
    private static final char MINUS_CHAR = '-';

    private NumberProcessing() {
    }

    public static String checkNegativityNumber(String conversionNumber) {
        return conversionNumber.charAt(0) == MINUS_CHAR && !(conversionNumber.equals(MINUS_ZERO) || conversionNumber.equals(MINUS)) ?
                conversionNumber.substring(1) : conversionNumber;
    }

    public static List<String> numberSegments(String conversionNumberToWord) {
        List<String> numberSegments = new ArrayList<>();
        int quantityClassesInputNumber = conversionNumberToWord.length() / 3;
        int quantityTriples = 0;
        while (quantityClassesInputNumber > 0) {
            numberSegments.add(conversionNumberToWord.substring(conversionNumberToWord.length() - 3 - (3 * quantityTriples), conversionNumberToWord.length() - 3 * quantityTriples));
            quantityClassesInputNumber--;
            quantityTriples++;
        }
        if (conversionNumberToWord.length() - 3 * quantityTriples != 0) {
            numberSegments.add(conversionNumberToWord.substring(0, conversionNumberToWord.length() - 3 * quantityTriples));
        }
        Collections.reverse(numberSegments);
        return numberSegments;
    }
}
