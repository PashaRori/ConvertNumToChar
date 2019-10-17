package util;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static util.TextDataParsing.*;

class TextDataParsingTest {
    private static final String LANGUAGE_RUSSIAN = "Rus";
    private static final String LANGUAGE_ENGLISH = "Eng";
    private static final String NULL = null;
    private static final String[] RussianArrayZeroToOneHundred = new String[]{"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь",
            "девять", "десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать",
            "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать", "двадцать", "двадцать один",
            "двадцать два", "двадцать три", "двадцать четыре", "двадцать пять", "двадцать шесть", "двадцать семь",
            "двадцать восемь", "двадцать девять", "тридцать", "тридцать один", "тридцать два", "тридцать три",
            "тридцать четыре", "тридцать пять", "тридцать шесть", "тридцать семь", "тридцать восемь",
            "тридцать девять", "сорок", "сорок один", "сорок два", "сорок три", "сорок четыре", "сорок пять",
            "сорок шесть", "сорок семь", "сорок восемь", "сорок девять", "пятьдесят", "пятьдесят один",
            "пятьдесят два", "пятьдесят три", "пятьдесят четыре", "пятьдесят пять", "пятьдесят шесть",
            "пятьдесят семь", "пятьдесят восемь", "пятьдесят девять", "шестьдесят", "шестьдесят один",
            "шестьдесят два", "шестьдесят три", "шестьдесят четыре", "шестьдесят пять", "шестьдесят шесть",
            "шестьдесят семь", "шестьдесят восемь", "шестьдесят девять", "семьдесят", "семьдесят один",
            "семьдесят два", "семьдесят три", "семьдесят четыре", "семьдесят пять", "семьдесят шесть",
            "семьдесят семь", "семьдесят восемь", "семьдесят девять", "восемьдесят", "восемьдесят один",
            "восемьдесят два", "восемьдесят три", "восемьдесят четыре", "восемьдесят пять", "восемьдесят шесть",
            "восемьдесят семь", "восемьдесят восемь", "восемьдесят девять", "девяноста", "девяноста один",
            "девяноста два", "девяноста три", "девяноста четыре", "девяноста пять", "девяноста шесть",
            "девяноста семь", "девяноста восемь", "девяноста девять"};
    private static final String[] EnglishArrayZeroToOneHundred = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
            "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
            "nineteen", "twenty", "twenty one", "twenty two", "twenty three", "twenty four", "twenty five",
            "twenty six", "twenty seven", "twenty eight", "twenty nine", "thirty", "thirty one", "thirty two",
            "thirty three", "thirty four", "thirty five", "thirty six", "thirty seven", "thirty eight", "thirty nine",
            "forty", "forty one", "forty two", "forty three", "forty four", "forty five", "forty six", "forty seven",
            "forty eight", "forty nine", "fifty", "fifty one", "fifty two", "fifty three", "fifty four", "fifty five",
            "fifty six", "fifty seven", "fifty eight", "fifty nine", "sixty", "sixty one", "sixty two", "sixty three",
            "sixty four", "sixty five", "sixty six", "sixty seven", "sixty eight", "sixty nine", "seventy",
            "seventy one", "seventy two", "seventy three", "seventy four", "seventy five", "seventy six",
            "seventy seven", "seventy eight", "seventy nine", "eighty", "eighty one", "eighty two", "eighty three",
            "eighty four", "eighty five", "eighty six", "eighty seven", "eighty eight", "eighty nine", "ninety",
            "ninety one", "ninety two", "ninety three", "ninety four", "ninety five", "ninety six", "ninety seven",
            "ninety eight", "ninety nine"};
    private static final String[] RussianDifferenceArrayZeroToOneHundred = new String[]{"ноль", "один", "два", "три"};
    private static final String[] EnglishDifferenceArrayZeroToOneHundred = new String[]{"zero", "one", "two", "three"};
    private static final String[] RussianOneHundredToOneThousand = {"сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};
    private static final String[] EnglishOneHundredToOneThousand = new String[]{"one hundred", "two hundred", "three hundred", "four hundred", "five hundred", "six hundred", "seven hundred", "eight hundred", "nine hundred"};
    private static final String[] RussianDifferenceOneHundredToOneThousand = new String[]{"сто", "двести"};
    private static final String[] EnglishDifferenceOneHundredToOneThousand = new String[]{"one hundred", "two hundred", "three hundred"};
    private static final String[] RussianOneThousandToMaximumAvailableNumber = new String[]{"тысяч", "миллион", "миллиард", "триллион", "квадриллион", "квинтиллион",
            "секстиллион", "септиллион", "октиллион", "нониллион", "дециллион", "андециллион", "дуодециллион",
            "тридециллион", "квадридециллион", "квинтидециллион", "секстидециллион", "септидециллион",
            "октидециллион", "нонидециллион", "децидециллион"};
    private static final String[] EnglishOneThousandToMaximumAvailableNumber = new String[]{"thousand", "million", "billion", "trillion", "quadrillion",
            "quintillion", "sextillion", "septillion", "octillion", "quintillion", "decillion", "andecillion",
            "duodecillion", "tridecillion", "quadrillion", "quintidecillion", "sextidecillion", "septidecillion",
            "octidecillion", "nonidecillion", "decidecillion"};
    private static final String[] RussianDifferenceOneThousandToMaximumAvailableNumber = new String[]{"тысяч", "миллион", "миллиард"};
    private static final String[] EnglishDifferenceOneThousandToMaximumAvailableNumber = new String[]{"thousand", "million", "billion", "trillion"};

    @Test
    public void compareConvertedArrayneZeroToOneHundredAndArrayZeroToOneHundredRussianWord() {
        Assert.assertArrayEquals(RussianArrayZeroToOneHundred, getArrayZeroToOneHundred(LANGUAGE_RUSSIAN));
    }

    @Test
    public void compareConvertedArrayneZeroToOneHundredAndNotFullArrayZeroToOneHundredRussianWord() {
        Assert.assertNotEquals(RussianDifferenceArrayZeroToOneHundred, getArrayZeroToOneHundred(LANGUAGE_RUSSIAN));
    }

    @Test
    public void compareConvertedArrayneZeroToOneHundredAndArrayZeroToOneHundredEnglishWord() {
        Assert.assertArrayEquals(EnglishArrayZeroToOneHundred, getArrayZeroToOneHundred(LANGUAGE_ENGLISH));
    }

    @Test
    public void compareConvertedArrayneZeroToOneHundredAndNotFullArrayZeroToOneHundredEnglishWord() {
        Assert.assertNotEquals(EnglishDifferenceArrayZeroToOneHundred, getArrayZeroToOneHundred(LANGUAGE_ENGLISH));
    }

    @Test
    public void checkAssertionErrorFromArrayZeroToOneHundred() {
        assertThrows(AssertionError.class, () -> {
            getArrayZeroToOneHundred(NULL);
        });
    }

    @Test
    public void compareConvertedArrayneHundredToOneThousandAndArrayHundredToOneThousandRussianWord() {
        Assert.assertArrayEquals(RussianOneHundredToOneThousand, getArrayOneHundredToOneThousand(LANGUAGE_RUSSIAN));
    }

    @Test
    public void compareConvertedArrayneHundredToOneThousandAndNotFullArrayHundredToOneThousandRussianWord() {
        assertNotEquals(RussianDifferenceOneHundredToOneThousand, getArrayOneHundredToOneThousand(LANGUAGE_RUSSIAN));
    }


    @Test
    public void compareConvertedArrayneHundredToOneThousandAndArrayHundredToOneThousandEnglishWord() {
        Assert.assertArrayEquals(EnglishOneHundredToOneThousand, getArrayOneHundredToOneThousand(LANGUAGE_ENGLISH));
    }

    @Test
    public void compareConvertedArrayneHundredToOneThousandAndNotFullArrayHundredToOneThousandEnglishWord() {
        assertNotEquals(EnglishDifferenceOneHundredToOneThousand, getArrayOneHundredToOneThousand(LANGUAGE_ENGLISH));
    }

    @Test
    public void checkAssertionErrorFromArrayOneHundredToOneThousand() {
        assertThrows(AssertionError.class, () -> {
            getArrayOneHundredToOneThousand(NULL);
        });
    }

    @Test
    public void compareConvertedArrayOneThousandToMaximumAvailableNumberAndArrayOneThousandToMaximumAvailableNumberRussianWord() {
        Assert.assertArrayEquals(RussianOneThousandToMaximumAvailableNumber, getArrayOneThousandToMaximumAvailableNumber(LANGUAGE_RUSSIAN));
    }

    @Test
    public void compareConvertedArrayOneThousandToMaximumAvailableNumberAndNotFullArrayOneThousandToMaximumAvailableNumberRussianWord() {
        Assert.assertNotEquals(RussianDifferenceOneThousandToMaximumAvailableNumber, getArrayOneThousandToMaximumAvailableNumber(LANGUAGE_RUSSIAN));
    }

    @Test
    public void compareConvertedArrayOneThousandToMaximumAvailableNumberAndArrayOneThousandToMaximumAvailableNumberEnglishWord() {
        Assert.assertArrayEquals(EnglishOneThousandToMaximumAvailableNumber, getArrayOneThousandToMaximumAvailableNumber(LANGUAGE_ENGLISH));
    }

    @Test
    public void compareConvertedArrayOneThousandToMaximumAvailableNumberAndNotFullArrayOneThousandToMaximumAvailableNumberEnglishWord() {
        Assert.assertNotEquals(EnglishDifferenceOneThousandToMaximumAvailableNumber, getArrayOneThousandToMaximumAvailableNumber(LANGUAGE_ENGLISH));
    }

    @Test
    public void checkAssertionErrorFromArrayOneThousandToMaximumAvailableNumber() {
        assertThrows(AssertionError.class, () -> {
            getArrayOneThousandToMaximumAvailableNumber(NULL);
        });
    }
}