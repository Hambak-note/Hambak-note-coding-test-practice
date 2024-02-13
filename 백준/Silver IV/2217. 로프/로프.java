import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static int n;
    private static int[] w;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(w);

        int answer = 0;
        for(int i = 1; i <= n; i++) {
            answer = Math.max(answer, w[n-i] * i);
        }
        System.out.println(answer);
    }
}
