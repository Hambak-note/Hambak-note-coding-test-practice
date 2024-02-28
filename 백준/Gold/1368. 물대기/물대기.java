import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    /*논의 수*/
    private static int n;

    /*간선들의 정보*/
    private static List<Edge> edges;

    private static int[] parent;

    static class Edge implements Comparable<Edge>{

        private int from;
        private int to;
        private int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        public int getFrom() {
            return this.from;
        }

        public int getTo() {
            return this.to;
        }

        public int getCost() {
            return this.cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        edges = new ArrayList<>();

        //임의의 정점 추가 후 우물을 팔 때 드는 비용을 연결하는 비용으로 전환
        for(int i = 1; i <= n; i++) {
            int cost = Integer.parseInt(br.readLine());
            edges.add(new Edge(0, i, cost));
        }


        //논을 연결하는데 드는 비용을 입력
        for(int i = 1; i <= n; i++) {

            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {

                int cost = Integer.parseInt(st.nextToken());
                if(i >= j) continue;
                edges.add(new Edge(i, j, cost));
            }
        }

        //간선의 비용으로 오름차순 정렬
        Collections.sort(edges);

        parent = new int[n+1];
        for(int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        int result = 0;
        for (Edge edge : edges) {

            int fromParent = findParent(edge.getFrom());
            int toParent = findParent(edge.getTo());

            if(fromParent == toParent) continue;

            result += edge.getCost();
            parent[toParent] = fromParent;
        }

        System.out.println(result);
    }

    static private int findParent(int node) {
        if(parent[node] == node) return node;
        return parent[node] = findParent(parent[node]);
    }
}
