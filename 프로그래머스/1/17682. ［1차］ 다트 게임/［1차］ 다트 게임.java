import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public static int solution(String dartResult) {

        int answer = 0;

        Pattern pattern = Pattern.compile("([0-9]+)([SDT])([*#]?)");
        Matcher matcher = pattern.matcher(dartResult);

        Stack<Integer> stack = new Stack<>();
        while(matcher.find()) {

            int score = Integer.parseInt(matcher.group(1));

            if(matcher.group(2).equals("D")) score *= score;
            if(matcher.group(2).equals("T")) score *= (score * score);

            if(matcher.group(3).equals("*")) {
                if(!stack.isEmpty()) {
                    int top = stack.pop();
                    stack.push(top * 2);
                }
                score *= 2;
            }

            if(matcher.group(3).equals("#")) {
                score *= -1;
            }

            stack.push(score);
        }

        while(!stack.isEmpty()) answer += stack.pop();
        
        return answer;
    }
}