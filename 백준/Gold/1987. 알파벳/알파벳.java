import java.io.*;
import java.util.*;

public class Main {

    private static int r, c;
    private static char[][] board;
    private static boolean[] visit;

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    private static int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new char[r][c];
        visit = new boolean[26];

        String input;
        for(int i = 0; i < r; i++) {
            input = br.readLine();
            for(int j = 0; j < c; j++) board[i][j] = input.charAt(j);
        }

        dfs(0, 0, 1);

        System.out.println(result);
    }

    private static void dfs(int x, int y, int count) {

        visit[board[x][y] - 'A'] = true;
        result = Math.max(result, count);

        for(int dir = 0; dir < 4; dir++) {

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(isOutOfRange(nx, ny)) continue;

            if(!visit[board[nx][ny] - 'A']) {
                dfs(nx, ny, count+1);
                visit[board[nx][ny] - 'A'] = false;
            }
        }
    }

    private static boolean isOutOfRange(int x, int y) {
        return x >= r || y >= c || x < 0 || y < 0;
    }
}
