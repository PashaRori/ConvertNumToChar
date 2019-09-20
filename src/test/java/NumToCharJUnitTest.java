import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class NumToCharJUnitTest {

    @Test
    void convertNumToString1() throws IOException {
        NumToChar numToChar = new NumToChar();
        String inputTrueUnit = numToChar.convertNumToString(1);
        assertEquals("один", inputTrueUnit);
    }
    @Test
    void convertNumToString2() throws IOException {
        NumToChar numToChar = new NumToChar();
        String inputTrueUnit = numToChar.convertNumToString(-17);
        assertEquals("минус семнадцать", inputTrueUnit);
    }
    @Test
    void convertNumToString3() throws IOException {
        NumToChar numToChar = new NumToChar();
        String inputTrueUnit = numToChar.convertNumToString(1000000);
        assertEquals("один миллион", inputTrueUnit);
    }
    @Test
    void convertNumToString4() throws IOException {
        NumToChar numToChar = new NumToChar();
        String inputTrueUnit = numToChar.convertNumToString(987654321);
        assertEquals("девятьсот восемьдесят семь миллионов шестьсот пятьдесят четыре тысячи триста двадцать один", inputTrueUnit);
    }
}