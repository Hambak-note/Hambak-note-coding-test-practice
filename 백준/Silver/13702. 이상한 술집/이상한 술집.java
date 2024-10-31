import java.io.*;
import java.util.*;

public class Main {

    private static int n, k;
    private static long[] pots;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        pots = new long[n];

        long min = 1;
        long max = 0;
        long answer = 0;

        for(int i = 0; i < n; i++) {
            pots[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, pots[i]);
        }

        while(min <= max) {

            long mid = (min + max) / 2;

            int cnt = 0;
            for(int i = 0; i < n; i++) {
                cnt += (pots[i] / mid);
            }

            if(cnt >= k) {
                answer = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
