

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] maze;
    static int[][] dist;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maze = new int[n][m];
        dist = new int[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        for(int i = 0; i < n; i++){
            String curRow = br.readLine();
            for(int j = 0; j < m; j++) {
                maze[i][j] = Character.getNumericValue(curRow.charAt(j));
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        dist[0][0] = 0;

        while(!q.isEmpty()) {

            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int dir = 0; dir < 4; dir++) {
                int nextX = curX + dx[dir];
                int nextY = curY + dy[dir];

                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;
                //시작 위치 인지 확인
                if(dist[nextX][nextY] >= 0 || maze[nextX][nextY] != 1) continue;
                dist[nextX][nextY] = dist[curX][curY] + 1;
                q.add(new int[]{nextX, nextY});
            }
        }

        System.out.println(dist[n-1][m-1]+1);
     }
}
