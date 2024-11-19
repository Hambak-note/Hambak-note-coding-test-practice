import java.io.*;
import java.util.*;

public class Main {

    private static int n;
    private static ArrayList<Integer>[] tree;
    private static int[][] dp;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) tree[i] = new ArrayList<>();
        dp = new int[n+1][2];
        visited = new boolean[n+1];

        for(int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree[u].add(v);
            tree[v].add(u);
        }
        
        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
    
    private static void dfs(int cur) {
        
        visited[cur] = true;
        dp[cur][0] = 0;
        dp[cur][1] = 1;
        
        for(int nxt : tree[cur]) {
            
            if(!visited[nxt]) {
                dfs(nxt);
                dp[cur][0] += dp[nxt][1];
                dp[cur][1] += Math.min(dp[nxt][0], dp[nxt][1]);
            }
        }
    }
}
