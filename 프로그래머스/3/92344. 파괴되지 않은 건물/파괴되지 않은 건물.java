class Solution {
    
    private static final int ATTACK = 1;
    private static final int CURE = 2;
    private int boardRow;
    private int boardCol;
    
    public int solution(int[][] board, int[][] skill) {
        
        boardRow = board.length;
        boardCol = board[0].length;
        
        int[][] sumArr = initSumArr(skill);
        calculateSumArr(sumArr);
        
        return calculateAliveBuilding(board, sumArr);
    }
    
    private int calculateAliveBuilding(int[][] board, int[][]sumArr) {
         
        
        int answer = 0;
        
        for(int i = 0; i < boardRow; i++) {
            for(int j = 0; j < boardCol; j++) {
              if(board[i][j] + sumArr[i][j] > 0) answer++;
            }
        }
        return answer;
    }
    
    private void calculateSumArr(int[][] sumArr) {
        
        //가로 누적합 계산
        for(int i = 0; i < boardRow+1; i++) {
            int sum = 0;
            for(int j = 0; j < boardCol+1; j++) {
                
                sum += sumArr[i][j];
                sumArr[i][j] = sum;
            }
        }
        
        //세로 누적합 계산
        for(int i = 0; i < boardCol; i++) {
            int sum = 0; 
            for(int j = 0; j < boardRow; j++) {
                sum += sumArr[j][i];
                sumArr[j][i] = sum;
            }
        }
    }
    
    private int[][] initSumArr(int[][] skill) {
        
        int[][] sumArr = new int[boardRow+1][boardCol+1];
        
        for(int i = 0; i < skill.length; i++) {
            
            int r1, c1, r2, c2;
            int sum = skill[i][5];
            
            r1 = skill[i][1];
            c1 = skill[i][2];
            r2 = skill[i][3];
            c2 = skill[i][4];
            
            if(skill[i][0] == ATTACK) sum = -sum;
            
            sumArr[r1][c1] += sum;
            sumArr[r1][c2+1] += -sum;
            sumArr[r2+1][c1] += -sum;
            sumArr[r2+1][c2+1] += sum;
        }
        
        return sumArr;
    }
}