import java.util.*;

class Solution {

        private final int[] DX = {0, 0, 1, -1};
        private final int[] DY = {1, -1, 0, 0};

        private final char SEA = 'X';
        private boolean[][] visit;
        private char[][] charMaps;

        private List<Integer> answerList = new ArrayList<>();


        public int[] solution(String[] maps) {

            initVisitAndCharMaps(maps);
            for(int i = 0; i < maps.length; i++) {
                for(int j = 0; j < maps[i].length(); j++) {
                    if(isPossibleMove(i, j)) {
                        visit[i][j] = true;
                        answerList.add(dfs(new Point(i, j)));
                    }
                }
            }

            if(answerList.isEmpty()) return new int[]{-1};
            
            Collections.sort(answerList);
            return answerList.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
        }

        private void initVisitAndCharMaps(String[] maps) {

            visit = new boolean[maps.length][maps[0].length()];
            charMaps = new char[maps.length][maps[0].length()];

            for(int i = 0; i < maps.length; i++) {
                String map = maps[i];
                for(int j = 0; j < map.length(); j++) {

                    charMaps[i][j] = map.charAt(j);
                }
            }
        }

        private int dfs(Point point) {

            int sum = 0;

            Queue<Point> queue = new LinkedList<>();
            queue.add(point);
            while(!queue.isEmpty()) {
                Point curPoint = queue.poll();
                int curX = curPoint.getX();
                int curY = curPoint.getY();
                sum += charMaps[curX][curY] - '0';

                for(int i = 0; i < 4; i++) {

                    int nextX = curX + DX[i];
                    int nextY = curY + DY[i];

                    if(isPossibleMove(nextX, nextY)) {
                        queue.add(new Point(nextX, nextY));
                        visit[nextX][nextY] = true;
                    }

                }

            }

            return sum;
        }

        private boolean isPossibleMove(int x, int y) {
            if(x < 0 || y < 0 || x >= charMaps.length || y >= charMaps[0].length) return false;
            if(visit[x][y] || charMaps[x][y] == SEA) return false;
            return true;
        }

        class Point {
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
    }