import java.util.Arrays;
import java.util.Stack;

class Solution {

        private int[] backBigNum;
        private Stack<Integer> stack;

        public int[] solution(int[] numbers) {

            backBigNum = new int[numbers.length];
            Arrays.fill(backBigNum, -1);

            stack = new Stack<>();


            for(int i = numbers.length-1; i >= 0; i--) {

                while(!stack.isEmpty() && numbers[i] >= stack.peek()) stack.pop();

                if(!stack.isEmpty()) backBigNum[i] = stack.peek();

                stack.push(numbers[i]);
            }

            return backBigNum;
        }
    }