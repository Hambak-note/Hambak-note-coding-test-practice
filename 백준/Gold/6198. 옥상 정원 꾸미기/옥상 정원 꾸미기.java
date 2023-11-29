
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    private static int n; //빌딩의 개수
    private static int h; //빌딩의 높이
    private static long result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        while(n-- > 0) {

            h = Integer.parseInt(br.readLine());

            while(!stack.isEmpty() && stack.peek() <= h) {
                stack.pop();
            }
            result += stack.size();
            stack.push(h);
        }

        System.out.println(result);
    }
}
