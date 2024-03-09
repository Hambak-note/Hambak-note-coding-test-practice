import java.util.Stack;

class Solution {
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];


            int len = prices.length;
            Stack<Integer> stack = new Stack<>();
            stack.add(0);
            for(int i = 1; i < len; i++) {

                while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {

                    int j = stack.pop();
                    answer[j] = i - j;
                }

                stack.add(i);
            }
            
            while(!stack.isEmpty()) {
                int j = stack.pop();
                answer[j] = len-1-j;
            }
            return answer;
        }
    }