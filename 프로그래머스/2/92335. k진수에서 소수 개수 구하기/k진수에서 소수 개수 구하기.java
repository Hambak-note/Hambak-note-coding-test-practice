import java.util.ArrayList;


class Solution {
    public static int solution(int n, int k) {
        int answer = 0;

        String converted = Integer.toString(n, k);

        int start = 0;
        int end = 0;

        ArrayList<String> numList = new ArrayList<>();
        while(start < converted.length() && end < converted.length()) {

            char cur = converted.charAt(end);
            if(cur == '0') {
                if(start != end) numList.add(converted.substring(start, end));
                end++;
                start = end;
                continue;
            }

            end++;
        }

        if(converted.charAt(converted.length() -1) != '0') {
            numList.add(converted.substring(start, end));
        }


        for (String num : numList) {
            boolean prime = isPrime(Long.parseLong(num));
            if(prime) answer++;
        }

        return answer;
    }

    private static boolean isPrime(long number) {

        if(number <= 1) return false;

        if (number == 2) {
            return true;
        }

        if (number % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}