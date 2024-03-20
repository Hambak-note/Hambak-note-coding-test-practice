import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int MOD = 10007;
    private static final int N_SIZE = 1003;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[N_SIZE][10];
        long result = 0;

        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j < 10; j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % MOD;
            }
        }

        for(int i = 0; i < 10; i++) {
            result = (result + dp[n][i]) % MOD;
        }

        System.out.println(result);

    }
}
