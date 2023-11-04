import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        
        int lux = Integer.MAX_VALUE;
        int luy = Integer.MAX_VALUE;
        int rdx = Integer.MIN_VALUE;
        int rdy = Integer.MIN_VALUE;
        
        for(int i = 0; i < wallpaper.length; i++) {
            
            for(int j = 0; j < wallpaper[i].length(); j++) {
                
                char value = wallpaper[i].charAt(j);
                
                if(value == '#') {
                    if(lux > i) lux = i;
                    if(luy > j) luy = j;
                    if(rdx < i) rdx = i;
                    if(rdy < j) rdy = j;
                }   
            } 
        }
        
        int dragDistance = Math.abs(rdx - lux) + Math.abs(rdy - luy);
        
        
        return new int[]{lux, luy, rdx+1, rdy+1};
    }
}