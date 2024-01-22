

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static int[] result;
    private static boolean used[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        used = new boolean[N+1];
        result = new int[M];


        search(0);

    }

    private static void search(int count) {

        if(count == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= N; i++) {

            if(!used[i]) {
                result[count] = i;
                used[i] = true;
                search(count+1);
                used[i] = false;
            }
        }

    }


}
