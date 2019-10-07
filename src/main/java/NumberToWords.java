import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class NumberToWords {
    String convertNumberToWords(long numeric) throws IOException {
        NamesArray namesArray = new NamesArray();
        String[] stringTo99 = namesArray.arrayTo99();
        String[] string100To900 = namesArray.array100To900();
        String[] string1000ToInfinity = namesArray.array1000ToInfinity();
        StringBuilder rez = new StringBuilder();

        long numericConverted = Math.abs(numeric);
        int quantumTriples = 0;
        ArrayList segments = new ArrayList();
        while (numericConverted > 999) {
            long seg = numericConverted / 1000;
            segments.add(numericConverted - (seg * 1000));
            numericConverted = seg;
            quantumTriples++;
        }
        segments.add(numericConverted);
        Collections.reverse(segments);
        int levelTriples = segments.size() - 1;

        if (numeric<0)
        {
            rez.append(" минус");
        }
        int numericNew, hundredInteger, desInt, edenInt;
        String hundredString, dozensString;
        for (int i = 0; i < segments.size(); i++) {
            numericNew = (int) Integer.valueOf((segments.get(i).toString()));

            hundredInteger = numericNew / 100;
            if (hundredInteger == 0) {
                hundredString = "";
            } else hundredString = " " + string100To900[hundredInteger - 1];
            desInt = numericNew % 100;
            if (hundredInteger > 0 && desInt == 0) {
                dozensString = "";
            } else dozensString = " " + stringTo99[desInt];
            edenInt = numericNew % 10;

            if (levelTriples == 0) {
                if (hundredInteger == 0 && desInt == 0) {
                    if (quantumTriples == 0) rez.append(hundredString).append(dozensString);
                } else rez.append(hundredString).append(dozensString);
            }
            if (hundredInteger != 0 || desInt != 0 && levelTriples > 0) {

                if (levelTriples == 1) {
                    if (desInt > 10 && desInt < 20) {
                        rez.append(hundredString).append(dozensString).append(" ").append(string1000ToInfinity[levelTriples - 1]);
                    } else {
                        if (edenInt == 1) {
                            rez.append(hundredString).append(" одна ").append(string1000ToInfinity[levelTriples - 1]).append("а");
                        }
                        if (edenInt == 2) {
                            rez.append(hundredString).append(" две ").append(string1000ToInfinity[levelTriples - 1]).append("и");
                        }
                        if (edenInt > 2 && edenInt < 5) {
                            rez.append(hundredString).append(dozensString).append(" ").append(string1000ToInfinity[levelTriples - 1]).append("и");
                        }
                        if (edenInt >= 5 || edenInt == 0) {
                            rez.append(hundredString).append(dozensString).append(" ").append(string1000ToInfinity[levelTriples - 1]);
                        }
                    }
                }

                if (levelTriples > 1) {
                    if (edenInt == 1) {
                        rez.append(hundredString).append(dozensString).append(" ").append(string1000ToInfinity[levelTriples - 1]);
                    }
                    if (edenInt > 1 && edenInt < 5) {
                        rez.append(hundredString).append(dozensString).append(" ").append(string1000ToInfinity[levelTriples - 1]).append("а");
                    }
                    if (edenInt >= 5 || edenInt == 0) {
                        rez.append(hundredString).append(dozensString).append(" ").append(string1000ToInfinity[levelTriples - 1]).append("ов");
                    }
                }
            }
            levelTriples--;
        }
        rez.deleteCharAt(0);
        return rez.toString();
    }
}
