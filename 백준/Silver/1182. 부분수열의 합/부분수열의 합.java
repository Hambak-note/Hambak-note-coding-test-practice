

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int S;
    private static int result = 0;
    private static int[] arr = new int[30];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        search(0, 0);
        if(S == 0) result = result - 1;
        System.out.println(result);

    }

    private static void search(int cur, int total) {

        if(cur == N) {
            if(total == S) result++;
            return;
        }
        search(cur + 1, total);
        search(cur+1, total+arr[cur]);
    }
}
