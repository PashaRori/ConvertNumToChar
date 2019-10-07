import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
//Тест класс для проведения юнит тестов
class NumToCharJUnitTest {

    NumberToChar numToChar = new NumberToChar();
    @Test
    void convertNumToString1() throws IOException {
        String inputTrueUnit = numToChar.convertNumToString(1);
        assertEquals("один", inputTrueUnit);
    }
    @Test
    void convertNumToString2() throws IOException {
        String inputTrueUnit = numToChar.convertNumToString(-17);
        assertEquals("минус семнадцать", inputTrueUnit);
    }
    @Test
    void convertNumToString3() throws IOException {
        String inputTrueUnit = numToChar.convertNumToString(1000000);
        assertEquals("один миллион", inputTrueUnit);
    }
    @Test
    void convertNumToString4() throws IOException {
        String inputTrueUnit = numToChar.convertNumToString(987654321);
        assertEquals("девятьсот восемьдесят семь миллионов шестьсот пятьдесят четыре тысячи триста двадцать один", inputTrueUnit);
    }
}