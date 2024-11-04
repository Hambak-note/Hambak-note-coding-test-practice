

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][n+1];
        int[] nums = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {

            int cur = Integer.parseInt(st.nextToken());
            nums[i] = cur;

            for(int j = 1; j <= i; j++) {

                if(i == j) dp[i][j] = 1;
                else if(i - j == 1) dp[j][i] = (nums[i] == nums[j]) ? 1 : 0;
                else {
                    dp[j][i] = (nums[i] == nums[j] && dp[j+1][i-1] == 1) ? 1 : 0;
                }
            }
        }

        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(dp[a][b] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
