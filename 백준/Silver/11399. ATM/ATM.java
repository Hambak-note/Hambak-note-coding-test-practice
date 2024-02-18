

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static private int n;
    static private int answer;
    static private int[] p;
    static private int[] sum;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        p = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            p[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(p);

        sum = new int[n];
        sum[0] = p[0];
        answer = sum[0];
        for(int i = 1; i < n; i++) {

            sum[i] = p[i] + sum[i-1];
            answer += sum[i];
        }

        System.out.println(answer);
    }
}
