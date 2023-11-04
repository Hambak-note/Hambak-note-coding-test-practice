import java.util.*;
import java.util.stream.*;


class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        Map<String, Integer> nameAndYearningMap = new HashMap<>();
        
        for(int i = 0; i < name.length; i++) {
            
            nameAndYearningMap.put(name[i], yearning[i]);
        }
        
        
        for(int i = 0; i < photo.length; i++) {
            
            int sum = 0;
            for(int j = 0; j < photo[i].length; j++) {
                
                if(nameAndYearningMap.containsKey(photo[i][j])) {
                    sum += nameAndYearningMap.get(photo[i][j]);
                }
            }
            answer[i] = sum;
        }
        
    
      
        return answer;
    }
}