import java.util.*;


class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        Deque<String> deque = new LinkedList<>();
        
    
        deque.add("0");
        for(int i = food.length-1; i >= 0; i--) {
            
            int num = food[i]/2;
            
            for(int j = 0; j < num; j++) {
                
                deque.addFirst(String.valueOf(i));
                deque.addLast(String.valueOf(i));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(String str : deque) {
            sb.append(str);
        }
        
        answer = sb.toString();
        
        
        
        
        return answer;
    }
}