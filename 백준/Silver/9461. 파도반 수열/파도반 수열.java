import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int P_SIZE = 110;

    public static void main(String[] args) throws IOException {

        int testCase;
        int n;
        long[] p = new long[P_SIZE];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        p[1] = 1;
        p[2] = 1;
        p[3] = 1;

        for (int i = 4; i <= 100; i++) {
            p[i] = p[i-2] + p[i-3];
        }

        testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {

            n = Integer.parseInt(br.readLine());
            sb.append(p[n]).append('\n');
        }

        System.out.println(sb);

    }
}
