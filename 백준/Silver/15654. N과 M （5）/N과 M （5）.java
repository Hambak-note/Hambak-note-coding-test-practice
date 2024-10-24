import java.io.*;
import java.util.*;

public class Main {

    private static int n, m;
    private static int[] arr;
    private static int[] num;
    private static boolean[] isUsed;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        num = new int[n];
        isUsed = new boolean[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) num[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(num);
        func(0);
        System.out.println(sb);

    }

    private static void func(int k) {
        if(k == m) {
            for(int i = 0; i < m; i++) sb.append(num[arr[i]] + " ");
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!isUsed[i]) {
                arr[k] = i;
                isUsed[i] = true;
                func(k + 1);
                isUsed[i] = false;
            }
        }
    }
}
