import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[][] dist = new int[n][m];
        int[] start = new int[2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    start[0] = i;
                    start[1] = j;
                    dist[i][j] = 0;
                }
                if(map[i][j] == 0) dist[i][j] = 0;
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {

            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int dir = 0; dir < 4; dir++) {

                int nx = curX + dx[dir];
                int ny = curY + dy[dir];

                if(isOutOfBound(nx, ny, n, m)) continue;
                if(map[nx][ny] == 2 || map[nx][ny] == 0) continue;
                if(dist[nx][ny] != 0 && dist[nx][ny] != -1) continue;

                dist[nx][ny] = dist[curX][curY] + 1;
                queue.add(new int[]{nx, ny});
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static boolean isOutOfBound(int x, int y, int n, int m) {
        return x < 0 || y < 0 || x >= n || y >= m;
    }
}
