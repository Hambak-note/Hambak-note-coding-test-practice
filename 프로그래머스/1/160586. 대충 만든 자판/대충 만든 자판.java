import java.util.*;


class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        
        int[] answer = new int[targets.length];
        
        for(int i = 0; i < targets.length; i++) {
            
            String target = targets[i];
            int sum = 0;
            for(int j = 0; j < target.length(); j++) {
                
                int min = Integer.MAX_VALUE;
                char cur = target.charAt(j); 
                
                for(String key : keymap) {
                    int temp = key.indexOf(cur);
                    if(temp < min && temp != -1) min = temp;
                }
                
                if(min == Integer.MAX_VALUE){
                    sum = -1;
                    break;
                } 
                
                sum += (min+1);
            }
            
            answer[i] = sum;
        }
            
        return answer;
    }
}