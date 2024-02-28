

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final int INF = Integer.MAX_VALUE;
    private static int v; //정점의 개수
    private static int e; //간선의 개수
    private static int k; //시작 정점의 번호

    private static int from;
    private static int to;
    private static int cost;

    private static List<int[]> adj[];
    private static int[] distance; //최단 거리 테이블
    private static PriorityQueue<int[]> pq;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        k = Integer.parseInt(br.readLine());

        adj = new ArrayList[v+1];

        for(int i = 1; i <= v; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());

            adj[from].add(new int[]{cost, to});
        }

        pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        distance = new int[v+1];
        Arrays.fill(distance, INF);
        distance[k] = 0;

        pq.add(new int[]{distance[k], k});
        while(!pq.isEmpty()) {

            int[] cur = pq.poll();
            cost = cur[0];
            to = cur[1];

            if(distance[to] != cost) continue;

            for (int[] next : adj[to]) {
                if(distance[next[1]] <= distance[to] + next[0]) continue;
                distance[next[1]] = distance[to] + next[0];
                pq.add(new int[]{distance[next[1]], next[1]});
            }
        }

        for(int i = 1; i <= v; i++) {
            if(distance[i] == INF) System.out.println("INF");
            else System.out.println(distance[i]);
        }
    }
}
