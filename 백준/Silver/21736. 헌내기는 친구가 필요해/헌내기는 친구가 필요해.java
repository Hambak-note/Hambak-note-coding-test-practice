import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] campus = new char[n][m];
        boolean[][] visit = new boolean[n][m];

        int[] start = new int[2];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                campus[i][j] = line.charAt(j);
                if(campus[i][j] == 'I') {
                    start[0] = i;
                    start[1] = j;
                    visit[i][j] = true;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        int ans = 0;
        while(!queue.isEmpty()) {


            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            if (campus[x][y] == 'P') {
                ans++;
            }


            for (int dir = 0; dir < 4; dir++) {

                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(visit[nx][ny]) continue;
                if (campus[nx][ny] == 'X') continue;
                visit[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }

        if(ans == 0) System.out.println("TT");
        else System.out.println(ans);
    }
}
