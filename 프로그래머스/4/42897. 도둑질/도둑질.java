class Solution {
    public int solution(int[] money) {
        
        int len = money.length;
        int[] doFirst = new int[len];
        int[] doSecond = new int[len];
        
        for(int i = 0; i < len; i++) {           
            doFirst[i] = money[i];
            doSecond[i] = money[i];
        }
        
        doFirst[1] = -1;
        doSecond[0] = -1;
        doFirst[2] += doFirst[0];
        
        for(int i = 3; i < len; i++) {
            
            doFirst[i] += Math.max(doFirst[i-2], doFirst[i-3]);
            doSecond[i] += Math.max(doSecond[i-2], doSecond[i-3]);
        }
        
        int doFirstMax = Math.max(doFirst[len-2], doFirst[len-3]);
        int doSecondMax = Math.max(doSecond[len-1], doSecond[len-2]);
        
        return Math.max(doFirstMax, doSecondMax);
    }
}