

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n; //정점의 개수
    static int m; //간선의 개수
    static boolean[] vis = new boolean[1005];
    static ArrayList<Integer>[] adj = new ArrayList[1005];


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        System.out.println(bfs());
    }

    private static int bfs() {

        int num = 0;
        for(int i = 1; i <= n; i++) {
            if(vis[i]) continue;
            num++;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            vis[i] = true;
            while(!q.isEmpty()) {

                int cur = q.poll();
                for (int next : adj[cur]) {

                    if(vis[next]) continue;
                    q.add(next);
                    vis[next] = true;
                }
            }
        }

        return num;
    }
}
