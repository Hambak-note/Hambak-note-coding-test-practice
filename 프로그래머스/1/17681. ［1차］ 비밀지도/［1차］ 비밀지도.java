class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i = 0; i < n; i++) {

            String binary1 = String.format("%" + n +"s", Integer.toBinaryString(arr1[i])).replace(' ', '0');
            String binary2 = String.format("%" + n +"s", Integer.toBinaryString(arr2[i])).replace(' ', '0');

            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < binary1.length(); j++) {

                char b1Char = binary1.charAt(j);
                char b2Char = binary2.charAt(j);

                if(b1Char == '1' || b2Char == '1') sb.append("#");
                else sb.append(" ");
            }

            answer[i] = sb.toString();
        }
        return answer;
    }
}