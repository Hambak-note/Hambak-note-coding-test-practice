import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        

        int firstIdx = 0;
        int secondIdx = 0;
        for(String target : goal) {
            
            if(firstIdx < cards1.length) {
                if(cards1[firstIdx].equals(target)) {
                    firstIdx++;
                    continue;
                }
            }
            
            if(secondIdx < cards2.length) {
                if(cards2[secondIdx].equals(target)) {
                    secondIdx++;
                    continue;
                }
            }
            
            return "No";
            
        }
       
        return "Yes";
    }
}