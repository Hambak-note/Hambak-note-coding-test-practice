/*
* 최대 칸수 k일 때 최대 몇 명까지 징검다리를 건널 수 있는가 ?
*       => m명은 최대 칸수 k 일 때 건널 수 있는가?
* 대상이 되는 m명을 선정하는 방식은 '이분 탐색'
* 건널 수 있는 최소 인원 = 디딤돌에 적힌 숫자 중 가장 작은 수
* 건널 수 있는 최대 인원 = 디딤돌에 적힌 숫자 중 가장 큰 수
*/

import java.util.*;

class Solution {
    public  int solution(int[] stones, int k) {
    
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int stone : stones) {
            min = Math.min(min, stone);
            max = Math.max(max, stone);
        }
        

        
        while(min < max) {
            
            int mid = (min + max + 1) / 2;
            if(canCrossBridge(mid, k, stones)) {
                min = mid;
            } else {
                max = mid-1;
            }
        } 
        
        
        return max;
    }
    
    
    private   boolean canCrossBridge(int mid, int k, int[] stones) {
        
        int impossibleCount = 0;
        for(int i = 0; i < stones.length; i++) {
            
            int currentStone = stones[i] - mid;
            if(currentStone < 0) {
                impossibleCount++;
            } else {
                impossibleCount = 0;
            }
            
            if(impossibleCount == k) {
                return false;
            }
            
        }
        
        return true;   
    }
}