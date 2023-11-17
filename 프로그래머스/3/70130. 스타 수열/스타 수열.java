import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = -1;
        
        int aLen = a.length;
        Map<Integer, Integer> aMap = new HashMap<>();
        
        for(int i = 0; i < aLen; i++) {
            
            aMap.put(a[i], aMap.getOrDefault(a[i], 0)+1);
        }
        
        
        for(Integer key : aMap.keySet()) {
            if(aMap.get(key) <= answer) continue;
            int count = 0;
            
            for(int i = 0; i < a.length-1; i++) {
                
                if(a[i] != key && a[i+1] != key) continue;
                if(a[i] == a[i+1]) continue;
                count++;
                i++;
            }
            
            answer = Math.max(answer, count);
        }
        
        return answer*2;
    }
}