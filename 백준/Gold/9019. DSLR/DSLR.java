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
        int tc = Integer.parseInt(br.readLine());

        while(tc-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[10000];
            String[] command = new String[10000];

            queue.add(a);
            visited[a] = true;
            Arrays.fill(command, "");

            while(!queue.isEmpty() && !visited[b]) {

                int cur = queue.poll();

                int d = (2 * cur) % 10000;
                int s = cur == 0 ? 9999 : cur - 1;
                int l = (cur % 1000) * 10 + cur / 1000;
                int r = (cur % 10) * 1000 + cur / 10;

                if (!visited[d]) {
                    queue.add(d);
                    visited[d] = true;
                    command[d] = command[cur] + "D";
                }
                
                if(!visited[s]) {
                    queue.add(s);
                    visited[s] = true;
                    command[s] = command[cur] + "S";
                }

                if(!visited[l]) {
                    queue.add(l);
                    visited[l] = true;
                    command[l] = command[cur] + "L";
                }

                if(!visited[r]) {
                    queue.add(r);
                    visited[r] = true;
                    command[r] = command[cur] + "R";
                }
            }

            System.out.println(command[b]);
        }

    }
}
