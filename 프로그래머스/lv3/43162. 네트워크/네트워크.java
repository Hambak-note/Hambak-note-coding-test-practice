

import java.util.Arrays;

public class Solution {

    private static boolean[] visited;
    private static int[][] computersCopy;


    public  int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new boolean[n];
        Arrays.fill(visited, false);

        computersCopy = computers;

        for(int i = 0; i < computersCopy.length; i++) {
            if(!visited[i]) {
                dfs(i);
                answer+=1;
            }
        }
        
        return answer;
    }

    private  void dfs(int index) {
        visited[index] = true;

        for(int i = 0; i < computersCopy.length; i++) {

            if(computersCopy[index][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
