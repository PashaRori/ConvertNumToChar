import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Program {
    public static void main(String[] args){
        long inputNum;
        System.out.println("Введите число: ");
        try
        {
            InputStreamReader in = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(in);
            String readText = br.readLine();
            inputNum = Long.valueOf(readText);
            NumToChar numToChar = new NumToChar();
            String rez = numToChar.convertNumToString(inputNum);
            System.out.println(rez);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
