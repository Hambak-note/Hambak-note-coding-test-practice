import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int MELT = 0;

    private static int row;
    private static int col;

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int[][] iceBurg;
    private static boolean[][] visited;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        iceBurg = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                iceBurg[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(findFirstYearWithMultiplePieces());
    }

    private static int findFirstYearWithMultiplePieces() {

        int findYear = 0;
        int separationCount;

        while(true) {

            separationCount = getSeparationCount();

            if(separationCount == 0) {
                findYear = 0;
                break;
            }

            if(separationCount >= 2) {
                break;
            }

            findYear = oneYearPassed(findYear);
        }

        return findYear;

    }

    private static int oneYearPassed(int year) {

        int[][] oneYearPassedIceBurg = new int[row][col];

        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {

                if(iceBurg[x][y] == MELT) continue;

                int meltCount = 0;
                for (int dir = 0; dir < 4; dir++) {
                    int nextX = x + dx[dir];
                    int nextY = y + dy[dir];

                    if(isOutOfRange(nextX, nextY)) continue;
                    if(iceBurg[nextX][nextY] == MELT) meltCount++;
                }

                oneYearPassedIceBurg[x][y] = iceBurg[x][y] - meltCount;
                if(oneYearPassedIceBurg[x][y] < MELT) oneYearPassedIceBurg[x][y] = MELT;
            }
        }

        iceBurg = oneYearPassedIceBurg;

        return ++year;
    }

    private static int getSeparationCount() {

        int separationCount = 0;

        visited = new boolean[row][col];

        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {

                if(isVisitOrMelt(x, y)) continue;

                separationCount++;
                Queue<int[]> pointQueue = new LinkedList<>();
                pointQueue.add(new int[]{x, y});

                while (!pointQueue.isEmpty()) {

                    int[] cur = pointQueue.poll();
                    int curX = cur[0];
                    int curY = cur[1];

                    for (int dir = 0; dir < 4; dir++) {

                        int nextX = curX + dx[dir];
                        int nextY = curY + dy[dir];

                        if(isOutOfRange(nextX, nextY)) continue;
                        if(isVisitOrMelt(nextX, nextY)) continue;

                        pointQueue.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }

        return separationCount;
    }

    private static boolean isVisitOrMelt(int x, int y) {
        return iceBurg[x][y] == MELT || visited[x][y];
    }

    private static boolean isOutOfRange(int x, int y) {
        return x < 0 || y < 0 || x >= row || y >= col;
    }
}
