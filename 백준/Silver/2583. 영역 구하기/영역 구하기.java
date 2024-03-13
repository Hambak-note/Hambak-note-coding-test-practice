

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final int RECTANGLE = 1;
    private static final int VISITED = -1;

    private static int[] dx = new int[]{1, -1, 0, 0};
    private static int[] dy = new int[]{0, 0, 1, -1};

    private static int row;
    private static int col;
    private static int numberOfRectangle;

    private static int[][] array;

    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        numberOfRectangle = Integer.parseInt(st.nextToken());

        array = new int[row][col];

        for (int i = 0; i < numberOfRectangle; i++) {
            st = new StringTokenizer(br.readLine());
            Point leftDownPoint = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Point rightUpPoint = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            drawRectangleInArray(leftDownPoint, rightUpPoint);
        }

        int numberOfArea = 0;
        List<Integer> areaSizes = new ArrayList<>();
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {

                if(array[x][y] == RECTANGLE || array[x][y] == VISITED) continue;
                numberOfArea++;
                areaSizes.add(calculateAreaSize(x, y));
            }
        }

        System.out.println(numberOfArea);
        Collections.sort(areaSizes);
        for (Integer areaSize : areaSizes) {
            System.out.print(areaSize + " ");
        }
        System.out.println();

    }

    private static int calculateAreaSize(int x, int y) {

        int areaSize = 1;
        Queue<Point> points = new LinkedList<>();
        points.add(new Point(x, y));
        array[x][y] = VISITED;
        while(!points.isEmpty()) {

            Point curPoint = points.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = curPoint.getX() + dx[i];
                int nextY = curPoint.getY() + dy[i];

                if(isOutOfArraySize(nextX, nextY)) continue;
                if(array[nextX][nextY] == RECTANGLE || array[nextX][nextY] == VISITED) continue;

                points.add(new Point(nextX, nextY));
                array[nextX][nextY] = VISITED;
                areaSize++;
            }
        }

        return areaSize;
    }

    private static void drawRectangleInArray(Point leftDownPoint, Point rightUpPoint) {

        for (int y = leftDownPoint.getY(); y < rightUpPoint.getY(); y++) {
            for (int x = leftDownPoint.getX(); x < rightUpPoint.getX(); x++) {
                array[y][x] = RECTANGLE;
            }
        }
    }

    private static boolean isOutOfArraySize(int x, int y) {
        return x < 0 || y < 0 || x >= row || y >= col;
    }
}
