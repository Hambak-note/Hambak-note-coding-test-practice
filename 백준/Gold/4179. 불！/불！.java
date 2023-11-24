
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int r;
    private static int c;
    private static char[][] maze;
    private static int[][] fire;
    private static int[][] jihun;

    private static final int[] dx = new int[]{1, 0, -1, 0};
    private static final int[] dy = new int[]{0, 1, 0, -1};



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        fire = new int[r][c];
        jihun = new int[r][c];
        for(int i = 0; i < r; i++) {
            Arrays.fill(fire[i], -1);
            Arrays.fill(jihun[i], -1);
        }

        maze = new char[r][c];
        Queue<int[]> fireQ = new LinkedList<>();
        Queue<int[]> jihunQ = new LinkedList<>();
        for(int i = 0; i < r; i++) {
            String cur = br.readLine();
            for(int j = 0; j < c; j++) {

                maze[i][j] = cur.charAt(j);
                if(maze[i][j] == 'F') {
                    fireQ.add(new int[]{i, j});
                    fire[i][j] = 0;
                }
                if(maze[i][j] == 'J') {
                    jihunQ.add(new int[]{i, j});
                    jihun[i][j] = 0;
                }
            }
        }

        //불이 퍼지는 것에 대한 BFS
        while(!fireQ.isEmpty()) {
            int[] cur = fireQ.poll();
            for(int dir = 0; dir < dx.length; dir++) {

                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if(isOutOfBound(nx, ny)) continue;
                if(fire[nx][ny] >= 0 || maze[nx][ny] == '#') continue;
                fire[nx][ny] = fire[cur[0]][cur[1]] + 1;
                fireQ.add(new int[]{nx, ny});
            }
        }

        //지훈이의 위치에 대한 BFS
        while(!jihunQ.isEmpty()) {
            int[] cur = jihunQ.poll();
            for(int dir = 0; dir < dx.length; dir++) {

                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if(isOutOfBound(nx, ny)) {
                    System.out.println(jihun[cur[0]][cur[1]]+1);
                    return;
                }
                if(jihun[nx][ny] >= 0 || maze[nx][ny] == '#') continue;
                if(fire[nx][ny] != -1 && fire[nx][ny] <= jihun[cur[0]][cur[1]] + 1) continue;
                jihun[nx][ny] = jihun[cur[0]][cur[1]] + 1;
                jihunQ.add(new int[]{nx, ny});
            }
        }

        System.out.println("IMPOSSIBLE");

    }

    private static boolean isOutOfBound(int x, int y) {
        return x < 0 || y < 0 || x >= r || y >= c;
    }
}
