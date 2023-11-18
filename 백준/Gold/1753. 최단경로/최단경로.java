


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int v; //정점의 개수
    static int e; //간선의 개수
    static int start; //시작 정점
    static int[] dist = new int[20005]; //최단 거리
    static List<Pair>[] adj = new ArrayList[20005];

    static class Pair implements Comparable<Pair> {
        int w;
        int v;
        public Pair() {};
        public Pair(int w, int v) {
            this.w = w;
            this.v = v;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.w, o.w);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        Arrays.fill(dist, 1, v+1, Integer.MAX_VALUE);

        for(int i = 1; i <= v; i++) {
            adj[i] = new ArrayList<>();
        }

        while(e-- > 0) {
            int u,v,w;
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            adj[u].add(new Pair(w, v));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        dist[start] = 0;

        //우선순위 큐에(0, 시작점) 추가
        pq.add(new Pair(dist[start], start));
        while(!pq.isEmpty()) {

            Pair cur = pq.poll();

            if(dist[cur.v] != cur.w) continue;
            for (Pair next : adj[cur.v]) {

                if(dist[next.v] <= dist[cur.v] + next.w) continue;
                dist[next.v] = dist[cur.v] + next.w;
                pq.add(new Pair(dist[next.v], next.v ));
            }
        }

        for(int i = 1; i <= v; i++) {

            if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }
}
