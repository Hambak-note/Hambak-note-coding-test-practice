import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int subin;
    private static int sister;
    private static int[] dist;

    private static final int ARRAY_SIZE = 100_002;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        subin = Integer.parseInt(st.nextToken());
        sister = Integer.parseInt(st.nextToken());

        dist = new int[ARRAY_SIZE];
        Arrays.fill(dist, -1);

        dist[subin] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(subin);
        while(dist[sister] == -1) {

            int cur = q.poll();
            for(int next : new int[]{cur -1, cur + 1, 2* cur}) {
                if(next < 0 || next > 100000) continue;
                if(dist[next] != -1) continue;
                dist[next] = dist[cur]+1;
                q.add(next);
            }
        }

        System.out.println(dist[sister]);
    }
}
