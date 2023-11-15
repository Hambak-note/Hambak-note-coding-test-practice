import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        int buyLength = Integer.MAX_VALUE;
        int kindOfGem = new HashSet<>(Arrays.asList(gems)).size();
        Map<String, Integer> gemCountMap = new HashMap<>();
        
        System.out.println(kindOfGem);
        
        int start = 0;
        for(int end = 0; end < gems.length; end++) {
            
            gemCountMap.put(gems[end], gemCountMap.getOrDefault(gems[end], 0) + 1);
            
            while(gemCountMap.get(gems[start]) > 1) {
                
                gemCountMap.put(gems[start], gemCountMap.get(gems[start]) -1 );
                start++;
            }
            
            if(gemCountMap.size() == kindOfGem && buyLength > (end - start)) {
                
                buyLength = end-start;
                answer[0] = start + 1;
                answer[1] = end+1;
            }
            
            
        }
        
        
        return answer;
    }
}