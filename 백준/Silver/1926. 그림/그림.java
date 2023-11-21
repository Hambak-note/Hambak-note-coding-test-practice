

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n; //세로 크기
    static int m; //가로 크기
    static boolean visit[][];
    static int paint[][];
    static int paintSize;
    static int paintCnt;
    final static int[] dx = {0, 0, -1, 1};
    final static int[] dy = {-1, 1, 0, 0};



    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visit = new boolean[n][m];
        paint = new int[n][m];
        for(int i = 0; i < n; i ++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                paint[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        paintCnt = 0;
        paintSize = 0;        
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                if(visit[i][j] || paint[i][j] == 0) continue;
                paintCnt++;
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{i, j});
                visit[i][j] = true;
                int curPaintSize = 0;
                while(!q.isEmpty()) {

                    int[] cur = q.poll();
                    int curX = cur[0];
                    int curY = cur[1];
                    curPaintSize++;
                    for(int dir = 0; dir < dx.length; dir++) {
                        int nextX = curX + dx[dir];
                        int nextY = curY + dy[dir];
                        if(isOutOfBound(nextX, nextY)) continue;
                        if(paint[nextX][nextY] == 0 || visit[nextX][nextY] == true) continue;
                        q.add(new int[]{nextX, nextY});
                        visit[nextX][nextY] = true;
                    }
                }
                paintSize = Math.max(paintSize, curPaintSize);
            }
        }

        System.out.println(paintCnt);
        System.out.println(paintSize);
    }

    private static boolean isOutOfBound(int x, int y) {

        return x < 0 || y <0 || x >= n || y >= m;
    }
}
