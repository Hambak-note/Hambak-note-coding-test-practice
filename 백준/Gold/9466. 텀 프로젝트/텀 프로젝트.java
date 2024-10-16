import java.io.*;
import java.util.*;

public class Main {

    private static int tc;
    private static int n;
    private static int[] numbers;
    private static int[] state;

    private static final int NOT_VISIT = 0;
    private static final int CYCLE_IN = -1;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        tc = Integer.parseInt(br.readLine());

        for(int i = 0; i < tc; i++) {

            n = Integer.parseInt(br.readLine());
            numbers = new int[n+1];
            state = new int[n+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) numbers[j] = Integer.parseInt(st.nextToken());


            for(int j = 1; j <= n; j++) {
                if(state[j] == NOT_VISIT) run(j);
            }

            int answer = 0;
            for(int j = 1; j <= n; j++) if(state[j] != CYCLE_IN) answer++;

            System.out.println(answer);
        }
    }

    private static void run(int x) {

        int cur = x;
        while(true) {

            state[cur] = x;
            cur = numbers[cur];

            if(state[cur] == x) {
                while(state[cur] != CYCLE_IN) {
                    state[cur] = CYCLE_IN;
                    cur = numbers[cur];
                }

                return;
            }
            else if(state[cur] != 0) return;

        }
    }

}
