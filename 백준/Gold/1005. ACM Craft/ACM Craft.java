import java.io.*;
import java.util.*;


public class Main {

    private static int t; //테스트 케이스
    private static int n; //건물의 개수
    private static int k; //건설순서 규칙의 총 개수
    private static int[] d; //건물당 건설에 걸리는 시간
    private static int w; //건설해야 할 건물의 번호
    private static int[] in;
    private static int[] cost;
    private static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int tc = 0; tc < t; tc++) {

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            d = new int[n + 1];
            in = new int[n + 1];
            cost = new int[n + 1];
            adj = new ArrayList[n + 1];
            for(int i = 1; i <= n; i++) {
                adj[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= n; i++) d[i] = Integer.parseInt(st.nextToken());

            for(int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adj[from].add(to);
                in[to] += 1;
            }

            w = Integer.parseInt(br.readLine());


            Queue<Integer> q = new LinkedList<>();
            for(int i = 1; i <= n; i++) {
                if(in[i] == 0) {
                    cost[i] = d[i];
                    q.add(i);
                }
            }

            while (!q.isEmpty()) {

                int cur = q.poll();

                for(int i = 0; i < adj[cur].size(); i++) {
                    int next = adj[cur].get(i);
                    cost[next] = Math.max(cost[next], cost[cur] + d[next]);
                    in[next] -= 1;
                    if(in[next] == 0) q.add(next);
                }
            }

            System.out.println(cost[w]);


        }


    }
}
