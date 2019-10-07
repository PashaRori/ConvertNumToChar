import org.junit.jupiter.api.*;
import java.io.IOException;

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

    @Test
    public void testConvertEquals() throws IOException {
        assertEquals("сто", numberToWords.convertNumberToWords(100));
    }

    @Test
    public void testConvertNotEquals() throws IOException {
        assertEquals("семнадцать", numberToWords.convertNumberToWords(13));
    }
}