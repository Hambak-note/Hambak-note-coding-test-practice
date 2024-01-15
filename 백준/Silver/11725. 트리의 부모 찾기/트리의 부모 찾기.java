
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] parents = new int[N+1];
        boolean[] visited = new boolean[N + 1];
        ArrayList<Integer>[] connections = new ArrayList[N+1];

        for(int i = 1; i <= N; i++) {
            connections[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            connections[node1].add(node2);
            connections[node2].add(node1);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while(!queue.isEmpty()) {

            int cur = queue.poll();

            for(int connection : connections[cur]) {
                if(visited[connection]) continue;

                visited[connection] = true;
                queue.add(connection);
                parents[connection] = cur;
            }
        }

        for (int i = 2; i <= N; i++) {
            System.out.println(parents[i]);
        }
    }
}
