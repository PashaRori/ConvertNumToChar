import services.ConvertNumberToRussianWord;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        System.out.println("Input number: ");
        try {
            InputStreamReader in = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(in);
            String inputNum = br.readLine();
            ConvertNumberToRussianWord convertNumberToRussianWord = new ConvertNumberToRussianWord(inputNum,"Rus");
            String rez = convertNumberToRussianWord.createFinalWord();
            System.out.println(rez);
        } catch (Exception e) {
        }
    }
/*
    public static void main(String[] args) {
        System.out.println("Введите число: ");
        try {
            InputStreamReader in = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(in);
            String inputNum = br.readLine();
            NumberToWords2 numberToWords2 = new NumberToWords2(inputNum);
            String rez = numberToWords2.createFinalWordForConvertingNumbersToTextFormat("Rus");
            System.out.println(rez);
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        System.out.println("Введите число: ");
        try {
            InputStreamReader in = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(in);
            String inputNum = br.readLine();
            NumberToWords3 numberToWords3 = new NumberToWords3(inputNum);
            String rez = numberToWords3.createFinalWordForConvertingNumbersToTextFormat("Rus");
            System.out.println(rez);
        } catch (Exception e) {
        }
    }

 */
}
