import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] map = new int[101];

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x] = y;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            map[u] = v;
        }

        int[] roll = new int[101];
        Arrays.fill(roll, Integer.MAX_VALUE);
        roll[1] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});
        while (!queue.isEmpty()) {

            int[] cur = queue.poll();
            int cPos = cur[0];
            int cRoll = cur[1];

            for(int i = 1; i <= 6; i++) {

                int nPos = cPos + i;
                int nRoll = cRoll + 1;
                if(nPos > 100) break;

                if(roll[nPos] <= nRoll) continue;
                if(map[nPos] != 0) {
                    roll[nPos] = nRoll;
                    roll[map[nPos]] = nRoll;
                    queue.add(new int[]{map[nPos], nRoll});
                    continue;
                }

                queue.add(new int[]{nPos, nRoll});
                roll[nPos] = nRoll;
            }
        }

        System.out.println(roll[100]);

    }
}
