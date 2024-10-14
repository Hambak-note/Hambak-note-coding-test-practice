import java.io.*;

public class Main {

    private static String inputStr;
    private static String targetStr;
    private static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        inputStr = br.readLine();
        targetStr = br.readLine();
        answer = 0;

        int inputStrLen = inputStr.length();
        int targetStrLen = targetStr.length();

        String replacedStr = inputStr.replace(targetStr, "");
        int replacedStrLen = replacedStr.length();

        answer = (inputStrLen - replacedStrLen) / targetStrLen;
        System.out.println(answer);
    }
}
