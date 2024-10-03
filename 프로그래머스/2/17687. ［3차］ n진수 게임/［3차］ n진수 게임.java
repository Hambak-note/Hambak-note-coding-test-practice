

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";

        int numLength = t * m;

        String convertedStr = convertToBaseN(numLength, n);

        int index = p-1;
        for(int i = 0; i < t; i++){
            answer += convertedStr.charAt(index);
            index += m;
        }

        answer = answer.toUpperCase();
        System.out.println(answer);

        return answer;
    }


    public String convertToBaseN(int numLength, int notation){

        String convertedStr = "";

        int num = 0;
        while(convertedStr.length() < numLength){
            convertedStr = convertedStr + Integer.toString(num, notation);
            num++;
        }

        return convertedStr;
    }

}
