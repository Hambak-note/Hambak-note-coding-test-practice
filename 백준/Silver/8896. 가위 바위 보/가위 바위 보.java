import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        
        for(int test = 1; test <= testCases; test++) {
            LinkedList<Integer> remainingRobots = new LinkedList<>();
            int robotCount = Integer.parseInt(br.readLine());
            String[] moves = new String[robotCount];
            
            for(int i = 0; i < robotCount; i++) {
                moves[i] = br.readLine();
                remainingRobots.add(i);
            }

            for(int round = 0; round < moves[0].length(); round++) {
                HashMap<Integer, Character> roundMoves = new HashMap<>();
                for(int i = 0; i < remainingRobots.size(); i++) {
                    int robotId = remainingRobots.get(i);
                    char move = moves[robotId].charAt(round);
                    roundMoves.put(robotId, move);
                }
                
                int moveTypes = 0;
                char[] moveCount = new char[3];
                for(int i = 0; i < remainingRobots.size(); i++) {
                    int robotId = remainingRobots.get(i);
                    char move = roundMoves.get(robotId);
                    switch(move) {
                        case 'S': moveCount[0]++; break;
                        case 'R': moveCount[1]++; break;
                        case 'P': moveCount[2]++; break;
                    }
                }
                
                for(int i = 0; i < 3; i++) {
                    if(moveCount[i] != 0) moveTypes++;
                }
                
                if(moveTypes == 3 || moveTypes == 1) continue;
                else if(moveTypes == 2) {
                    if(moveCount[2] == 0) {
                        for(int i = remainingRobots.size()-1; i >= 0; i--) {
                            if(roundMoves.get(remainingRobots.get(i)) == 'S') remainingRobots.remove(i);
                        }
                    } else if(moveCount[0] == 0) {
                        for(int i = remainingRobots.size()-1; i >= 0; i--) {
                            if(roundMoves.get(remainingRobots.get(i)) == 'R') remainingRobots.remove(i);
                        }
                    } else if(moveCount[1] == 0) {
                        for(int i = remainingRobots.size()-1; i >= 0; i--) {
                            if(roundMoves.get(remainingRobots.get(i)) == 'P') remainingRobots.remove(i);
                        }
                    }
                }
                
                if(remainingRobots.size() == 1) {
                    System.out.println(remainingRobots.get(0) + 1);
                    break;
                }
            }
            
            if(remainingRobots.size() > 1) System.out.println(0);
        }
    }
}