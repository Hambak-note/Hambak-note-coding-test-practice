import java.util.*;

class Solution {
    public boolean isPalindrome(String s) {
        
        String ups = s.toUpperCase();
        StringBuilder sb = new StringBuilder();
        
        int test = '0';
        
        for(int i = 0; i < s.length(); i++) {
            
            char ch = ups.charAt(i);
            if(Character.isDigit(ch)) sb.append(ch);
            if(ch >= 65 && ch <= 90) sb.append(ch);
        }
        
        String filtered = sb.toString();
        
        if(filtered.isEmpty() || filtered.length() == 1) return true;
        
        int mid = filtered.length() / 2;
        String s1, s2;
        
        if((filtered.length() % 2) == 1) {    
            s1 = filtered.substring(0, mid);
            s2 = filtered.substring(mid+1);
        }
        
        else {
            s1 = filtered.substring(0, mid);
            s2 = filtered.substring(mid);
        }
        
        boolean isPalindrome = true;
        for(int i = 0; i < mid; i++) {
               
            if(s1.charAt(i) == s2.charAt(mid - i - 1)) continue;
            
            isPalindrome = false;
            break;
        }
        
        
        
        
        return isPalindrome;
        
    }
}