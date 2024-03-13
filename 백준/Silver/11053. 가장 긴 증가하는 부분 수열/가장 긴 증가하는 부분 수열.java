import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        int sizeOfArray;
        int[] array;
        int[] dp;
        int longest = Integer.MIN_VALUE;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sizeOfArray = Integer.parseInt(br.readLine());
        array = new int[sizeOfArray];
        dp = new int[sizeOfArray];

        Arrays.fill(dp, 1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sizeOfArray; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < sizeOfArray; i++) {
            for (int j = 0; j < i; j++) {
                if(array[j] < array[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for(int i = 0; i < sizeOfArray; i++) {
            if(dp[i] > longest) longest = dp[i];
        }

        System.out.println(longest);
    }
}
