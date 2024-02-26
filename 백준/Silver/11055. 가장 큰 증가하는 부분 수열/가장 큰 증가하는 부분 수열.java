

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int arrSize;
    private static int[] arr;
    private static int[] dp;



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        arrSize = Integer.parseInt(st.nextToken());

        arr = new int[arrSize];
        dp = new int[arrSize];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arrSize; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = arr[i];
        }

        for (int i = 0; i < arrSize; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i]) dp[i] = Math.max(dp[i], dp[j] + arr[i]);
            }
        }

        int result = 0;
        for (int element : dp) {
            if(result < element) result = element;
        }

        System.out.println(result);


    }
}
