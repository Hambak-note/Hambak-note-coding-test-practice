import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] inDegree = new int[n+1];
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for(int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj.putIfAbsent(a, new ArrayList<>());
            adj.get(a).add(b);
            inDegree[b]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            if(inDegree[i] == 0) pq.add(i);
        }

        while(!pq.isEmpty()) {
            int cur = pq.poll();
            result.add(cur);

            if(adj.containsKey(cur)) {
                for(int nxt : adj.get(cur)) {
                    inDegree[nxt]--;
                    if(inDegree[nxt] == 0) pq.add(nxt);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        result.forEach(num -> sb.append(num + " "));
        System.out.println(sb);
    }
}
