

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Main {

    static int[] dp = new int[1000005];
    static int[] pre = new int[1000005];
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp[1] = 0;
        for(int i = 2; i <= n; i++) {

            dp[i] = dp[i-1]+1;
            pre[i] = i-1;
            if(i%2 == 0 && dp[i] > dp[i/2] + 1)  {
                dp[i] = dp[i/2] + 1;
                pre[i] = i/2;
            }
            if(i%3 == 0 && dp[i] > dp[i/3] + 1){
                dp[i] =  dp[i/3] + 1;
                pre[i] = i/3;
            }
        }

        System.out.println(dp[n]);
        int cur = n;
        while(true){

            System.out.print(cur + " ");
            if(cur==1) break;
            cur = pre[cur];
        }
        System.out.println();

    }
}
