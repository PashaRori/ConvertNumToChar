package Tested;

import org.apache.log4j.Logger;
import services.ConvertNumberToRussianWord;
import utils.CreateWordConversionNumberWork;

import java.util.ArrayList;

public class Eng extends OOP {
    private static final Logger logger = Logger.getLogger(ConvertNumberToRussianWord.class);
    private String conversionNumber;
    private String languageConvert;

    public Eng(String introducedNumber, String languageConvert) {
        this.conversionNumber = introducedNumber;
        this.languageConvert = languageConvert;
    }

    public String createFinalWord() {
        StringBuilder conversionResult = new StringBuilder();
        try {
            String positiveConversionNumber = CreateWordConversionNumberWork.testNegativityNumber(conversionNumber);
            if (!conversionNumber.equals(positiveConversionNumber)) {
                conversionResult.append(" minus");
            }

            ArrayList numberSegments = CreateWordConversionNumberWork.numberSegments(positiveConversionNumber);
            int quantityTriplesNumber = numberSegments.size() - 1;

            for (Object numberSegment : numberSegments) {
                int drainFromNumberSegment = Integer.parseInt(numberSegment.toString());
                conversionResult.append(CreateWordConversionNumberWork.createOnEnglish(drainFromNumberSegment, quantityTriplesNumber, languageConvert));
                quantityTriplesNumber--;
            }
        } catch (NumberFormatException e) {
            logger.error("Not number");
        }
        conversionResult.deleteCharAt(0);
        return conversionResult.toString();
    }
}
