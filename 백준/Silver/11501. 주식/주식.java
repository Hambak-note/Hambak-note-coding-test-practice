

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        long answer[] = new long[testCase];
        for(int t = 0; t < testCase; t++) {

            int day = Integer.parseInt(br.readLine());
            int[] stockPrices = new int[day];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < day; i++) {
                stockPrices[i] = Integer.parseInt(st.nextToken());
            }

            long max = 0;
            for(int i = day-1; i >= 0; i--) {
                if(max < stockPrices[i]) {
                    max = stockPrices[i];
                    continue;
                }

                answer[t] += (max - stockPrices[i]);
            }
        }

        for (long a : answer) {
            System.out.println(a);
        }



    }
}
