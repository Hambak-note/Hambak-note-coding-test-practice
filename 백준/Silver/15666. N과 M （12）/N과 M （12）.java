import java.io.*;
import java.util.*;

public class Main {

    private static int n, m;
    private static int[] nums;
    private static int[] result;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) set.add(Integer.parseInt(st.nextToken()));
        
        nums = set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(nums);
        n = nums.length;
        
        result = new int[m];
        
        backtrack(0, 0);
        System.out.print(sb);
    }
    
    private static void backtrack(int depth, int start) {
        
        if(depth == m) {
            for(int i = 0; i < m; i++) sb.append(result[i]).append(" ");
            sb.append("\n");
            return;
        }
        
        for(int i = start; i < n; i++) {
            result[depth] = nums[i];
            backtrack(depth + 1, i);
        }
    }
}
