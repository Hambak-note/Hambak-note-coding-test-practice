package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579 {

    static int numberOfSteps;
    static int[] valuesOfSteps = new int[305];
    static int[][] dp = new int[305][3];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        numberOfSteps = Integer.parseInt(br.readLine());


        for (int i = 1; i <= numberOfSteps; i++) {
            valuesOfSteps[i] = Integer.parseInt(br.readLine());
        }

        if(numberOfSteps==1){
            System.out.println(valuesOfSteps[1]);
            return;
        }

        dp[1][1] = valuesOfSteps[1];
        dp[1][2] = 0;
        dp[2][1] = valuesOfSteps[2];
        dp[2][2] = valuesOfSteps[1] + valuesOfSteps[2];

        for(int i = 3; i <= numberOfSteps; i++){
            dp[i][1] = Math.max(dp[i-2][1], dp[i-2][2])+valuesOfSteps[i];
            dp[i][2] = dp[i-1][1] + valuesOfSteps[i];
        }

        System.out.println(Math.max(dp[numberOfSteps][1], dp[numberOfSteps][2]));

    }
}
