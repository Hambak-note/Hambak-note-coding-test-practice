import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int N, K;
    static char[] board, temp;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());
        
        String line = input.readLine();
        board = new char[N];
        temp = new char[N];
        for(int i = 0; i < N; i++) {
            board[i] = line.charAt(i);
        }

        if(N == 1) {
            board[0] = 'G';
        } else {
            for(int k = 0; k < K; k++) {
                processGame();
                board = temp.clone();
            }
        }

        printResult();
    }

    private static void processGame() {
        for(int i = 0; i < N; i++) {
            char prev = board[(i - 1 + N) % N];
            char curr = board[i];
            char next = board[(i + 1) % N];

            if((curr == prev && curr == next) || 
               (curr != prev && curr != next && prev != next)) {
                temp[i] = 'B';
            } else {
                processColors(prev, curr, next, i);
            }
        }
    }

    private static void processColors(char color1, char color2, char color3, int pos) {
        int[] count = new int[3]; 
        
        countColor(color1, count);
        countColor(color2, count);
        countColor(color3, count);

        if((count[0] == 2 && count[1] == 1) || 
           (count[1] == 2 && count[2] == 1) || 
           (count[2] == 2 && count[0] == 1)) {
            temp[pos] = 'R';
        } else {
            temp[pos] = 'G';
        }
    }

    private static void countColor(char color, int[] count) {
        if(color == 'R') count[0]++;
        else if(color == 'G') count[1]++;
        else count[2]++;
    }

    private static void printResult() {
        int[] count = new int[3];
        for(int i = 0; i < N; i++) {
            countColor(board[i], count);
        }
        System.out.println(count[0] + " " + count[1] + " " + count[2]);
    }
}