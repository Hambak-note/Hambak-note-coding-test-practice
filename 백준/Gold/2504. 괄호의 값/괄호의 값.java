

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    private static final char LEFT_SMALL = '(';
    private static final char LEFT_BIG = '[';
    private static final char RIGHT_SMALL= ')';
    private static final char RIGHT_BIG = ']';

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(calculate(input));
    }

    private static int calculate(String input){

        int result = 0;
        int curNum = 1;
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < input.length(); i++) {

            char cur = input.charAt(i);

            if(cur == LEFT_SMALL) {
                curNum *= 2;
                stack.push(LEFT_SMALL);
            }
            else if(cur == LEFT_BIG) {
                curNum *= 3;
                stack.push(LEFT_BIG);
            }
            else if(cur == RIGHT_SMALL) {
                if(stack.isEmpty() || stack.peek() != LEFT_SMALL) {
                    return 0;
                }
                if(input.charAt(i-1) == LEFT_SMALL) result += curNum;
                stack.pop();
                curNum /= 2;
            }
            else {
                if(stack.isEmpty() || stack.peek() != LEFT_BIG) {
                    return 0;
                }
                if(input.charAt(i-1) == LEFT_BIG) result += curNum;
                stack.pop();
                curNum /= 3;
            }
        }
        if(stack.isEmpty()) return result;
        else return 0;
    }
}
