import java.util.*;
import java.io.*;

public class Main {

    private static final int MAX_POINT = 100001;

    private static int n, k;
    private static int[] dist = new int[MAX_POINT];


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        Arrays.fill(dist, -1);
        dist[n] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        while(dist[k] == -1) {

            int cur = q.poll();
            for(int next : new int[]{cur - 1, cur + 1, 2 * cur}) {
                if(next < 0 || next >= MAX_POINT) continue;
                if(dist[next] != -1) continue;
                dist[next] = dist[cur] + 1;
                q.add(next);
            }
        }
        
        System.out.println(dist[k]);
    }
}
