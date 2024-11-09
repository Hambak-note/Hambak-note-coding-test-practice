import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = read();
        while (t-- > 0) {
            arr = new int[n = read()];
            for (int i = 0; i < n; i++) arr[i] = read();

            sb.append(isIncreasing() ? "YES\n" : "NO\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean isIncreasing() {
        arr[0] = Math.min(arr[0], n - arr[0] + 1);
        for (int i = 1; i < n; i++) {
            int min = Math.min(arr[i], n - arr[i] + 1), max = Math.max(arr[i], n - arr[i] + 1);

            if (arr[i - 1] <= min) arr[i] = min;
            else if (arr[i - 1] <= max) arr[i] = max;
            else return false;
        }

        return true;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}