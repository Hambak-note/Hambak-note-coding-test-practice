import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        int paintedPosition = 0;
        for(int i = 0; i < section.length; i++) {
            
            int currentPosition = section[i];
            if(currentPosition > paintedPosition) {
                answer++;
                paintedPosition = (currentPosition + m)-1;
            }
        }
        
        return answer;
    }
}