
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int K;
    static int[] coinValue = new int[11];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            coinValue[i] = Integer.parseInt(br.readLine());
        }

        int minCoinCnt = 0;
        for(int i = N-1; i >= 0; i--) {
            minCoinCnt += K / coinValue[i];
            K %= coinValue[i];
        }

        System.out.println(minCoinCnt);

    }
}
