
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {

    private static final char LEFT = '(';
    private static final char RIGHT = ')';

    private static int T;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            String input = br.readLine();
            boolean isVPS = isVPS(input);
            if(isVPS) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static boolean isVPS(String input) {

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < input.length(); i++) {

            char cur = input.charAt(i);

            if( cur == LEFT) {
                stack.push(cur);
                continue;
            }

            if(stack.isEmpty() && cur == RIGHT) {
                return false;
            }

            if(cur == RIGHT) {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
