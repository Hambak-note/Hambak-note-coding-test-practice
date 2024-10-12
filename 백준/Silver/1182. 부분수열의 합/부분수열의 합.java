
import java.io.*;
import java.util.*;

public class Main {

    private static int n, s;
    private static int cnt;
    private static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        cnt = 0;
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) arr[i] =  Integer.parseInt(st.nextToken());

        func(0, 0);
        if(s == 0) cnt--;
        
        System.out.println(cnt);
    }

    private static void func(int cur, int tot) {
        if(cur == n) {
            if(tot == s) cnt++;
            return;
        }

        func(cur+1, tot);
        func(cur + 1, tot + arr[cur]);
    }
}
