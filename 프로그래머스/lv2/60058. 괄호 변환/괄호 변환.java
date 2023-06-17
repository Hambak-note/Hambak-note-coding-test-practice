import java.util.*;
import java.lang.*;

class Solution {
    
    private static final char OPEN = '(';
    private static final char CLOSE = ')';
    
    public String solution(String p) {
        String answer = "";
        
        answer = bracketConversionProcess(p);
         
        return answer;
    }
    
    private String bracketConversionProcess(String inputStr) {
        
          /* 1. 입력이 빈 문자열인 경우 빈 문자열 반환 */
        if(inputStr.isEmpty()) return inputStr;

        /* 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리 */
        String[] separatedStrs = balancedParenthesisStringSeparation(inputStr);

        String strU = separatedStrs[0];
        String strV = separatedStrs[1];

        /* 3. 문자열 u가 "올바른 괄호 문자열" 이라면 v에 대해 1단계부터 다시 수행 */

        if(validateCorrectParenthesesString(strU)) {
            return strU.concat(bracketConversionProcess(strV));
        }
        String processedStr = "";
        /* 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정 수행 */
        /* 4-1. 빈 문자열에 첫 번째 문자로 '(' 문자를 붙인다. */
        processedStr += OPEN;
        /* 4-2. 문자열 V에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙인다. */
        processedStr += bracketConversionProcess(strV);
        /* ')'를 다시 붙인다. */
        processedStr += CLOSE;
        /* U의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙인다. */
        processedStr += changeUStr(strU);

        return processedStr;
    }
    
    
    /* 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리하는 함수 */
    private String[] balancedParenthesisStringSeparation(String inputStr) {
        
         int startIdx = 0;
        int endIdx = 0;

        int left = 0;
        int right = 0;

        for(int i = 0; i < inputStr.length(); i++) {

            if(inputStr.charAt(i) == OPEN) {
                left++;
            } else if(inputStr.charAt(i) == CLOSE){
                right++;
            }

            if(left == right) {
                endIdx = i;
                break;
            }
        }

        String strU = inputStr.substring(startIdx, endIdx+1);
        String strV = inputStr.substring(endIdx+1);

        String[] seperatedStrs = new String[]{strU, strV};

        return seperatedStrs;        
    }
    
    /* 입력된 문자열이 올바른 괄호 문자열인지 확인 */
    private boolean validateCorrectParenthesesString(String inputStr) {
        
       // 시작 문자열이 닫는 괄호이면 올바르지 않음
        if(inputStr.charAt(0) == CLOSE) return false;

        Stack<Character> parenthesesStack = new Stack<>();

        for(int i = 0; i < inputStr.length(); i++) {

            if(parenthesesStack.empty() || parenthesesStack.peek() == OPEN )
                parenthesesStack.push(inputStr.charAt(i));

            parenthesesStack.pop();
        }

        if(parenthesesStack.empty()) return true;

        return false;
    }

    /* 4단계에서 문자열 U를 변경하는 함수 */
    private String changeUStr(String inputStr) {
        
      
         String subStr = inputStr.substring(1, inputStr.length()-1);

        String changedStr = "";
        for (int i = 0; i < subStr.length(); i++) {

            if (subStr.charAt(i) == OPEN) {
                changedStr += CLOSE;
                continue;
            }

            if (subStr.charAt(i) == CLOSE) {
                changedStr += OPEN;
                continue;
            }
        }

        return changedStr;
    }
}