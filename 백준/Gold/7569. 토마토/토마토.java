import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[] dx = {1, -1, 0, 0, 0, 0};
    private static int[] dy = {0, 0, 1, -1, 0, 0};
    private static int[] dh = {0, 0, 0,  0, 1, -1};
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] box = new int[n][m][h];

        Queue<int[]> queue = new LinkedList<>();
        for(int k = 0; k < h; k++) {

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < m; j++) {
                     int input = Integer.parseInt(st.nextToken());
                     if(input == 0) {
                         box[i][j][k] = INF;
                         continue;
                     }
                     if(input == 1) queue.add(new int[]{i, j, k});
                     box[i][j][k] = input;
                }
            }
        }

        while(!queue.isEmpty()) {

            int[] point = queue.poll();
            int curX = point[0];
            int curY = point[1];
            int curH = point[2];
            int curValue = box[curX][curY][curH];

            for (int dir = 0; dir < dx.length; dir++) {

                int nx = curX + dx[dir];
                int ny = curY + dy[dir];
                int nh = curH + dh[dir];

                if(nx < 0 || ny < 0 || nh < 0 || nx >= n || ny >= m || nh >= h) continue;
                if(box[nx][ny][nh] == -1) continue;

                int nextValue = box[nx][ny][nh];
                if(nextValue <= (curValue + 1)) continue;

                box[nx][ny][nh] = curValue + 1;
                queue.add(new int[]{nx, ny, nh});
            }
        }

        int ans = -1;
        boolean hasINF = false;
        for(int k = 0; k < h && !hasINF; k++) {
            for (int i = 0; i < n && !hasINF; i++) {
                for (int j = 0; j < m && !hasINF; j++) {

                    if(box[i][j][k] == INF) hasINF = true;
                    ans = Math.max(box[i][j][k], ans);
                }
            }
        }

        if(hasINF) System.out.println(-1);
        else System.out.println(ans - 1);

    }
}
