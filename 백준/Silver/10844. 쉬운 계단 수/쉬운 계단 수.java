import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int MOD = 1000000000;

    private static int totalStairCnt;
    private static long[][] dp = new long[101][10];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        totalStairCnt = Integer.parseInt(br.readLine());

        for(int i = 1; i <= 9; i++) dp[1][i] = 1;

        for(int stairCnt = 2; stairCnt <= totalStairCnt; stairCnt++) {
            for (int targetNum = 0; targetNum <= 9; targetNum++) {
                if(targetNum != 0) dp[stairCnt][targetNum] += dp[stairCnt - 1][targetNum - 1];
                if(targetNum != 9) dp[stairCnt][targetNum] += dp[stairCnt - 1][targetNum + 1];
                dp[stairCnt][targetNum] %= MOD;
            }
        }

        long answer = 0;
        for (int targetNum = 0; targetNum <= 9; targetNum++) {
            answer += dp[totalStairCnt][targetNum];
        }
        answer %= MOD;
        System.out.println(answer);

    }
}
