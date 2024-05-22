import java.util.*;


class Solution {
    
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        int[] alpa = new int[26];
        Arrays.fill(alpa, -1);
        
        for(int i = 0 ; i < s.length(); i++) {
            
            int cur = s.charAt(i) - 'a';
            if(alpa[cur] == -1) {
                answer[i] = -1;
                alpa[cur] = i;
                continue;
            }
            
            answer[i] = i - alpa[cur];
            alpa[cur] = i;   
        }
        
        
        return answer;
    }
}