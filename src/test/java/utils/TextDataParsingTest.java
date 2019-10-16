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
    public void compareValueFromZeroToOneHundredAndCreatedArrayOnRussianToEqualsThem() {
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
    public void compareValueFromZeroToThreeAndCreatedArrayOnRussianToNotEqualsThem() {
        language = "Rus";
        outputNotEqualsArrayWord = new String[]{"ноль", "один", "два", "три"};
        String[] result = TextDataParsing.fromZeroToOneHundred(language);
        Assert.assertNotEquals(outputNotEqualsArrayWord, result);
    }

    @Test
    public void compareValueFromZeroToOneHundredAndCreatedArrayOnEnglishToEqualsThem() {
        language = "Eng";
        outputEqualsArrayWord = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
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
        String[] result = TextDataParsing.fromZeroToOneHundred(language);
        Assert.assertArrayEquals(outputEqualsArrayWord, result);
    }

    @Test
    public void compareValueFromZeroToThreeAndCreatedArrayOnEnglishToNotEqualsThem() {
        language = "Eng";
        outputNotEqualsArrayWord = new String[]{"zero", "one", "two", "three"};
        String[] result = TextDataParsing.fromZeroToOneHundred(language);
        Assert.assertNotEquals(outputNotEqualsArrayWord, result);
    }

    @Test
    public void checkExceptionValueWithNullFromArrayZeroToOneHundred() {
        language = null;
        assertThrows(NullPointerException.class, () -> {
            TextDataParsing.fromZeroToOneHundred(language);
        });
    }

    @Test
    public void compareValueFromOneHundredToOneThousandAndCreatedArrayOnRussianToEqualsThem() {
        language = "Rus";
        outputEqualsArrayWord = new String[]{"сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот",
                "восемьсот", "девятьсот"};
        String[] result = TextDataParsing.fromOneHundredToOneThousand(language);
        Assert.assertArrayEquals(outputEqualsArrayWord, result);
    }

    @Test
    public void compareValueFromOneHundredToOneThousandAndCreatedArrayOnRussianToNotEqualsThem() {
        language = "Rus";
        outputNotEqualsArrayWord = new String[]{"сто", "двести"};
        String[] result = TextDataParsing.fromOneHundredToOneThousand(language);
        assertNotEquals(outputNotEqualsArrayWord, result);
    }


    @Test
    public void compareValueFromOneHundredToOneThousandAndCreatedArrayOnEnglishToEqualsThem() {
        language = "Eng";
        outputEqualsArrayWord = new String[]{"one hundred", "two hundred", "three hundred", "four hundred", "five hundred", "six hundred", "seven hundred", "eight hundred", "nine hundred"};
        String[] result = TextDataParsing.fromOneHundredToOneThousand(language);
        Assert.assertArrayEquals(outputEqualsArrayWord, result);
    }

    @Test
    public void compareValueFromOneHundredToOneThousandAndCreatedArrayOnEnglishToNotEqualsThem() {
        language = "Eng";
        outputNotEqualsArrayWord = new String[]{"one hundred", "two hundred", "three hundred"};
        String[] result = TextDataParsing.fromOneHundredToOneThousand(language);
        assertNotEquals(outputNotEqualsArrayWord, result);
    }

    @Test
    public void checkExceptionValueWithNullFromArrayOneHundredToOneThousand() {
        language = null;
        assertThrows(NullPointerException.class, () -> {
            TextDataParsing.fromOneHundredToOneThousand(language);
        });
    }

    @Test
    public void compareValueFromOneThousandToMaximumAvailableNumberAndCreatedArrayOnRussianToEqualsThem() {
        language = "Rus";
        outputEqualsArrayWord = new String[]{"тысяч", "миллион", "миллиард", "триллион", "квадриллион", "квинтиллион",
                "секстиллион", "септиллион", "октиллион", "нониллион", "дециллион", "андециллион", "дуодециллион",
                "тридециллион", "квадридециллион", "квинтидециллион", "секстидециллион", "септидециллион",
                "октидециллион", "нонидециллион", "децидециллион"};
        String[] result = TextDataParsing.fromOneThousandToMaximumAvailableNumber(language);
        Assert.assertArrayEquals(outputEqualsArrayWord, result);
    }

    @Test
    public void compareValueFromOneThousandToMaximumAvailableNumberAndCreatedArrayOnRussianToNotEqualsThem() {
        language = "Rus";
        outputNotEqualsArrayWord = new String[]{"тысяч", "миллион", "миллиард"};
        String[] result = TextDataParsing.fromOneThousandToMaximumAvailableNumber(language);
        Assert.assertNotEquals(outputNotEqualsArrayWord, result);
    }

    /*
        @Test
        public void compareValueFromOneThousandToMaximumAvailableNumberAndCreatedArrayOnEnglishToEqualsThem() {
            language = "Eng";
            outputEqualsArrayWord = new String[]{"тысяч", "миллион", "миллиард", "триллион", "квадриллион", "квинтиллион",
                    "секстиллион", "септиллион", "октиллион", "нониллион", "дециллион", "андециллион", "дуодециллион",
                    "тридециллион", "квадридециллион", "квинтидециллион", "секстидециллион", "септидециллион",
                    "октидециллион", "нонидециллион", "децидециллион"};
            String[] result = TextDataParsing.fromOneThousandToMaximumAvailableNumber(language);
            Assert.assertArrayEquals(outputEqualsArrayWord, result);
        }

        @Test
        public void compareValueFromOneThousandToMaximumAvailableNumberAndCreatedArrayOnEnglishToNotEqualsThem() {
            language = "Eng";
            outputNotEqualsArrayWord = new String[]{"тысяч", "миллион", "миллиард"};
            String[] result = TextDataParsing.fromOneThousandToMaximumAvailableNumber(language);
            Assert.assertNotEquals(outputNotEqualsArrayWord, result);
        }
    */
    @Test
    public void checkExceptionValueWithNullFromArrayOneThousandToMaximumAvailableNumber() {
        language = null;
        assertThrows(NullPointerException.class, () -> {
            TextDataParsing.fromOneThousandToMaximumAvailableNumber(language);
        });
    }
}