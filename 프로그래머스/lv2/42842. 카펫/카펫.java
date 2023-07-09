import java.util.Arrays;
import java.util.Collections;
class Solution {

    private final int MIN_SIZE = 3;

    public Integer[] solution(int brown, int yellow) {
        Integer[] answer = {};

        int vertical = 0;
        int width = 0;
        int numberOfBorders = 0;
        int tileTotal = brown + yellow;

        Loop :
        for(int i = 3; i <= tileTotal/3; i++){
            for(int j = 3; j <= tileTotal/3; j++){
                if(i*j == tileTotal){
                    //모서리 4개 + (행-2)*2 + (열-2)*2
                    numberOfBorders = 4 + (i-2)*2 + (j-2)*2;
                    if(numberOfBorders == brown){
                        answer = new Integer[]{i, j};
                        break Loop;
                    }
                }
            }
        }

        Arrays.sort(answer, Collections.reverseOrder());
        return answer;
    }
}