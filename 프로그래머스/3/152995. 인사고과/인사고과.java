import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int rank = 1;
        int[] wanho = scores[0];
        int wanhoTotalScore = wanho[0] + wanho[1];
        
        Arrays.sort(scores, new Comparator<int[]>(){
           @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] < o2[0])
                    return 1;
                else if(o1[0] == o2[0]) {
                    if(o1[1] > o2[1])
                        return 1;
                    else
                        return -1;
                }
                else return -1;
            }
        });
        
        int dongryoScore = 0;
        for(int[] score : scores) {
            
            if(score[1] < dongryoScore) {
                if(wanho[0] <= score[0] && wanho[1] <= score[1]) return -1;
            }
            else {
                dongryoScore = score[1];
                if(wanhoTotalScore < score[0] + score[1]) rank++;
            }
        }
        
        return rank;
    }
}