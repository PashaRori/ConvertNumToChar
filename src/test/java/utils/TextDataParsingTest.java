package utils;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TextDataParsingTest {
    public static String[] outputEqualsArrayWord;
    public static String[] outputNotEqualsArrayWord;
    private static String language;

    @Test
    public void fromZeroToOneHundred_compareValueToEqualsThem() {
        language = "Rus";
        outputEqualsArrayWord = new String[]{"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь",
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
        String[] result = TextDataParsing.fromZeroToOneHundred(language);
        Assert.assertArrayEquals(outputEqualsArrayWord, result);
    }

    @Test
    public void fromZeroToOneHundred_compareValueToNotEqualsThem() {
        language = "Rus";
        outputNotEqualsArrayWord = new String[]{"ноль", "один", "два", "три"};
        String[] result = TextDataParsing.fromZeroToOneHundred(language);
        Assert.assertNotEquals(outputNotEqualsArrayWord, result);
    }

    @Test
    public void fromZeroToOneHundred_checkExceptionValueWithNull() {
        language = null;
        assertThrows(NullPointerException.class, () -> {
            TextDataParsing.fromZeroToOneHundred(language);
        });
    }

    @Test
    public void fromOneHundredToOneThousand_compareValueToEqualsThem() {
        language = "Rus";
        outputEqualsArrayWord = new String[]{"сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот",
                "восемьсот", "девятьсот"};
        String[] result = TextDataParsing.fromOneHundredToOneThousand(language);
        Assert.assertArrayEquals(outputEqualsArrayWord, result);
    }

    @Test
    public void fromOneHundredToOneThousand_compareValueToNotEqualsThem() {
        language = "Rus";
        outputNotEqualsArrayWord = new String[]{"сто", "двести"};
        String[] result = TextDataParsing.fromOneHundredToOneThousand(language);
        assertNotEquals(outputNotEqualsArrayWord, result);
    }

    @Test
    public void fromOneHundredToOneThousand_checkExceptionValueWithNull() {
        language = null;
        assertThrows(NullPointerException.class, () -> {
            TextDataParsing.fromOneHundredToOneThousand(language);
        });
    }

    @Test
    public void fromOneThousandToMaximumAvailableNumber_compareValueToEqualsThem() {
        language = "Rus";
        outputEqualsArrayWord = new String[]{"тысяч", "миллион", "миллиард", "триллион", "квадриллион", "квинтиллион",
                "секстиллион", "септиллион", "октиллион", "нониллион", "дециллион", "андециллион", "дуодециллион",
                "тридециллион", "квадридециллион", "квинтидециллион", "секстидециллион", "септидециллион",
                "октидециллион", "нонидециллион", "децидециллион"};
        String[] result = TextDataParsing.fromOneThousandToMaximumAvailableNumber(language);
        Assert.assertArrayEquals(outputEqualsArrayWord, result);
    }

    @Test
    public void fromOneThousandToMaximumAvailableNumber_compareValueToNotEqualsThem() {
        language = "Rus";
        outputNotEqualsArrayWord = new String[]{"тысяч", "миллион", "миллиард"};
        String[] result = TextDataParsing.fromOneThousandToMaximumAvailableNumber(language);
        Assert.assertNotEquals(outputNotEqualsArrayWord, result);
    }

    @Test
    public void fromOneThousandToMaximumAvailableNumber_checkExceptionValueWithNull() {
        language = null;
        assertThrows(NullPointerException.class, () -> {
            TextDataParsing.fromOneThousandToMaximumAvailableNumber(language);
        });
    }
}