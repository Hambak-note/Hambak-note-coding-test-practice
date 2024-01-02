class Solution {
    public boolean isPalindrome(String s) {
        
        String extractS = extractCharacterAndMakeLowerCase(s);
        Deque<Character> deque = makeDeque(extractS);

        return isPalindrome(deque);
    }

    private String extractCharacterAndMakeLowerCase(String s) {
        return s.chars()
                .filter(Character::isLetterOrDigit)
                .mapToObj(c -> String.valueOf((char) c).toLowerCase())
                .collect(Collectors.joining());
    }
    
    private Deque<Character> makeDeque(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++) {
            deque.add(Character.toLowerCase(s.charAt(i)));
        }

        return deque;
    }

    private boolean isPalindrome(Deque<Character> deque) {
        while(deque.size() > 1) {

            if(deque.pollFirst() != deque.pollLast())
            {
                System.out.println();
                return false;
            }
        }

        return true;
    }

    
}