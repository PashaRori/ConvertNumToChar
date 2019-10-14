package services;

import org.apache.log4j.Logger;
import utils.CreateWordConversionNumberWork;

import java.util.ArrayList;

public class ConvertNumberToEnglishWord {
    private static final Logger logger = Logger.getLogger(ConvertNumberToEnglishWord.class);
    private String conversionNumber;
    private String languageConvert;

    public ConvertNumberToEnglishWord(String introducedNumber, String languageConvert) {
        this.conversionNumber = introducedNumber;
        this.languageConvert = languageConvert;
    }

    public String createFinalRussianWord() {
        StringBuilder conversionResult = new StringBuilder();
        try {
            String positiveConversionNumber = CreateWordConversionNumberWork.testNegativityNumber(conversionNumber);
            if (!conversionNumber.equals(positiveConversionNumber)) {
                if (languageConvert.equals("Rus")) {
                    conversionResult.append(" минус");
                } else {
                    conversionResult.append(" minus");
                }
            }

            ArrayList numberSegments = CreateWordConversionNumberWork.numberSegments(positiveConversionNumber);
            int quantityTriplesNumber = numberSegments.size() - 1;

            for (Object numberSegment : numberSegments) {
                int drainFromNumberSegment = Integer.parseInt(numberSegment.toString());
                if (languageConvert.equals("Rus")) {
                    conversionResult.append(CreateWordConversionNumberWork.createOnRussian(drainFromNumberSegment, quantityTriplesNumber, languageConvert));
                } else {
                    conversionResult.append(CreateWordConversionNumberWork.createOnEnglish(drainFromNumberSegment, quantityTriplesNumber, languageConvert));
                }
                quantityTriplesNumber--;
            }
        } catch (NumberFormatException e) {
            logger.error("Not number");
        }
        conversionResult.deleteCharAt(0);
        return conversionResult.toString();
    }

    public String createFinalEnglishWord() {
        StringBuilder conversionResult = new StringBuilder();
        try {
            String positiveConversionNumber = CreateWordConversionNumberWork.testNegativityNumber(conversionNumber);
            if (!conversionNumber.equals(positiveConversionNumber)) {
                if (languageConvert.equals("Rus")) {
                    conversionResult.append(" минус");
                } else {
                    conversionResult.append(" minus");
                }
            }

            ArrayList numberSegments = CreateWordConversionNumberWork.numberSegments(positiveConversionNumber);
            int quantityTriplesNumber = numberSegments.size() - 1;

            for (Object numberSegment : numberSegments) {
                int drainFromNumberSegment = Integer.parseInt(numberSegment.toString());
                if (languageConvert.equals("Rus")) {
                    conversionResult.append(CreateWordConversionNumberWork.createOnRussian(drainFromNumberSegment, quantityTriplesNumber, languageConvert));
                } else {
                    conversionResult.append(CreateWordConversionNumberWork.createOnEnglish(drainFromNumberSegment, quantityTriplesNumber, languageConvert));
                }
                quantityTriplesNumber--;
            }
        } catch (NumberFormatException e) {
            logger.error("Not number");
        }
        conversionResult.deleteCharAt(0);
        return conversionResult.toString();
    }
}
