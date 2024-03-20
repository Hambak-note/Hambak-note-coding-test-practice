import java.util.LinkedList;
import java.util.Queue;

class Solution {

        private final int INNER = 1;
        private final int BORDER = 2;
        private final int MAX_BOARD_SIZE = 101;

        private final int[] dx = {1, -1, 0, 0};
        private final int[] dy = {0, 0, 1, -1};

        public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

            int[][] board = drawBorderInBoard(rectangle);
            Point characterPoint = new Point(characterX * 2, characterY * 2);
            Point itemPoint = new Point(itemX * 2, itemY * 2);
            int shortDistance = findShortDistance(characterPoint, itemPoint, board);

            return shortDistance;
        }

        private int findShortDistance(Point chracterPoint, Point itemPoint, int[][] board) {

            boolean[][] visit = new boolean[MAX_BOARD_SIZE][MAX_BOARD_SIZE];
            int shortDistance = Integer.MAX_VALUE;

            Queue<Point> queue = new LinkedList<>();
            queue.add(chracterPoint);
            visit[chracterPoint.getX()][chracterPoint.getY()] = true;

            while (!queue.isEmpty()) {

                Point curPoint = queue.poll();
                int curX = curPoint.getX();
                int curY = curPoint.getY();
                int curCount = curPoint.getCount();

                for (int dir = 0; dir < 4; dir++) {

                    int nextX = curX + dx[dir];
                    int nextY = curY + dy[dir];
                    int nextCount = curCount + 1;

                    if(isOutOfRange(nextX, nextY)) continue;
                    if(isItemPoint(nextX, nextY, itemPoint)) {
                        shortDistance = Math.min(shortDistance, nextCount / 2);
                        break;
                    }
                    if(board[nextX][nextY] != BORDER || visit[nextX][nextY]) continue;

                    visit[nextX][nextY] = true;
                    queue.add(new Point(nextX, nextY, nextCount));
                }
            }

            return shortDistance;
        }

        private int[][] drawBorderInBoard(int[][] rectangle) {

            int[][] board = new int[MAX_BOARD_SIZE][MAX_BOARD_SIZE];

            for (int i = 0; i < rectangle.length; i++) {

                Point leftDownPoint = new Point(rectangle[i][0]*2, rectangle[i][1]*2);
                Point rightUpPoint = new Point(rectangle[i][2]*2, rectangle[i][3]*2);

                for(int x = leftDownPoint.getX(); x <= rightUpPoint.getX(); x++) {
                    for(int y = leftDownPoint.getY(); y <= rightUpPoint.getY(); y++) {
                        if(board[x][y] == INNER) continue;
                        board[x][y] = INNER;
                        if(x == leftDownPoint.getX() || x == rightUpPoint.getX()) board[x][y] = BORDER;
                        if(y == leftDownPoint.getY() || y == rightUpPoint.getY()) board[x][y] = BORDER;
                    }
                }
            }

            return board;
        }

        private boolean isOutOfRange(int x, int y){
            return x < 0 || y < 0 || x >= MAX_BOARD_SIZE || y >= MAX_BOARD_SIZE;
        }

        private boolean isItemPoint(int x, int y, Point itemPoint) {
            return x == itemPoint.getX() && y == itemPoint.getY();
        }

        class Point {
            int x;
            int y;
            int count;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
                count = 0;
            }

            public Point(int x, int y, int count) {
                this.x = x;
                this.y = y;
                this.count = count;
            }

            public int getX() {
                return x;
            }

            public int getY() {
                return y;
            }

            public int getCount() {
                return count;
            }
        }
    }