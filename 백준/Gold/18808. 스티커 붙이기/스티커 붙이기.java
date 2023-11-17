import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int STICKER = 1;
    private static final int BLANK = 0;

    private static int n, m, k;
    private static int r, c;
    private static int[][] note = new int[42][42];
    private static int[][] gridPaper = new int[12][12];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        while(k-- > 0) {

            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            for(int i = 0; i < r; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < c; j++) {
                    gridPaper[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int rot = 0; rot < 4; rot++) {
                boolean isPaste = false;
                for(int x = 0; x <= n-r; x++) {
                    if(isPaste) break;
                    for(int y = 0; y <= m-c; y++) {
                        if(checkPastePossible(x, y)) {
                            isPaste = true;
                            break;
                        }
                    }
                }
                if(isPaste) break;
                rotate();
            }
        }

        System.out.println(calculateResult());
    }

    // note의 (x,y)에 모눈종이의 (0,0)이 올라가게 스티커를 붙일 수 있는지 판단하는 함수. 가능할 경우 note를 갱신한 후 true를 반환.
    private static boolean checkPastePossible(int x, int y) {
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(note[x+i][y+j] == STICKER && gridPaper[i][j] == STICKER)
                    return false;
            }
        }

        for(int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(gridPaper[i][j] == STICKER) note[x+i][y+j] = STICKER;
            }
        }
        return true;
    }

    // girdPaper() 를 90도 회전
    private static void rotate() {
        int[][] tmp = new int[12][12];

        for(int i = 0; i < r; i++)
            for(int j = 0; j < c; j++)
                tmp[i][j] = gridPaper[i][j];

        for(int i = 0; i < c; i++)
            for(int j = 0; j < r; j++)
                gridPaper[i][j] = tmp[r-1-j][i];

        swap();
    }

    private static void swap() {
        int temp = r;
        r = c;
        c = temp;
    }

    private static int calculateResult(){
        int cnt = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                cnt += note[i][j];
        return cnt;
    }
}
