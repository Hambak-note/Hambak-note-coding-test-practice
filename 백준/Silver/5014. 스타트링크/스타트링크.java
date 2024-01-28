import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int f, s, g, u, d;
    private static int[] distance;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        distance = new int[f+1];
        Arrays.fill(distance, -1);

        Queue<Integer> queue = new LinkedList<>();
        distance[s] = 0;
        queue.add(s);

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int next : new int[]{cur + u, cur - d}) {
                if(next > f || next <= 0 || distance[next] != -1) continue;
                distance[next] = distance[cur] + 1;
                queue.add(next);
            }
        }

        if(distance[g] == -1) System.out.println("use the stairs");
        else System.out.println(distance[g]);
    }
}
