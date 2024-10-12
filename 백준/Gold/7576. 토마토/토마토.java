import java.io.*;
import java.util.*;

public class Main {
    
    private static int m, n;
    private static int[][] board;
    private static int[][] dist;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        dist = new int[n][m];
        
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1) q.add(new int[]{i, j});
                if(board[i][j] == 0) dist[i][j] = -1;
            }
        }
        
        while(!q.isEmpty()) {
            
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            
            for(int dir = 0; dir < 4; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(dist[nx][ny] >= 0) continue;
                dist[nx][ny] = dist[cx][cy] + 1;
                q.add(new int[]{nx, ny});
            }
        }
        
        int answer = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(dist[i][j] == -1) {
                    System.out.println(-1);
                    return;
                }
                
                answer = Math.max(answer, dist[i][j]);
            }
        }
        
        System.out.println(answer);
    }
}
