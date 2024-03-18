

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int testCase;
    private static int N;
    private static long[] dp;

    private static final long MOD = 1000000009;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        testCase = Integer.parseInt(br.readLine());

        dp = new long[1000010];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int j = 4; j <= 1000000; j++) {

            dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            dp[j] = dp[j] % MOD;
        }

        for(int i = 0; i < testCase; i++) {

            N = Integer.parseInt(br.readLine());
            System.out.println(dp[N]);
        }
    }
}
