import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final String STR = "SciComLove";

    public static void main(String... args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        int len = STR.length();
        int remainCnt = input % STR.length();

        String firstPart = STR.substring(0, remainCnt);
        String secondPart = STR.substring(remainCnt);

        System.out.println(secondPart + firstPart);
    }
}
