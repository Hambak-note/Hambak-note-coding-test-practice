import java.util.*;

class Solution {
    
    private int[] distance;
    private List<List<Integer>> matrix;
    private int numOfVerties;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        numOfVerties = n;
        
        
        matrix = new ArrayList<>();
        for(int i = 0; i <= numOfVerties; i++) {
            matrix.add(new ArrayList<>());
        }
        
        for(int[] road : roads) {
            
            matrix.get(road[0]).add(road[1]);
            matrix.get(road[1]).add(road[0]);
        }
        
        dijkstra(destination);
        
        for(int i=0; i<sources.length; i++){
            if (distance[sources[i]]<Integer.MAX_VALUE){
                answer[i] = distance[sources[i]];
            } else{
                answer[i] = -1;
            }
        }
        
        return answer;
    }
    
    private void dijkstra(int destination) {
        
        distance = new int[numOfVerties+1];
        Queue<Integer> q = new LinkedList<>();
        
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        distance[destination] = 0;
        q.add(destination);
        
        while(!q.isEmpty()) {
            
            int u = q.poll();
            
            for(int i = 0; i < matrix.get(u).size(); i++) {
                int v = matrix.get(u).get(i);
                if(distance[u]+1 < distance[v]) {
                    distance[v] = distance[u]+1;
                    q.add(v);
                }
            }
        }
        
        
    }
}