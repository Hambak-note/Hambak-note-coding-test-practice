

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int ZERO = 48;
    private static int a, b, c;
    private static int mul;
    private static int[] numCnt = new int[10];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());
        c = Integer.parseInt(br.readLine());
        mul = a * b * c;

        String numStr = Integer.toString(mul);

        for(int i = 0; i < numStr.length(); i++) {

            int cur = numStr.charAt(i) - ZERO;
            numCnt[cur]++;
        }

        for(int i = 0; i < numCnt.length; i++) {
            System.out.println(numCnt[i]);
        }
    }
}
