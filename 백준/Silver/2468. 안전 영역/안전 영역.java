

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static final int FLOOD = -1;
    private static int areaSize;
    private static int[][] area;
    private static int maxHeight = Integer.MIN_VALUE;
    private static int minHeight = Integer.MAX_VALUE;
    private static int maximumNumberOfSafeAreas = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        areaSize = Integer.parseInt(br.readLine());
        area = new int[areaSize][areaSize];


        for(int i = 0; i < areaSize; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < areaSize; j++) {
                int height = Integer.parseInt(st.nextToken());
                area[i][j] = height;
                if(height > maxHeight) maxHeight = height;
                if(height < minHeight) minHeight = height;
            }
        }

        for(int i = minHeight; i < maxHeight; i++) {

            maximumNumberOfSafeAreas = Math.max(maximumNumberOfSafeAreas, findSafeArea(i));
        }


        System.out.println(maximumNumberOfSafeAreas);


    }


    private static int findSafeArea(int floodHeight) {

        boolean[][] visited = new boolean[areaSize][areaSize];
        int areaCount = 0;


        for(int i = 0; i < areaSize; i++) {

            for(int j = 0; j < areaSize; j++) {

                if(visited[i][j]) continue;
                if(area[i][j] == FLOOD) continue;
                if(area[i][j] <= floodHeight) {
                    area[i][j] = FLOOD;
                    continue;
                }

                areaCount++;

                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i, j});
                visited[i][j] = true;
                while (!queue.isEmpty()) {

                    int[] cur = queue.poll();
                    int curX = cur[0];
                    int curY = cur[1];

                    for(int dir = 0; dir < 4; dir++) {

                        int nextX = curX + dx[dir];
                        int nextY = curY + dy[dir];

                        if(isOutOfArea(nextX, nextY)) continue;
                        if(visited[nextX][nextY] || area[nextX][nextY] == FLOOD) continue;
                        if(area[nextX][nextY] <= floodHeight) {
                            area[nextX][nextY] = FLOOD;
                            continue;
                        }

                        visited[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
        }

        return areaCount;
    }

    private static boolean isOutOfArea(int x, int y) {
        return x < 0 || y < 0 || x >= areaSize || y >= areaSize;
    }
}
