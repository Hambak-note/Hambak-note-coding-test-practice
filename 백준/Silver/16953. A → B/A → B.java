
import java.io.*;
import java.util.*;

public class Main {

    private static int a, b;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int cnt = 1;

        while(a != b) {

            if(a > b) {
                cnt = -1;
                break;
            }

            if((b % 10) == 1) {
                b = b / 10;
                cnt++;
                continue;
            }

            if((b % 2) == 0) {
                b = b / 2;
                cnt++;
                continue;
            }



            cnt = -1;
            break;
        }

        System.out.println(cnt);
    }
}
