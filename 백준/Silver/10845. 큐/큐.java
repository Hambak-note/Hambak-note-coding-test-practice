import java.io.*;
import java.util.*;

public class Main {

    private static int n; //명령의 개수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        Deque<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            if(command.equals("push")) {

                q.add(Integer.parseInt(st.nextToken()));
                continue;
            }

            if(command.equals("pop")) {

                if(q.isEmpty()) bw.write(-1 + "\n");
                else bw.write(q.poll() + "\n");
                continue;
            }

            if(command.equals("size")) {

                bw.write(q.size() + "\n");
                continue;
            }

            if(command.equals("empty")) {

                if(q.isEmpty()) bw.write(1 + "\n");
                else bw.write(0 + "\n");
                continue;
            }

            if(command.equals("front")) {

                if(q.isEmpty()) bw.write(-1 + "\n");
                else bw.write(q.peek() + "\n");
                continue;
            }

            if(command.equals("back")) {

                if(q.isEmpty()) bw.write(-1 + "\n");
                else bw.write(q.peekLast() + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
