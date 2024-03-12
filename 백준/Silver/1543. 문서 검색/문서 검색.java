

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static String inputStr;
    private static String searchStr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        inputStr = br.readLine();
        searchStr = br.readLine();

        int inputStrLen = inputStr.length();
        int searchStrLen = searchStr.length();

        String replacedInputStr = inputStr.replace(searchStr, "");
        int replacedInputStrLen = replacedInputStr.length();
        System.out.println((inputStrLen - replacedInputStrLen) / searchStrLen);

    }
}
