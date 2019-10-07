import org.junit.jupiter.api.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class NumberToWordsTest {

    private NumberToWords numberToWords;

    @BeforeEach
    public void beforeMethod(){
        numberToWords = new NumberToWords();
    }

    @AfterEach
    public void afterMethod(){
        numberToWords = null;
    }

    @DisplayName("Проверка для числа 100")
    @Test
    public void testConvertEquals() throws IOException {
        assertEquals("сто", numberToWords.convertNumberToWords(100));
    }

    @DisplayName("Проверка с добущенной ошибкой")
    @Test
    public void testConvertNotEquals() throws IOException {
        assertEquals("семнадцать", numberToWords.convertNumberToWords(13));
    }

    @DisplayName("Проверка для числа -1 с таймером")
    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    public void  testConvertTimer() throws IOException {
        assertEquals("минус один", numberToWords.convertNumberToWords(-1));
    }
}