package model;

import org.apache.log4j.Logger;

import java.util.List;

import static utils.ConvertProcessing.createOnEnglish;
import static utils.ConvertProcessing.createOnRussian;
import static utils.NumberProcessing.numberSegments;
import static utils.NumberProcessing.checkNegativityNumber;

public class ConvertNumberToWord {
    private static final Logger LOGGER = Logger.getLogger(ConvertNumberToWord.class);
    private final static String RUSSIAN = "Rus";
    private final static String minusRussian = " минус";
    private final static String minusEnglish = " minus";
    private final static String NotNumberException = "Not number";
    private final static String NullException = "Null Exception";
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
                conversionResult.append((languageConvert.equals(RUSSIAN))?minusRussian:minusEnglish);
            }

            List<String> numberSegments = numberSegments(positiveConversionNumber);
            int quantityOfNumberClasses = numberSegments.size() - 1;

            for (String numberSegment : numberSegments) {
                conversionResult.append((languageConvert.equals(RUSSIAN))?
                        createOnRussian(numberSegment, quantityOfNumberClasses, languageConvert):
                        createOnEnglish(numberSegment, quantityOfNumberClasses, languageConvert));

                quantityOfNumberClasses--;
            }
        } catch (NumberFormatException e) {
            LOGGER.error(NotNumberException);
        } catch (NullPointerException e) {
            LOGGER.error(NullException);
        }

        conversionResult.deleteCharAt(0);
        return conversionResult.toString();
    }
}
