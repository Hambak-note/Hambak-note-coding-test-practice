class Solution {
        public String longestPalindrome(String s) {

            if(isExitCondition(s)) return s;

            String result = "";
            int longest = 0;
            for(int i = 0; i < s.length()-1; i++) {


                String s1 = expand(i, i + 1, s);
                String s2 = expand(i, i + 2, s);

                String longStr = (s1.length() > s2.length()) ? s1 : s2;
                if(longest < longStr.length()) {
                    longest = longStr.length();
                    result = longStr;
                }
            }

            return result;

        }

        private String expand(int left, int right, String s) {

            while(left >= 0 && right < s.length()
                    && (s.charAt(left) == s.charAt(right))) {
                left -= 1;
                right += 1;
            }

            return s.substring(left+1, right);
        }

        private boolean isExitCondition(String s) {
            if(s.length() < 2) return true;

            StringBuilder reversed = new StringBuilder(s).reverse();
            if(s.equals(reversed)) return true;

            return false;
        }
    }