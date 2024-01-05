import java.util.HashSet;
import java.util.Set;

class Solution {
        public int lengthOfLongestSubstring(String s) {

            int left = 0;
            int right = 0;
            int longestLen = 0;
            int curLen = 0;
            Set<Character> charSet = new HashSet<>();

            while(left < s.length() && right < s.length()) {

                if(charSet.contains(s.charAt(right))) {
                    charSet.remove(s.charAt(left));
                    curLen--;
                    left++;
                    continue;
                }

                charSet.add(s.charAt(right));
                curLen++;
                right++;
                longestLen = Math.max(curLen, longestLen);
            }


            return longestLen;
        }
    }