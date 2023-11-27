

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static int t;
    private static int n;

    private static int[][] fibo;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        initFibo();
        while(t-- > 0) {

            n = Integer.parseInt(br.readLine());
            System.out.println(fibo[n][0] + " " + fibo[n][1]);

        }

    }

    private static void initFibo() {

        fibo = new int[42][2];
        fibo[0][0] = 1;
        fibo[1][1] = 1;

        for(int i = 2; i <= 40; i++) {

            fibo[i][0] = fibo[i-1][0]+fibo[i-2][0];
            fibo[i][1] = fibo[i-1][1]+fibo[i-2][1];
        }
    }
}
