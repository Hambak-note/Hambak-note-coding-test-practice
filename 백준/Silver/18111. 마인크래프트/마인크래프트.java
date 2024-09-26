import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                int input = Integer.parseInt(st.nextToken());
                map[i][j] = input;
                min = Math.min(input, min);
                max = Math.max(input, max);
            }
        }

        int time = Integer.MAX_VALUE;
        int high = 0;
        for(int curH = min; curH <= max; curH++) {

            int curTime = 0;
            int curBlock = b;

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {

                    int curPoint = map[i][j];
                    int diff = curH - curPoint;
                    if(diff == 0) continue;
                    if(diff > 0) {
                        curTime += diff;
                        curBlock -= diff;
                        continue;
                    }

                    curTime += (diff * -2);
                    curBlock += (-diff);
                }
            }

            if(curBlock < 0) continue;
            if(time == curTime) {
                high = Math.max(high, curH);
                continue;
            }

            if(time > curTime) {
                time = curTime;
                high = curH;
            }
        }

        System.out.println(time + " " + high);

    }
}
