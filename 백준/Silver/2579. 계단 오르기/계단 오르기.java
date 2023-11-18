

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[] stairs;
    static int[][] dp;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());


        stairs = new int[n+1];

        for(int i = 1; i <= n; i++) stairs[i] = Integer.parseInt(br.readLine());
        if(n == 1) {
            System.out.println(stairs[1]);
            return;
        }

        dp = new int[n+1][3];
        dp[1][1] = stairs[1];
        dp[1][2] = 0;
        dp[2][1] = stairs[2];
        dp[2][2] = stairs[2] + stairs[1];

        for(int i = 3; i <=n; i++) {

            dp[i][1] = Math.max(dp[i-2][1], dp[i-2][2]) + stairs[i];
            dp[i][2] = dp[i-1][1] + stairs[i];
        }

        System.out.println(Math.max(dp[n][1], dp[n][2]));


    }
}
