import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = new int[n];
        
        Arrays.sort(costs, Comparator.comparingInt(a -> a[2]));
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        
        for(int i = 0; i < costs.length; i++) {
            if(findParent(parent, costs[i][0]) != findParent(parent, costs[i][1])) {
                answer += costs[i][2];
                union(parent, costs[i][0], costs[i][1]);
            }
        }
        return answer;
    }
    
    private int findParent(int[] parent, int node) {
        if(parent[node] == node) {
            return node;
        }
        return findParent(parent, parent[node]);
    }
    
    private void union(int[] parent, int node1, int node2) {
        int parent1 = findParent(parent, node1);
        int parent2 = findParent(parent, node2);
        
        if(parent1 < parent2) 
            parent[parent2] = parent1;
        else
            parent[parent1] = parent2;
    }
}