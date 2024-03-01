import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int row;
    private static int col;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        System.out.println(recursive(N, row, col));

    }

    private static int recursive(int n, int r, int c) {
        if(n == 0) return 0;
        int half = 1<<(n-1);
        if(r < half && c < half) return recursive(n - 1, r, c);
        if(r < half && c >= half) return half * half + recursive(n - 1, r, c - half);
        if(r >= half && c < half) return 2*half*half + recursive(n-1, r-half, c);
        return 3 * half * half + recursive(n - 1, r - half, c - half);
    }
}
