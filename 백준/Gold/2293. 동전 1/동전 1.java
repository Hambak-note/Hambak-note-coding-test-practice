import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n, k;
    private static int[] coinValue;
    private static int[] count = new int[10005];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coinValue = new int[n];

        for (int i = 0; i < n; i++) {

            coinValue[i] = Integer.parseInt(br.readLine());
        }

        count[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = coinValue[i]; j <= k; j++) {
                count[j] += count[j - coinValue[i]];
            }
        }

        System.out.println(count[k]);
    }
}
