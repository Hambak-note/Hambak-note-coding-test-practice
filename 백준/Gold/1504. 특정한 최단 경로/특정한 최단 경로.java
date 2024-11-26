import java.io.*;
import java.util.*;

public class Main {

    private static final int INF = 200000000;
    private static ArrayList<ArrayList<Node>> graph;
    private static int n, e; //정점의 개수, 간선의 개수

    private static class Node implements Comparable<Node> {

        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        long result = Math.min(
                (long) dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, n),
                (long) dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, n)
        );

        System.out.println(result >= INF ? -1 : result);

    }

    private static int dijkstra(int start, int end) {

        int[] distance = new int[n + 1];
        Arrays.fill(distance, INF);
        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {

            Node cur = pq.poll();

            if(distance[cur.end] < cur.weight) continue;

            for(Node next : graph.get(cur.end)) {
                int cost = distance[cur.end] + next.weight;

                if(cost < distance[next.end]) {
                    distance[next.end] = cost;
                    pq.offer(new Node(next.end, cost));
                }
            }
        }

        return distance[end];
    }
}
