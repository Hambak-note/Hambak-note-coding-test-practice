

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /* 학생의 수 */
    private static int n;

    /* 키를 비교한 횟수 */
    private static int m;

    private static int[] degree;

    private static List<Integer> adj[];

    private static Queue<Integer> queue = new LinkedList<>();
    private static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        degree = new int[n+1];
        adj = new ArrayList[n+1];
        for(int i = 1; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());

            degree[after]++;
            adj[before].add(after);
        }


        for(int i = 1; i <= n; i++) {
            if(degree[i] == 0) queue.add(i);
        }

        while(!queue.isEmpty()) {

            int cur = queue.poll();
            result.add(cur);

            for(int next : adj[cur]) {
                degree[next]--;
                if(degree[next] == 0) queue.add(next);
            }
        }

        if(result.size() != n) {
            System.out.println("cycle exists");
        }else {
            for(int x : result) System.out.print(x + " ");
        }

        System.out.println();

    }
}
