import java.io.*;
import java.util.*;

public class Main {

    private static int tc, n, m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        tc = Integer.parseInt(br.readLine());

        while(tc-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            int a, b;
            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
            }
            
            bw.write((n-1) + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();


    }
}
