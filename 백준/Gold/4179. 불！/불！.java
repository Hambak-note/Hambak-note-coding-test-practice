
import java.io.*;
import java.util.*;

public class Main {

    private static int r, c;
    private static String[] board;
    private static int[][] dist1;
    private static int[][] dist2;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new String[r];
        dist1 = new int[r][c];
        dist2 = new int[r][c];

        for(int i = 0; i < r; i++) {
            board[i] = br.readLine();
            Arrays.fill(dist1[i], -1);
            Arrays.fill(dist2[i], -1);
        }

        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {

                if(board[i].charAt(j) == 'F') {
                    q1.add(new int[]{i, j});
                    dist1[i][j] = 0;
                }

                if(board[i].charAt(j) == 'J') {
                    q2.add(new int[]{i, j});
                    dist2[i][j] = 0;
                }
            }
        }

        // BFS for Fire
        while(!q1.isEmpty()) {

            int[] cur = q1.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int dir = 0; dir < 4; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];

                if(nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                if(dist1[nx][ny] >= 0 || board[nx].charAt(ny) == '#') continue;
                dist1[nx][ny] = dist1[cx][cy] + 1;
                q1.add(new int[]{nx, ny});
            }
        }

        //BFS for Jihoon
        while(!q2.isEmpty()) {

            int[] cur = q2.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int dir = 0; dir < 4; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];

                if(nx < 0 || ny < 0 || nx >= r || ny >= c) {
                    System.out.println(dist2[cx][cy] + 1);
                    return;
                }
                if(dist2[nx][ny] >= 0 || board[nx].charAt(ny) == '#') continue;
                if(dist1[nx][ny] != -1 && dist1[nx][ny] <= dist2[cx][cy] + 1) continue;
                dist2[nx][ny] = dist2[cx][cy] + 1;
                q2.add(new int[]{nx, ny});
            }
        }
        
        System.out.println("IMPOSSIBLE");
    }
}
