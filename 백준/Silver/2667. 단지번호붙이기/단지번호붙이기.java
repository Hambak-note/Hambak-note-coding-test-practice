

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int n;
    static int[][] board = new int[27][27];
    static boolean[][] vis = new boolean[27][27];

    static final int[] dx = new int[]{1, 0, -1, 0};
    static final int[] dy = new int[]{0, 1, 0, -1};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String row = br.readLine();
            for(int j = 0; j < row.length(); j++) {
                board[i][j] = Integer.parseInt(String.valueOf(row.charAt(j)));
            }
        }

        int danJi = 0;
        ArrayList<Integer> homeCntList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {

                if(isVisitedAndNoHome(i, j)) continue;

                Queue<int[]> queue = new LinkedList<>();
                vis[i][j] = true;
                queue.add(new int[]{i, j});
                int homeCnt = 1;
                danJi++;
                while(!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    for(int dir = 0; dir < 4; dir++) {
                        int nx = cur[0] + dx[dir];
                        int ny = cur[1] + dy[dir];
                        if(isOutOfBound(nx, ny)) continue;
                        if(isVisitedAndNoHome(nx, ny)) continue;
                        queue.add(new int[]{nx, ny});
                        vis[nx][ny] = true;
                        homeCnt++;
                    }
                }
                homeCntList.add(homeCnt);
            }
        }
        System.out.println(danJi);
        Collections.sort(homeCntList);
        for (Integer homeCnt : homeCntList) {
            System.out.println(homeCnt);
        }
    }

    private static boolean isOutOfBound(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }

    //집이 없는 곳이거나 이미 방문한 곳인지 확인
    private static boolean isVisitedAndNoHome(int x, int y) {
        return board[x][y] == 0 || vis[x][y] == true;
    }
}
