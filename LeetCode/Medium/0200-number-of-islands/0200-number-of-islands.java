
import java.util.LinkedList;

class Solution {

        private static int[] dx = {1, -1, 0, 0};
        private static int[] dy = {0, 0, 1, -1};

        private static int n, m;
        public int numIslands(char[][] grid) {

            n = grid.length;
            m = grid[0].length;

            boolean[][] visited = new boolean[n][m];
            int count = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    if(grid[i][j] == '1' && !visited[i][j]) {
                        count++;
                        bfs(i, j, visited, grid);
                    }
                }
            }

            return count;
        }

         private void bfs(int x, int y, boolean[][] visited, char[][] grid) {
            LinkedList<int[]> queue = new LinkedList<>();

            visited[x][y] = true;
            queue.add(new int[]{x, y});

            while(!queue.isEmpty()) {

                int[] cur = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];

                    if (isOut(nx, ny) || visited[nx][ny] || grid[nx][ny] == '0') continue;

                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

         private boolean isOut(int x, int y) {
            if(x < 0 || x >= n || y < 0 || y >= m) return true;
            return false;
        }
    }