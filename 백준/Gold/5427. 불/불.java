import java.io.*;
import java.util.*;

public class Main {

    private static int tc, w, h;
    private static String[] map;
    private static int[][] fires;
    private static int[][] sg;

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    private static final char EMPTY = '.';
    private static final char WALL = '#';
    private static final char FIRE = '*';
    private static final char START = '@';

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        tc = Integer.parseInt(br.readLine());

        for(int testCase = 0; testCase < tc; testCase++) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new String[h];
            fires = new int[h][w];
            sg = new int[h][w];
            for(int i = 0; i < h; i++) {
                Arrays.fill(fires[i], -1);
                Arrays.fill(sg[i], -1);
            }

            Queue<int[]> fireQueue = new LinkedList<>();
            Queue<int[]> sgQueue = new LinkedList<>();
            for(int i = 0; i < h; i++) {
                map[i] = br.readLine();
                for(int j = 0; j < w; j++) {
                    char cur = map[i].charAt(j);
                    if(cur == FIRE) {
                        fires[i][j] = 0;
                        fireQueue.offer(new int[]{i, j});
                        continue;
                    }
                    if(cur == START) {
                        sg[i][j] = 0;
                        sgQueue.offer(new int[]{i, j});
                    }
                }
            }


            while(!fireQueue.isEmpty()) {

                int[] cur = fireQueue.poll();
                int cx = cur[0];
                int cy = cur[1];
                int time = fires[cx][cy];

                for(int dir = 0; dir < 4; dir++) {
                    int nx = cx + dx[dir];
                    int ny = cy + dy[dir];

                    if(nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                    if(map[nx].charAt(ny) == WALL) continue;
                    if(fires[nx][ny] != -1 && fires[nx][ny] <= (time+1)) continue;

                    fires[nx][ny] = time + 1;
                    fireQueue.offer(new int[]{nx, ny});
                }
            }

            boolean escape = false;
            while(!sgQueue.isEmpty() && !escape) {
                int[] cur = sgQueue.poll();
                int cx = cur[0];
                int cy = cur[1];
                int time = sg[cx][cy];

                for(int dir = 0; dir < 4; dir++) {
                    int nx = cx + dx[dir];
                    int ny = cy + dy[dir];

                    if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                        sb.append((time+1) + "\n");
                        escape = true;
                        break;
                    }
                    if(map[nx].charAt(ny) == WALL) continue;
                    if(fires[nx][ny] != -1 && fires[nx][ny] <= (time+1)) continue;

                    if(sg[nx][ny] != -1 && sg[nx][ny] <= (time+1)) continue;
                    sg[nx][ny] = time+1;
                    sgQueue.offer(new int[]{nx, ny});
                }
            }

            if(!escape) sb.append("IMPOSSIBLE\n");
        }
        
        System.out.println(sb);
    }
}
