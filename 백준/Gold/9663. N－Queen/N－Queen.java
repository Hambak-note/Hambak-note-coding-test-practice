import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int N;
    private static int result = 0;
    private static boolean[] used1 = new boolean[40];
    private static boolean[] used2 = new boolean[40];
    private static boolean[] used3 = new boolean[40];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        search(0);
        System.out.println(result);
    }


    private static void search(int cur) {

        if (cur == N) {
            result++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if(used1[i] || used2[i+cur] || used3[cur-i+N-1]) continue;

            used1[i] = true;
            used2[i+cur] = true;
            used3[cur - i + N - 1] = true;
            search(cur+1);
            used1[i] = false;
            used2[i + cur] = false;
            used3[cur - i + N - 1] = false;
        }
    }
}
