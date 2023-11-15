import java.util.*;

class Solution {
    
    private static List<String> routeList = new ArrayList<>();
    private static boolean[] visited;
    private static final String START_AIR_PORT = "ICN";
    
    public String[] solution(String[][] tickets) {

        visited = new boolean[tickets.length];
        dfs(tickets, START_AIR_PORT, 0, START_AIR_PORT);
        Collections.sort(routeList);
        
        
        return routeList.get(0).split(" ");
    }
    
    
    private void dfs(String[][] tickets, String currentAirport, int cnt, String route) {
        
        if(cnt == tickets.length) {
            routeList.add(route);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            
            if(!visited[i] && currentAirport.equals(tickets[i][0])) {
                
                visited[i] = true;
                dfs(tickets, tickets[i][1], cnt+1, route + " " + tickets[i][1]);
                visited[i] = false;
            }
        }
    }
}