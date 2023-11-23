

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] box;
    static int[][] dist;
    static Queue<int[]> q;
    static final int IMPOSSIBLE = -1;
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        init();
        bfs();
        System.out.println(calMinDateTomato());
    }

    static private void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());


        box = new int[n][m];
        dist = new int[n][m];
        q = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++) {

                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1) {
                    q.add(new int[]{i, j});
                    continue;
                }
                if(box[i][j] == 0) dist[i][j] = -1;
            }
        }
    }

    static private void bfs() {

        while(!q.isEmpty()) {

            int[] cur = q.poll();
            for(int dir = 0; dir < dx.length; dir++) {
                int nextX = cur[0] + dx[dir];
                int nextY = cur[1] + dy[dir];
                if(isOutOfBound(nextX, nextY)) continue;
                if(isVisit(nextX, nextY)) continue;

                dist[nextX][nextY] = dist[cur[0]][cur[1]] + 1;
                q.add(new int[]{nextX, nextY});
            }
        }
    }

    static private int calMinDateTomato() {
        int minDate = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(dist[i][j] == IMPOSSIBLE) return IMPOSSIBLE;
                minDate = Math.max(minDate, dist[i][j]);
            }
        }
        return minDate;
    }

    static private boolean isOutOfBound(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >=m;
    }

    static private boolean isVisit(int x, int y) {
        return dist[x][y] >= 0;
    }
}
