import java.util.Stack;

class Solution {
    
    boolean solution(String s) {

        Stack<Character> parenthesisStack = new Stack<>();

        int sLength = s.length();

        for( int i = 0 ; i < sLength; i++) {

            if(s.charAt(i) == '(') {
                parenthesisStack.push(s.charAt(i));
                continue;
            }

            if(parenthesisStack.isEmpty()) return false;

            parenthesisStack.pop();
        }

        if(!parenthesisStack.isEmpty()) return false;

        return true;
    }

}