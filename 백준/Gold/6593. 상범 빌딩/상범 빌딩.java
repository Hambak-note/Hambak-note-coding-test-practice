

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[] dx = {0, 0, 1, -1, 0, 0};
    private static int[] dy = {1, -1, 0, 0, 0, 0};
    private static int[] dh = {0, 0, 0, 0, 1, -1};
    private static int l, r, c;
    private static final int MAX_SIZE = 31;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(l == 0 && r == 0 && c == 0) break;

            Queue<int[]> queue = new LinkedList<>();
            char[][][] board = new char[MAX_SIZE][MAX_SIZE][MAX_SIZE];
            int[][][] dist = new int[MAX_SIZE][MAX_SIZE][MAX_SIZE];
            boolean isEscape = false;

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String cur = br.readLine();
                    for (int k = 0; k < c; k++) {
                        board[i][j][k] = cur.charAt(k);
                        if(board[i][j][k] == 'S') {
                            queue.add(new int[]{i, j, k});
                            dist[i][j][k] = 0;
                        }
                        else if(board[i][j][k] == '.') dist[i][j][k] = -1;
                    }
                }
                br.readLine();
            }

            while (!queue.isEmpty()) {

                if(isEscape) break;

                int[] cur = queue.poll();
                int curH = cur[0];
                int curX = cur[1];
                int curY = cur[2];

                for (int dir = 0; dir < 6; dir++) {
                    int nextH = curH + dh[dir];
                    int nextX = curX + dx[dir];
                    int nextY = curY + dy[dir];

                    if(nextX < 0 || nextX >= r || nextY < 0 || nextY >= c || nextH < 0 || nextH >= l) continue;
                    if(board[nextH][nextX][nextY] == '#' || dist[nextH][nextX][nextY] > 0) continue;

                    dist[nextH][nextX][nextY] = dist[curH][curX][curY] + 1;
                    if(board[nextH][nextX][nextY] == 'E') {
                        System.out.println("Escaped in " + dist[nextH][nextX][nextY] + " minute(s).");
                        isEscape = true;
                        break;
                    }
                    queue.add(new int[]{nextH, nextX, nextY});
                }
            }

            if(!isEscape) System.out.println("Trapped!");
        }
    }
}
