

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] r, g, b;
    static int[][] dp;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        r = new int[n+1];
        g = new int[n+1];
        b = new int[n+1];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            r[i] = Integer.parseInt(st.nextToken());
            g[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n+1][3];
        dp[1][0] = r[1];
        dp[1][1] = g[1];
        dp[1][2] = b[1];

        for(int i = 2; i <= n; i++) {

            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + r[i];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + g[i];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + b[i];
        }


        System.out.println(Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]));
    }
}
