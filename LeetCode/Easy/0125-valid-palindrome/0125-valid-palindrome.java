class Solution {
    public boolean isPalindrome(String s) {
        
        String extractS = extractCharacterAndMakeLowerCase(s);
        String reverseS = reverseString(extractS);

        return isPalindrome(extractS, reverseS);
    }

    private String extractCharacterAndMakeLowerCase(String s) {
        return s.chars()
                .filter(Character::isLetterOrDigit)
                .mapToObj(c -> String.valueOf((char) c).toLowerCase())
                .collect(Collectors.joining());
    }

    private String reverseString(String s) {
        StringBuffer sb = new StringBuffer(s);
        return sb.reverse().toString();
    }

    private boolean isPalindrome(String s, String reverseS) {
        return s.equals(reverseS);
    }

    
}