import java.util.Stack;

class Solution {

        private static final int LAST = 0;
        public int[] solution(int[] prices) {

            int[] times = new int[prices.length];
            Stack<Integer> reverseStack = new Stack<>();

            for (int price : prices) {
                reverseStack.push(price);
            }

            times[prices.length-1] = 0;
            reverseStack.pop();
            while(!reverseStack.isEmpty()) {

                int curTime = reverseStack.size()-1;
                int curPrice = reverseStack.pop();

                boolean isBreak = false;
                for (int nextTime = curTime + 1; nextTime < prices.length; nextTime++) {

                    int nextPrice = prices[nextTime];
                    if(curPrice > nextPrice) {
                        times[curTime] = nextTime-curTime;
                        isBreak = true;
                        break;
                    }

                    if(curPrice == nextPrice) {
                        times[curTime] = nextTime - curTime + times[nextTime];
                        isBreak = true;
                        break;
                    }
                }

                if(!isBreak) {
                    times[curTime] = prices.length-curTime-1;
                }
            }

            return times;
        }
    }