

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Main {

    private static int n, m;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int endIdx = 0;
        int startIdx = 0;
        int result = Integer.MAX_VALUE;
        boolean flag = false;
        while(startIdx < n &&  endIdx < n) {
            int minus = arr[endIdx] - arr[startIdx];

            if(minus < m) {
                endIdx++;
            } else {
                result = min(minus, result);
                startIdx++;
            }
        }

        System.out.println(result);

    }
}
