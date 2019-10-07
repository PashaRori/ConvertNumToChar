import java.io.BufferedReader;
import java.io.InputStreamReader;
//Main класс
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
            NumberToChar numToChar = new NumberToChar();
            String rez = numToChar.convertNumToString(inputNum);
            System.out.println(rez);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
