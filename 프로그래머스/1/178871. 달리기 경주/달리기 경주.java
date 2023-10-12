
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String[] solution(String[] players, String[] callings) {

        String[] answer = {};

        Map<String, Integer> playerMap = new HashMap<>();

        for(int i = 0; i < players.length; i++) {
            playerMap.put(players[i], i);
        }

        for(int i = 0; i < callings.length; i++) {

            Integer callingIdx = playerMap.get(callings[i]);
            String prevPlayer = players[callingIdx-1];

            players[callingIdx] = prevPlayer;
            players[callingIdx-1] = callings[i];

            playerMap.put(callings[i], callingIdx-1);
            playerMap.put(prevPlayer, callingIdx);
        }

        answer = players;

        return answer;
    }
}
