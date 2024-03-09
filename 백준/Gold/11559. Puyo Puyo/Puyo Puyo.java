import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final int ROW_SIZE = 12;
    private static final int COL_SIZE = 6;
    private static final char BLANK = '.';
    private static final int BREAK_COND = 4;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    private static char[][] field;
    private static boolean[][] visited;
    private static int chainCnt;

    private static class Point {
        private int row;
        private int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }
    }

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        field = new char[ROW_SIZE][COL_SIZE];
        chainCnt = 0;

        for(int row = 0; row < ROW_SIZE; row++) {
            String inputRow = br.readLine();
            for(int col = 0; col < COL_SIZE; col++) {
                field[row][col] = inputRow.charAt(col);
            }
        }

        playGame();
        System.out.println(chainCnt);
    }


    private static void playGame() {

        while(breakField()) {
            moveField();
            chainCnt++;
        }
    }

    private static boolean breakField() {

        boolean isBreak = false;
        visited = new boolean[ROW_SIZE][COL_SIZE];
        
        for (int row = 0; row < ROW_SIZE; row++) {
            for(int col = 0; col < COL_SIZE; col++) {

                //공백이거나 이미 방문한 곳이라면
                if (field[row][col] == BLANK || visited[row][col]) continue;

                //공백이 아니라면
                Queue<Point> queue = new LinkedList<>();
                queue.add(new Point(row, col));
                List<Point> breakPoints = new ArrayList<>();

                while (!queue.isEmpty()) {

                    Point curPoint = queue.poll();
                    int curRow = curPoint.getRow();
                    int curCol = curPoint.getCol();
                    char curColor = field[curRow][curCol];
                    visited[curRow][curCol] = true;
                    breakPoints.add(curPoint);

                    for(int dir = 0; dir < dx.length; dir++) {
                        int nextRow = curRow + dx[dir];
                        int nextCol = curCol + dy[dir];

                        //field 의 범위를 넘어선다면
                        if(isOutOfRange(nextRow, nextCol)) continue;
                        //이미 방문했다면
                        if(visited[nextRow][nextCol]) continue;
                        //다른 색상이라면
                        if(curColor != field[nextRow][nextCol]) continue;
                        //같은색상이라면
                        Point nextPoint = new Point(nextRow, nextCol);
                        queue.add(nextPoint);
                    }
                }

                if(breakPoints.size() >= BREAK_COND) {
                    makeBreakPointsToBlank(breakPoints);
                    isBreak = true;
                }
            }
        }

        return isBreak;
    }

    private static void moveField(){

        for (int col = 0; col < COL_SIZE; col++) {

            int bottom = -1;

            for(int row = ROW_SIZE-1; row >= 0; row--) {

                if(field[row][col] == BLANK) {
                    if(row > bottom) bottom = row;
                    continue;
                }

                if(bottom != -1) {
                    field[bottom][col] = field[row][col];
                    field[row][col] = BLANK;
                    bottom--;
                }
            }
        }
    }
    private static void makeBreakPointsToBlank(List<Point> breakPoints) {

        for (Point breakPoint : breakPoints) {
            field[breakPoint.getRow()][breakPoint.getCol()] = BLANK;
        }
    }

    private static boolean isOutOfRange(int row, int col) {
        return (row < 0 || col < 0 || row >= ROW_SIZE || col >= COL_SIZE);
    }


}
