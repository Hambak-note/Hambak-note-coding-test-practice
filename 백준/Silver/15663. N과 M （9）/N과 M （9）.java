import java.io.*;
import java.util.*;

public class Main {

    private static int n, m;
    private static int[] nums;
    private static int[] result;
    private static boolean[] used;
    private static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new int[n];
        result = new int[m];
        used = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) nums[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(nums);

        backtrack(0);
        System.out.print(sb);

    }

    private static void backtrack(int depth) {

        if(depth == m) {
            for(int i = 0; i < m; i++) sb.append(result[i]).append(" ");
            sb.append("\n");
            return;
        }

        int prev = -1;
        for(int i = 0; i < n; i++) {

            if(!used[i] && prev != nums[i]) {
                used[i] = true;
                result[depth] = nums[i];
                prev = nums[i];
                backtrack(depth + 1);
                used[i] = false;
            }
        }
    }
}