import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int testCase;
    private static int size;
    private static int[] start = new int[2];
    private static int[] dest = new int[2];
    private static int[][] board = new int[302][302];
    private static Queue<int[]> queue = new LinkedList<>();

    private static int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
    private static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {

            size = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            dest[0] = Integer.parseInt(st.nextToken());
            dest[1] = Integer.parseInt(st.nextToken());

            for (int i = 0; i < board.length; i++) {
                Arrays.fill(board[i], -1);
            }

            board[start[0]][start[1]] = 0;
            queue.add(new int[]{start[0], start[1]});

            while(!queue.isEmpty()) {

                int[] cur = queue.poll();
                for(int d = 0; d < 8; d++) {

                    int nextX = cur[0] + dx[d];
                    int nextY = cur[1] + dy[d];

                    if(nextY < 0 || nextX < 0 || nextX >= size || nextY >= size) continue;
                    if(board[nextX][nextY] >= 0) continue;
                    board[nextX][nextY] = board[cur[0]][cur[1]] + 1;
                    queue.add(new int[]{nextX, nextY});
                }
            }

            System.out.println(board[dest[0]][dest[1]]);
        }
    }
}
