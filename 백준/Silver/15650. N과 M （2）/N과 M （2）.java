

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;
    private static int[] arr = new int[10];
    private static boolean[] isUsed = new boolean[10];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        func(0);
    }

    private static void func(int count) {

        if(count == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        int start = 1;
        if(count != 0) start = arr[count-1] + 1;
        for(int i = start; i<= n; i++) {
            if(!isUsed[i]) {
                arr[count] = i;
                isUsed[i] = true;
                func(count+1);
                isUsed[i] = false;
            }
        }
    }
}
