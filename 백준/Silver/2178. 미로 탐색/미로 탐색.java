import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static String[] board;
    static int[][] dist;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new String[n];
        dist = new int[n][m];

        for(int i = 0; i < n; i++) {
            board[i] = br.readLine();
        }

        for(int i = 0; i < n; i++) Arrays.fill(dist[i], -1);

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        dist[0][0] = 0;

        while(!q.isEmpty()) {

            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int dir = 0; dir < 4; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(dist[nx][ny] >= 0 || board[nx].charAt(ny) != '1') continue;

                dist[nx][ny] = dist[cx][cy] + 1;
                q.add(new int[]{nx, ny});
            }
        }

        System.out.println(dist[n-1][m-1] + 1);
    }
}
