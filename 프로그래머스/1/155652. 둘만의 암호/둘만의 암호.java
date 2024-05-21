class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        
        for(int i = 0; i < s.length(); i++) {
            
            char cur = s.charAt(i);
            int idx = 0;
            while(idx < index) {
              
                cur = (char)(cur+1);
                if(cur > 'z') cur = 'a';
                if(skip.indexOf(cur) != -1) {
                    continue;
                }
                
                idx++;
            }
            answer += cur;
        }
        return answer;
    }
}