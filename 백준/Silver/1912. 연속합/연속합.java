

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int[] inputs;
    private static int[] sums;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        inputs = new int[n+1];
        sums = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MIN_VALUE;
        for(int i=1; i <= n; i++) {
            sums[i] = Math.max(0, sums[i-1]) + inputs[i];

            if(answer < sums[i]) answer = sums[i];
        }

        System.out.println(answer);
    }
}
