import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int grapeCupCnt;
    private static int[] grapeCups;
    private static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        grapeCupCnt = Integer.parseInt(br.readLine());
        grapeCups = new int[grapeCupCnt + 10];
        dp = new int[grapeCupCnt + 10];

        for(int i = 1; i <= grapeCupCnt; i++) {
            grapeCups[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = grapeCups[1];
        dp[2] = grapeCups[1] + grapeCups[2];

        for(int i = 3; i <= grapeCupCnt; i++) {

            dp[i] = Math.max(Math.max(dp[i - 1], dp[i - 2] + grapeCups[i]), dp[i - 3] + grapeCups[i - 1] + grapeCups[i]);
        }

        System.out.println(dp[grapeCupCnt]);
        
    }
}
