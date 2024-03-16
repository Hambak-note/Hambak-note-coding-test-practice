import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 남은 N일 동안 최대한 많은 상담을 하려고 함
 * 상담을 완료하는데 걸리는 시간 Ti와 상당했을 때 받을 수 있는 금액 Pi
 * 상담 시 얻을 수 있는 최대 수익을 return
 */

public class Main {

    private static int remainDay;
    private static int[] period;
    private static int[] price;
    private static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        remainDay = Integer.parseInt(br.readLine());
        period = new int[remainDay];
        price = new int[remainDay];
        dp = new int[remainDay+1];

        for (int i = 0; i < remainDay; i++) {
            st = new StringTokenizer(br.readLine());
            period[i] = Integer.parseInt(st.nextToken());
            price[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < remainDay; i++) {

            if(i + period[i] <= remainDay) {
                dp[i + period[i]] = Math.max(dp[i+period[i]], dp[i]+price[i]);
            }

            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }


        System.out.println(dp[remainDay]);

    }
}
