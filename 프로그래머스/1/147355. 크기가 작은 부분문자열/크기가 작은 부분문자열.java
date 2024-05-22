class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        int pSize = p.length();
        
        Long pNum = Long.parseLong(p);
        for(int i = 0; i <= t.length() - pSize; i++) {
            
            String sub = t.substring(i, i+pSize);
            Long subNum = Long.parseLong(sub);
            
            if(subNum <= pNum) answer++;
            
        }
        
        return answer;
    }
}