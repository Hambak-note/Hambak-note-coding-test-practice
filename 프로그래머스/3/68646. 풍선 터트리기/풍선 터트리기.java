import java.util.*;

class Solution {
    public int solution(int[] a) {
        
        
        if(a.length == 1) return 1;
        
        int answer = 2; //가장 좌측, 우측 원소는 항상 가능하므로 2가지 경우는 확보
        
        int[] leftMins = new int[a.length];
        int[] rightMins = new int[a.length];
        Arrays.fill(leftMins, Integer.MAX_VALUE);
        Arrays.fill(rightMins, Integer.MAX_VALUE);
        
        
        //왼쪽 최소값 저장
        int leftMin = a[0];
        for(int i = 1; i < a.length -1; i++) {
            if(leftMin > a[i]) leftMin = a[i];
            leftMins[i] = leftMin;
        }
        
        //오른쪽 최소값 저장
        int rightMin = a[a.length - 1];
        for(int i = a.length-2; i > 0; i--) {
            if(rightMin > a[i]) rightMin = a[i];
            rightMins[i] = rightMin;
        }
        
        for(int i = 1; i <= a.length - 2; i++) {
            if(a[i] > leftMins[i] && a[i] > rightMins[i]) continue;
            answer++;
        }
        
        
        return answer;
    }
}