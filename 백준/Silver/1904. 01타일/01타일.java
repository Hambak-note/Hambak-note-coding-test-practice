import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int MOD = 15746;

    private static int stoneCnt;
    private static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        stoneCnt = Integer.parseInt(br.readLine());

        dp = new int[stoneCnt + 10];

        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= stoneCnt; i++) {

            dp[i] = (dp[i-1] + dp[i-2]) % MOD;
        }

        System.out.println(dp[stoneCnt]);

    }
}
