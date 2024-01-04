import java.util.Stack;

class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            Stack<Integer> indexStack = new Stack<>();
            int[] result = new int[temperatures.length];
            
            for (int i = 0; i < temperatures.length; i++) {
                
                while(!indexStack.isEmpty() && temperatures[indexStack.peek()] < temperatures[i]) {
                    
                    result[indexStack.peek()] = i - indexStack.pop();
                }
                
                indexStack.push(i);
            }
            
            return result;
    }
}