
import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int cur = 1;
        while(n-- > 0) {

            int t = Integer.parseInt(br.readLine());

            while(cur <= t) {
                stack.push(cur++);
                sb.append("+\n");
            }

            if(stack.peek() != t) {
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append("-\n");
        }

        System.out.print(sb);
    
    }
}
