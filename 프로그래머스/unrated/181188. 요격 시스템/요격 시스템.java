import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        
        int answer = 1;
        
        /* s기준 오름차순 e기준 내림차순 정렬 */
        Arrays.sort(targets, (a, b) -> {
            if(a[1] == b[1]) {
                return a[0] - b[0];
            } 
            
            return a[1] - b[1];
            
        });
        
        /* 시작점은 엔드포인트(E)를 저장하는 변수 */
        int currentEnd = targets[0][1];
        
        
        for(int[] target : targets) {
            
            if(target[0] >= currentEnd) {
                currentEnd = target[1];
                answer++;
            }
        }
        
        
        return answer;
    }
}