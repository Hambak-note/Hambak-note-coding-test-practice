import java.lang.*;

class Solution {
    public int solution(int sticker[]) {

        int stickerLen = sticker.length;
        
        if(stickerLen == 1) return sticker[0];
        
        int[] dpStartZero = new int[stickerLen];
        int[] dpStartOne = new int[stickerLen];
        
        dpStartZero[0] = sticker[0];
        dpStartZero[1] = sticker[0];
        
        dpStartOne[0] = 0;
        dpStartOne[1] = sticker[1];
        
        for( int i = 2; i < stickerLen; i++) {
            
            dpStartZero[i] = Math.max(dpStartZero[i-2]+sticker[i], dpStartZero[i-1]);
            dpStartOne[i] = Math.max(dpStartOne[i-2]+sticker[i], dpStartOne[i-1]);
        }
        
        return Math.max(dpStartZero[stickerLen-2], dpStartOne[stickerLen-1]);
    }
}