import java.io.*;
import java.util.*;

public class Main {
    
    private static final int INF = 1_000 * 1_000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][3];
        int[][] dp = new int[n+1][3];
        int answer = INF;

        StringTokenizer st;
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        
        for(int color = 0; color < 3; color++) {
            
            for(int i = 0; i < 3; i++) {
                if(i == color) dp[1][i] = arr[1][i];
                else dp[1][i] = INF;
            }
            
            for(int i = 2; i <= n; i++) {
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
            }
            
            for(int i = 0; i < 3; i++) {
                if(i != color) answer = Math.min(answer, dp[n][i]);
            }
        }

        System.out.println(answer);
    }
}
