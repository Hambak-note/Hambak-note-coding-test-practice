import java.util.*;

class Solution {
    
    private static int COUNT_NUMBER_ONE = 0;
    private static int COUNT_NUMBER_ZERO = 0;
    
    public int[] solution(int[][] arr) {
        
        
        calculateQuadCompressionResults(arr);
        int[] answer = {COUNT_NUMBER_ZERO, COUNT_NUMBER_ONE};
        
        return answer;
    }
    
    
    private void calculateQuadCompressionResults(int[][] targetArr) {
        
        /* 모든 값이 1일 때 */
        if( checkAllValuesNumberOne(targetArr) ) {
            COUNT_NUMBER_ONE++;
            return;
        }
        
        /* 모든 값이 0일 때*/
        if( checkAllValuesNumberZero(targetArr) ) {
            COUNT_NUMBER_ZERO++;
            return;
        }
        
        List<int[][]> diviedArrs = divideArr(targetArr);
        
        for(int i = 0; i < 4; i++) {
            calculateQuadCompressionResults(diviedArrs.get(i));
        }
    }
    
    
    private List<int[][]> divideArr(int[][] targetArr) {
        
        List<int[][]> diviedArrs = new ArrayList<>();
        
        int rows = targetArr.length;
        int cols = targetArr[0].length;
        
        int subArrSize = rows / 2;
        
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                
                int[][] subArr = new int[subArrSize][subArrSize];
                
                for(int x=0; x < subArrSize; x++) {
                    
                    System.arraycopy(
                        targetArr[i * subArrSize + x],
                        j * subArrSize,
                        subArr[x],
                        0,
                        subArrSize
                    );
                }
                
                diviedArrs.add(subArr);
            }
        }
        
        return diviedArrs;
    }
    
    

    
    private boolean checkAllValuesNumberOne(int[][] targetArr) {
        
        return Arrays.stream(targetArr)
            .flatMapToInt(Arrays::stream)
            .allMatch(value -> value == 1);
    }
    
    private boolean checkAllValuesNumberZero(int[][] targetArr) {
        
        return Arrays.stream(targetArr)
            .flatMapToInt(Arrays::stream)
            .allMatch(value -> value == 0);
    }
    
    
    
}