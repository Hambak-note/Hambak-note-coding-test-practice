import java.io.*;
import java.util.*;

public class Main {

    private static int n; //명령의 수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = "";
            command = st.nextToken();

            if(command.equals("push")) s.push(Integer.parseInt(st.nextToken()));
            else if(command.equals("pop")) {
                if(!s.isEmpty()) bw.write(s.pop() + "\n");
                else bw.write(-1 + "\n");
            }
            else if(command.equals("size")) bw.write(s.size() + "\n");
            else if(command.equals("empty")) {
                if(s.isEmpty()) bw.write(1 + "\n");
                else bw.write(0 + "\n");
            }
            else if(command.equals("top")) {
                if(!s.isEmpty()) bw.write(s.peek() + "\n");
                else bw.write(-1 + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
