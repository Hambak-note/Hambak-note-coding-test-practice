import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> alpaMap = new HashMap<>();

        while(true) {

            String input = br.readLine();
            if(input == null) break;

            for(int i = 0; i < input.length(); i++) {

                char cur = input.charAt(i);
                if(cur == ' ') continue;
                alpaMap.put(cur, alpaMap.getOrDefault(cur, 0)+1);
            }
        }

        StringBuilder sb = new StringBuilder();
        int maxCount = 0;
        for(Character key : alpaMap.keySet()) {
            
            int curCount = alpaMap.get(key);
            if(curCount > maxCount) {
                maxCount = curCount;
                sb = new StringBuilder();
                sb.append(key);
                continue;
            }

            if(curCount == maxCount) {
                sb.append(key);
                continue;
            }
        }

        String answerStr = sb.toString();
        char[] answerCharArr = answerStr.toCharArray();
        Arrays.sort(answerCharArr);
        String sortedAnswerStr = new String(answerCharArr);

        System.out.println(sortedAnswerStr);
    }
}