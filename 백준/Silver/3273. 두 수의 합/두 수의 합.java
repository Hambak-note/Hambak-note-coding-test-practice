

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int[] nArr;
    private static int x;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        nArr = new int[n];
        for(int i = 0; i < n; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nArr);

        x = Integer.parseInt(br.readLine());

        int start = 0;
        int end = n-1;
        int count = 0;

        while(start < end) {

            int sum = nArr[start] + nArr[end];
            if(sum == x) {
                start++;
                end--;
                count++;
                continue;
            }

            if(sum > x) {
                end--;
                continue;
            }

            start++;
        }

        System.out.println(count);

    }
}
