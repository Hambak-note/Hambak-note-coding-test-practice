class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        int[][] graph = new int[n+1][n+1];
        for(int[] edge : results) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = -1;
        }
        
        // 1번이 2번을 이겼다. 2번은 5번을 이겼다. (1 > 2, 2 > 5)
        // 1번은 5번을 이긴다. (1 > 5)
        // top
        for(int top = 1; top <= n; top++) {
            // bottom
            for(int bottom = 1; bottom <= n; bottom++) {
                //middle
                for(int middle = 1; middle <= n; middle++) {
                    
                    if(graph[top][middle] == 1 && graph[middle][bottom] == 1) {
                        graph[top][bottom] = 1;
                        graph[bottom][top] = -1;
                    }
                    
                    if(graph[top][middle] == -1 && graph[middle][bottom] == -1) {
                        graph[top][bottom] = -1;
                        graph[bottom][top] = 1;
                    }
                }
            }
            
        }
        
        
        for(int i = 1; i <=n; i++) {
            
            int count = 0;
            for(int j = 1; j <=n; j++) {
                if(graph[i][j] != 0) count++;
            }
            if(count == n-1) answer++;
        }
        
        
        return answer;
    }
}