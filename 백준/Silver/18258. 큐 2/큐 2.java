

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        int backValue = 0;
        while (n-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            if (command.equals("push")) {
                int value = Integer.parseInt(st.nextToken());
                q.add(value);
                backValue = value;
                continue;
            }

            if(command.equals("size")) {
                sb.append(q.size()+"\n");
                continue;
            }

            if(command.equals("empty")) {

                if(q.isEmpty()) sb.append("1\n");
                else sb.append("0\n");
                continue;
            }

            if(q.isEmpty()) sb.append("-1\n");
            else{

                if(command.equals("pop")) {
                    sb.append(q.poll()+"\n");
                    continue;
                }

                if(command.equals("front")) {
                    sb.append(q.peek()+"\n");
                    continue;
                }

                sb.append(backValue+"\n");
            }
        }

        System.out.println(sb);
    }



}
