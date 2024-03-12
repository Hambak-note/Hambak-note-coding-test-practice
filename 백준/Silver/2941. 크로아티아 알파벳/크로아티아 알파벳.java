

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static String[] alphabets = new String[]{"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    private static String inputStr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputStr = br.readLine();


        for (String alphabet : alphabets) {
            if(inputStr.contains(alphabet)) {
                inputStr = inputStr.replace(alphabet, "!");
            }
        }


        System.out.println(inputStr.length());

    }
}
