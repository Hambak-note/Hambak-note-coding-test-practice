import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        int testCase;
        int n;
        int[][] stickerBoard;
        int[][] dp;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {

            n = Integer.parseInt(br.readLine());
            stickerBoard = new int[n][2];
            dp = new int[n][2];

            for (int y = 0; y < 2; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < n; x++) {
                    stickerBoard[x][y] = Integer.parseInt(st.nextToken());
                }
            }

            for (int x = 0; x < n; x++) {
                for (int y = 0; y < 2; y++) {
                    int max = 0;
                    if ( x > 1 ) max = Math.max(dp[x - 2][0], dp[x - 2][1]);
                    if ( x > 0 ) max = Math.max(max, dp[x-1][1-y]);
                    dp[x][y] = max + stickerBoard[x][y];
                }
            }

            System.out.println(Math.max(dp[n-1][0], dp[n-1][1]));
        }
    }
}
