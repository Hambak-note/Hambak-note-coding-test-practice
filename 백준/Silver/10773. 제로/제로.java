import java.util.*;
import java.io.*;

public class Main {

    private static int k;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        k = Integer.parseInt(br.readLine());

        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < k; i++) {

            int cur = Integer.parseInt(br.readLine());

            if(cur == 0) s.pop();
            else s.push(cur);
        }

        int ans = 0;
        while(!s.isEmpty()) {
            ans += s.pop();
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
