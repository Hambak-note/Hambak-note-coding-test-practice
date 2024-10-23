import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n, l;
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        Deque<int[]> dq = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {

            int cur = Integer.parseInt(st.nextToken());
            while(!dq.isEmpty() && dq.peekLast()[0] > cur) dq.pollLast();

            dq.offer(new int[] {cur, i});
            if(dq.peek()[1] < i - (l-1)) dq.poll();
            sb.append(dq.peek()[0] + " ");
        }

        System.out.println(sb);
    }
}
