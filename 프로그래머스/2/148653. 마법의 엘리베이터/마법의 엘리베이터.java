import java.util.*;


class Solution {
    
    //155, 154
    
    private static final int MUL_NUM = 10;
    private static final int GOAL = 0;
    
    public int solution(int storey) {
        int answer = 0;
        
        int c = 10;
        int curStorey = storey;
        
        while(curStorey != GOAL) {
            
            int middle = c / 2;
            int remain = curStorey % c;
            
            if(remain < middle) {
                curStorey -= remain;
                answer+= (remain / (c/MUL_NUM));
            } else if(remain > middle) {
                curStorey += (c - remain);
                answer += ((c - remain) / (c/MUL_NUM));
            } else {
                
                int temp = (curStorey / c) % 10; 
                 if(temp >= 5) {
                    curStorey += (c - remain);
                    answer += ((c - remain) / (c/MUL_NUM));
                }  else {
                    curStorey -= remain;
                    answer+= (remain / (c/MUL_NUM));
                 }
            }
            
            c = c * MUL_NUM;    
        }
        
        return answer;
    }
}