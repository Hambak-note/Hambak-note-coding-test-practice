

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int sizeOfBoard;
    private static int[][] board;

    private static int maxBlock = Integer.MIN_VALUE;
    private static final int UP = 0;
    private static final int DOWN = 1;
    private static final int LEFT = 2;
    private static final int RIGHT = 3;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sizeOfBoard = Integer.parseInt(br.readLine());

        board = new int[sizeOfBoard][sizeOfBoard];
        for(int i = 0; i < sizeOfBoard; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < sizeOfBoard; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int dir = 0; dir < 4; dir++) {
            moveBoard(board, dir, 0);
        }
        System.out.println(maxBlock);

    }

    private static void moveBoard(int[][] board, int direction, int moveCnt) {

        if(moveCnt == 5) {
            findMaxBlock(board);
            return;
        }

        int[][] tempBoard = new int[sizeOfBoard][sizeOfBoard];

        if(direction == UP) {

            for(int y = 0; y < sizeOfBoard; y++) {

                Queue<Integer> queue = new LinkedList<>();
                for(int x = 0; x < sizeOfBoard; x++) {
                    int cur = board[x][y];
                    if(cur == 0) continue;
                    queue.add(cur);
                }

                int xIdx = 0;
                while(queue.size() > 1) {
                    int cur = queue.poll();
                    int next = queue.peek();

                    if(cur == next) {
                        tempBoard[xIdx][y] = cur+next;
                        xIdx++;
                        queue.poll();
                        continue;
                    }

                    tempBoard[xIdx][y] = cur;
                    xIdx++;
                }

                if(queue.size() == 1) tempBoard[xIdx][y] = queue.poll();
            }
        }

        if(direction == DOWN) {
            for(int y = 0; y < sizeOfBoard; y++) {

                Stack<Integer> stack = new Stack<>();
                for(int x = 0; x < sizeOfBoard; x++) {
                    int cur = board[x][y];
                    if(cur == 0) continue;
                    stack.add(cur);
                }

                int xIdx = sizeOfBoard -1;
                while(stack.size() > 1) {
                    int cur = stack.pop();
                    int next = stack.peek();

                    if(cur == next) {
                        tempBoard[xIdx][y] = cur+next;
                        xIdx--;
                        stack.pop();
                        continue;
                    }

                    tempBoard[xIdx][y] = cur;
                    xIdx--;
                }

                if(stack.size() == 1) tempBoard[xIdx][y] = stack.pop();
            }

        }
        if(direction == LEFT) {
            for(int x = 0; x < sizeOfBoard; x++) {

                Queue<Integer> queue = new LinkedList<>();
                for(int y = 0; y < sizeOfBoard; y++) {
                    int cur = board[x][y];
                    if(cur == 0) continue;
                    queue.add(cur);
                }

                int yIdx = 0;
                while(queue.size() > 1) {
                    int cur = queue.poll();
                    int next = queue.peek();

                    if(cur == next) {
                        tempBoard[x][yIdx] = cur+next;
                        yIdx++;
                        queue.poll();
                        continue;
                    }

                    tempBoard[x][yIdx] = cur;
                    yIdx++;
                }

                if(queue.size() == 1) tempBoard[x][yIdx] = queue.poll();
            }

        }
        if(direction == RIGHT) {
            for(int x = 0; x < sizeOfBoard; x++) {

                Stack<Integer> stack = new Stack<>();
                for(int y = 0; y < sizeOfBoard; y++) {
                    int cur = board[x][y];
                    if(cur == 0) continue;
                    stack.add(cur);
                }

                int yIdx = sizeOfBoard -1;
                while(stack.size() > 1) {
                    int cur = stack.pop();
                    int next = stack.peek();

                    if(cur == next) {
                        tempBoard[x][yIdx] = cur+next;
                        yIdx--;
                        stack.pop();
                        continue;
                    }

                    tempBoard[x][yIdx] = cur;
                    yIdx--;
                }

                if(stack.size() == 1) tempBoard[x][yIdx] = stack.pop();
            }
        }

        moveBoard(tempBoard, UP, moveCnt+1);
        moveBoard(tempBoard, DOWN, moveCnt+1);
        moveBoard(tempBoard, LEFT, moveCnt+1);
        moveBoard(tempBoard, RIGHT, moveCnt+1);

    }

    private static void findMaxBlock(int[][] board) {

        for(int i = 0; i < sizeOfBoard; i++) {
            for(int j = 0; j < sizeOfBoard; j++) {

                int cur = board[i][j];
                if(cur > maxBlock) maxBlock = cur;
            }
        }
    }


}
