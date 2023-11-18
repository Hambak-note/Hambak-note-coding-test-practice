

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int t;
    static int n;
    static int m;
    static int[] coins;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        while(t-- > 0) {

            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            coins = new int[n+1];
            for(int i = 0; i < n; i++) coins[i] = Integer.parseInt(st.nextToken());

            m = Integer.parseInt(br.readLine());
            dp = new int[m+1];

            dp[0] = 1;
            for(int i = 0; i < n; i++) {
                for (int j = coins[i]; j <= m; j++) {
                    dp[j] += dp[j - coins[i]];
                }
            }
            System.out.println(dp[m]);
        }
    }
}
