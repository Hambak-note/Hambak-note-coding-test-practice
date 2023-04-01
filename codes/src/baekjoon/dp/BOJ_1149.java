package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149 {

    private static int numberOfHouse;
    private static int[] paintingCostRed = new int[1005];
    private static int[] paintingCostGreen = new int[1005];
    private static int[] paintingCostBlue = new int[1005];
    private static int[][] dp = new int[1005][3];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        numberOfHouse = Integer.parseInt(br.readLine());

        for(int i = 1; i <= numberOfHouse; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            paintingCostRed[i] = Integer.parseInt(st.nextToken());
            paintingCostGreen[i] = Integer.parseInt(st.nextToken());
            paintingCostBlue[i] = Integer.parseInt(st.nextToken());
        }

        dp[1][0] = paintingCostRed[1];
        dp[1][1] = paintingCostGreen[1];
        dp[1][2] = paintingCostBlue[1];

        for(int i = 2; i <= numberOfHouse; i++){

            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + paintingCostRed[i];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + paintingCostGreen[i];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + paintingCostBlue[i];
        }

        System.out.println(Math.min(dp[numberOfHouse][0], Math.min(dp[numberOfHouse][1], dp[numberOfHouse][2])));
    }
}
