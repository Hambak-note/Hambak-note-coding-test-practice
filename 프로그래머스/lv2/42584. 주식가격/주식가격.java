import java.util.Stack;

class Solution {
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];

            Stack<Integer> secondStack = new Stack<>();

            secondStack.push(0);
            for(int i=1; i < prices.length; i++){

                while(!secondStack.isEmpty() && prices[i] < prices[secondStack.peek()]){
                    int idx = secondStack.pop();
                    answer[idx] = i - idx;
                }
                secondStack.push(i);
            }

            while(!secondStack.isEmpty()){
                int idx = secondStack.pop();
                answer[idx] = prices.length-idx-1;
            }

            return answer;
        }
    }