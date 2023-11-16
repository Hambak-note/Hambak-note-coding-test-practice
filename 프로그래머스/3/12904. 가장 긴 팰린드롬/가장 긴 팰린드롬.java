class Solution
{
    public int solution(String s)
    {
        int sLen = s.length();
        for(int i = sLen; i > 0; i--) {
            
            for(int j = 0; j+i <= sLen; j++) {
                
                if(isPalindrome(s, j, j+i-1)) return i;
            }
        }
        return 0;
    }
    
    private boolean isPalindrome(String target, int start, int end) {
        
        while(start <= end) {
            
            if(target.charAt(start) != target.charAt(end)) return false;
            
            start++;
            end--;
        }
        return true;
    }
}