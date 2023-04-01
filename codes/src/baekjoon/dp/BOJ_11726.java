package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11726 {

    private static int n;
    private static int[] dp = new int[100005];
    private static final int mod = 10007;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        //초기값 정의
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++) {

            dp[i] = (dp[i-1]+dp[i-2]) % mod;
        }

        System.out.println(dp[n]);
    }
}
