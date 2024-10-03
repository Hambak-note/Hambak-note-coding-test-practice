class Solution {
     public static String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int num = 0;
        
        while (sb.length() < t*m) {
            String str = Integer.toString(num, n);
            sb.append(str);
            num++;
        }

        String target = sb.toString().substring(0, t*m);
        sb = new StringBuilder();
        for(int i = p-1; i < target.length(); i+=m) {
            sb.append(target.charAt(i));
        }

        answer = sb.toString().toUpperCase();
        return answer;
    }
}