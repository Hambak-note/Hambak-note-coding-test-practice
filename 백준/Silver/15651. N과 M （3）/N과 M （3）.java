import java.io.*;
import java.util.*;

public class Main {

    private static int n, m;
    private static int[] nums;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new int[m];

        find(0);
        System.out.print(sb.toString());

    }

    private static void find(int cnt) {

        if(cnt == m) {
            for(int i = 0; i < m; i++) sb.append(nums[i] + " ");
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= n; i++) {
            nums[cnt] = i;
            find(cnt + 1);
        }
    }
}
