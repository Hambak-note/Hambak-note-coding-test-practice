from typing import List

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        left, right = 0, 0
        longest_len, cur_len = 0, 0
        char_set = set()

        while left < len(s) and right < len(s):
            
            if s[right] in char_set:
                char_set.remove(s[left])
                cur_len -= 1
                left += 1
                continue

            char_set.add(s[right])
            cur_len += 1
            right += 1
            longest_len = max(cur_len, longest_len)

        return longest_len
