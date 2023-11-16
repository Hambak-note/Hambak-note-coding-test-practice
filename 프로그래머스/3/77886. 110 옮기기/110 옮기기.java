import java.util.*;

class Solution {
    
    private static final char ONE = '1';
    private static final char TWO = '1';
    private static final char THREE = '0';
    private static final String FIND_STR = "110";
    
    
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        StringBuilder sb;
        
        for(int i = 0; i < s.length; i++) {
            
            String curStr = s[i];
            Stack<Character> stack = new Stack<>();
            int targetCount = 0;
            
            for(int j = 0; j < curStr.length(); j++) {
                
                char three = curStr.charAt(j);
                
                if(stack.size() > 1) {
                    
                    char two = stack.pop();
                    char one = stack.pop();
                    
                    if(one == ONE && two == TWO && three == THREE) targetCount++;
                    else {
                        stack.push(one);
                        stack.push(two);
                        stack.push(three);
                    }
                } else stack.push(three);
            }
            
            int idx = stack.size();
            boolean isZero = false;
            sb = new StringBuilder();
            
            //0의 마지막 위치 찾기
            while(!stack.isEmpty()) {
                if(!isZero) {
                    if(stack.peek() == '1') idx--;
                    else isZero = true;
                }
                sb.insert(0, stack.pop());
            }
            
            if(targetCount > 0) {
                
                while(targetCount-- > 0) {
                    
                    sb.insert(idx, FIND_STR);
                    idx += 3;
                }
                answer[i] = sb.toString();
            }
            else answer[i] = s[i];
        }

        return answer;
    }
}