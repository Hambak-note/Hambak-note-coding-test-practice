

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int testCase;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());

        while(testCase-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            long cur = 1;
            for(int i = 0; i < b; i++) {
                cur = cur * a;
                cur = cur % 10;
            }

            if(cur == 0) {
                System.out.println(10);
                continue;
            }
            System.out.println(cur);
        }
    }
}
