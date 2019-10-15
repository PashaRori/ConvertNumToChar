package model;

import org.apache.log4j.Logger;

import java.util.List;

import static utils.ConvertProcessing.createOnEnglish;
import static utils.ConvertProcessing.createOnRussian;
import static utils.NumberProcessing.numberSegments;
import static utils.NumberProcessing.checkNegativityNumber;

public class ConvertNumberToWord {
    private static final Logger LOGGER = Logger.getLogger(ConvertNumberToWord.class);
    private String conversionNumber;
    private String languageConvert;

    public ConvertNumberToWord(String introducedNumber, String languageConvert) {
        this.conversionNumber = introducedNumber;
        this.languageConvert = languageConvert;
    }

    public String createFinalWord() {
        StringBuilder conversionResult = new StringBuilder();

        try {
            final String positiveConversionNumber = checkNegativityNumber(conversionNumber);

            if (!conversionNumber.equals(positiveConversionNumber)) {
                if (languageConvert.equals("Rus")) {
                    conversionResult.append(" минус");
                } else {
                    conversionResult.append(" minus");
                }
            }

            List<String> numberSegments = numberSegments(positiveConversionNumber);
            int quantityOfNumberClasses = numberSegments.size() - 1;

            for (String numberSegment : numberSegments) {
                if (languageConvert.equals("Rus")) {
                    conversionResult.append(createOnRussian(numberSegment, quantityOfNumberClasses, languageConvert));
                } else {
                    conversionResult.append(createOnEnglish(numberSegment, quantityOfNumberClasses, languageConvert));
                }

                quantityOfNumberClasses--;
            }
        } catch (NumberFormatException e) {
            LOGGER.error("Not number");
        }

        conversionResult.deleteCharAt(0);
        return conversionResult.toString();
    }
}
