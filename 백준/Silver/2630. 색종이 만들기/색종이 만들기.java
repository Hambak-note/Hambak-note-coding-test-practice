import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static private int inputLengthOfOneSide;
    static private int[][] confetti;
    static private int numberOfWhiteConfetti;
    static private int numberOfBlueConfetti;
    static private final int WHITE = 0;
    static private final int BLUE = 1;

    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() { return this.x; }
        public int getY() { return this.y; }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        inputLengthOfOneSide = Integer.parseInt(br.readLine());
        numberOfBlueConfetti = 0;
        numberOfWhiteConfetti = 0;

        confetti = new int[inputLengthOfOneSide][inputLengthOfOneSide];

        StringTokenizer st;
        for(int i = 0; i < inputLengthOfOneSide; i++) {

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < inputLengthOfOneSide; j++) {
                confetti[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        countConfettiByColor(new Point(0, 0), inputLengthOfOneSide);
        System.out.println(numberOfWhiteConfetti);
        System.out.println(numberOfBlueConfetti);


    }

    private static void countConfettiByColor(Point startPoint, int lengthOfOneSide) {

        if(isSameColor(startPoint, lengthOfOneSide)) {
            if(confetti[startPoint.getX()][startPoint.getY()] == BLUE) numberOfBlueConfetti++;
            else numberOfWhiteConfetti++;
            return;
        }

        int nextLengthOfOneSide = lengthOfOneSide / 2;
        countConfettiByColor(startPoint, nextLengthOfOneSide);
        countConfettiByColor(new Point(startPoint.getX(), startPoint.getY() + nextLengthOfOneSide), nextLengthOfOneSide);
        countConfettiByColor(new Point(startPoint.getX() + nextLengthOfOneSide, startPoint.getY()), nextLengthOfOneSide);
        countConfettiByColor(new Point(startPoint.getX() + nextLengthOfOneSide, startPoint.getY()+nextLengthOfOneSide), nextLengthOfOneSide);
    }


    private static boolean isSameColor(Point startPoint, int lengthOfOneSide) {

        if(lengthOfOneSide==1) return true;

        int x = startPoint.getX();
        int y = startPoint.getY();
        int color = confetti[x][y];

        for(int i = x; i < x+lengthOfOneSide; i++) {

            for(int j = y; j < y+lengthOfOneSide; j++) {
                if(color != confetti[i][j]) return false;
            }
        }
        return true;
    }
}
