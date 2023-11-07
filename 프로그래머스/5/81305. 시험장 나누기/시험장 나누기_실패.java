
/*
* 시험장에서 오는 트래픽을 k개의 그룹으로 나누어 그룹별 서버로 분산
* 시험장 사이를 연결하는 간선들 중 k-1개를 끊어서 k개의 그룹으로 나눈다.
* 나눌 그룹의 수를 나타내는 정수 k
* 각 시험장의 응시자 수를 나타내는 1차원 정수 배열 num
* 시험장의 연결 상태를 나타내는 2차원 정수 배열 links
* return k개의 그룹으로 나누었을 때, 최소화된 최대 그룹의 인원
  */

//그룹을 끊는 것 => 값이 있는 것을 -1로 만드는 것 (k-1개를 -1로 만드는 것)
//각 그룹별 합 중 가장 큰 값을 찾는다.
// 찾은 값을 이전에 나누었던 값과 비교하여 가장 작은 값을 찾는다.

import java.util.*;

class Solution {
    

    private static List<Integer> groupSumList = new ArrayList<>();
    
    
    public int solution(int k, int[] num, int[][] links) {
        int answer = Integer.MAX_VALUE;
        
        //1. 그룹을 나눈다. dividedGroupNum <- 1입력
        int current = 0;
        int dividedGroupNum = 1;
        divideGroupAndSum(links, current, dividedGroupNum, k, num);
        
        
        for(int i = 0; i < groupSumList.size(); i++) {
            int value = groupSumList.get(i);
            if(answer > value) {
                answer = value;
            }
        }
        
        return answer;
    }
    
    private void divideGroupAndSum(int[][] links, int current, int dividedGroupNum, int k, int[] num) {
        
        if(dividedGroupNum == k) {
            //그룹별 값을 계산하는 함수
            groupSumList.add(calculateGroupSum(links, k, num));
            
            return;
        }
        
        if(current > num.length-1) return;
        
        if(links[current][0] != -1) {
            int temp = links[current][0];
            links[current][0] = -1;
            divideGroupAndSum(links, current, dividedGroupNum+1, k, num);
            links[current][0] = temp;
        }
        
        if(links[current][1] != -1) {
            int temp = links[current][1];
            links[current][1] = -1;
            divideGroupAndSum(links, current, dividedGroupNum+1, k, num);
            links[current][1] = temp;
        }
        
        divideGroupAndSum(links, current+1, dividedGroupNum, k, num);
        
    }
    
    private int calculateGroupSum(int[][] links, int k, int[] num) {
        
        boolean visitedArr[] = new boolean[links.length];
        int maxSum = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < links.length; i++) {
            
            int sum = 0;
            
            if(visitedArr[i] == false) {
                
                queue.add(i);
                while(queue.peek() != null) {
                    
                    
                    int index = queue.poll();
                    sum += num[index];
                    visitedArr[index] = true;
                    
                    int left = links[index][0];
                    int right = links[index][1];
                    
                    if(left != -1) queue.add(left);
                    if(right != -1) queue.add(right);            
                }
                
                if(sum > maxSum) maxSum = sum;
                
            }
        }
        
        
        return maxSum;
    }
}
