import java.io.*;
import java.util.*;

public class Main {

    private static int[] p;

    static class Edge {
        int u, v;
        int cost;

        public Edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        p = new int[n+1];
        Arrays.fill(p, -1);

        List<Edge> edges = new ArrayList<>();
        for(int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Edge(u, v, cost));
        }
        edges.sort((Comparator.comparingInt(edge -> edge.cost)));

        int cnt = 0;
        int totalCost = 0;
        for(int i = 0; i < m; i++) {
            Edge cur = edges.get(i);
            int u = cur.u;
            int v = cur.v;
            int cost = cur.cost;

            if(!isDiffGroup(u, v)) continue;
            cnt++;
            if(cnt == n-1) break;
            totalCost += cost;
        }

        System.out.println(totalCost);

    }

    private static int find(int x) {
        if(p[x] < 0) return x;
        return p[x] = find(p[x]);
    }

    private static boolean isDiffGroup(int u, int v) {
        u = find(u);
        v = find(v);

        if(u == v) return false;

        if(p[u] == p[v]) p[u]--;
        if(p[u] < p[v]) p[v] = u;
        else p[u] = v;
        return true;
    }
}
