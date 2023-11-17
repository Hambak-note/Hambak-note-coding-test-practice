

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    static int n, m;
    static char[][] board = new char[1000][1000];
    static int[][][] dist = new int[1000][1000][2];

    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};

    static class Tuple {
        int x;
        int y;
        int broken;

        public Tuple() {
        }

        public Tuple(int x, int y, int broken) {
            this.x = x;
            this.y = y;
            this.broken = broken;
        }
    }


    public static void main(String[] args) throws IOException {

        initInputAndBoard();
        System.out.println(bfs());

    }
    private static void initInputAndBoard() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            String row = br.readLine();
            for(int j = 0; j < row.length(); j++) {
                board[i][j] = row.charAt(j);
            }
        }
    }

    private static int bfs() {

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dist[i][j][0] = dist[i][j][1] = -1;
            }
        }
        dist[0][0][0] = dist[0][0][1] = 1;

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, 0, 0));

        while(!q.isEmpty()) {

            Tuple peek = q.peek();
            int x = peek.x;
            int y = peek.y;
            int broken = peek.broken;

            if(x == n-1 && y == m-1) return dist[x][y][broken];
            q.remove();

            int nextDist = dist[x][y][broken] + 1;
            for (int dir = 0; dir < 4; dir++) {

                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if(isOutOfBound(nx, ny)) continue;
                if(board[nx][ny] == '0' && dist[nx][ny][broken] == -1) {
                    dist[nx][ny][broken] = nextDist;
                    q.add(new Tuple(nx, ny, broken));
                }
                // {nx, ny}를 부수는 경우
                if((broken==0) && board[nx][ny] == '1' && dist[nx][ny][1] == -1) {
                    dist[nx][ny][1] = nextDist;
                    q.add(new Tuple(nx, ny, 1));
                }
            }
        }
        return -1;
    }

    private static boolean isOutOfBound(int x, int y) {
        return  x <0 || y <0 || x >=n || y >= m;
    }
}
