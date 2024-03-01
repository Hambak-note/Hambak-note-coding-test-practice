import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    static private int sizeOfVideo;
    static private int[][] video;
    static private StringBuilder sb;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sizeOfVideo = Integer.parseInt(br.readLine());

        video = new int[sizeOfVideo][sizeOfVideo];
        sb = new StringBuilder();

        for(int i = 0; i < sizeOfVideo; i++) {

            String input = br.readLine();

            for(int j = 0; j < input.length(); j++) {

                video[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }

        makeQuadTree(0, 0, sizeOfVideo);
        System.out.println(sb);
    }

    private static void makeQuadTree(int x, int y, int lengthOfOneSide) {

        if(isSameColor(x, y, lengthOfOneSide)) {
            sb.append(video[x][y]);
            return;
        }

        sb.append("(");
        int nextLengthOfOneSide = lengthOfOneSide / 2;
        makeQuadTree(x, y, nextLengthOfOneSide);
        makeQuadTree(x, y + nextLengthOfOneSide, nextLengthOfOneSide);
        makeQuadTree(x + nextLengthOfOneSide, y, nextLengthOfOneSide);
        makeQuadTree(x + nextLengthOfOneSide, y + nextLengthOfOneSide, nextLengthOfOneSide);
        sb.append(")");
    }

    private static boolean isSameColor(int x, int y, int lengthOfOneSide) {

        for(int i = x; i < x+lengthOfOneSide; i++) {

            for(int j = y; j < y+lengthOfOneSide; j++) {
                if(video[x][y] != video[i][j]) return false;
            }
        }

        return true;
    }
}
