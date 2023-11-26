

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int testcase;
    private static int m;
    private static int n;
    private static int k;
    private static int[][] board;
    private static boolean[][] vis;

    private static final int[] dx = { 1,0,-1,0 };
    private static final int[] dy = { 0,1,0,-1 };


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        testcase = Integer.parseInt(br.readLine());

        while(testcase-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            board = new int[n+1][m+1];
            vis = new boolean[n+1][m+1];

            int x;
            int y;
            for(int i = 0; i < k; i++){
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                board[y][x] = 1;
            }

            int result = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(board[i][j] == 1 && !vis[i][j]) {
                        bfs(i, j);
                        result++;
                    }
                }
            }

            System.out.println(result);

            for(int i = 0; i < n; i++) {

                Arrays.fill(board[i], 0);
                Arrays.fill(vis[i], false);
            }

        }
    }

    private static void bfs(int x, int y) {

        vis[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while(!q.isEmpty()) {

            int[] cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nextX = cur[0] + dx[dir];
                int nextY = cur[1] + dy[dir];
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;
                if (vis[nextX][nextY] || board[nextX][nextY] != 1) continue;
                vis[nextX][nextY] = true;
                q.add(new int[]{ nextX,nextY });
            }
        }
    }
}
