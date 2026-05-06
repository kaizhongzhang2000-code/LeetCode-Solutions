class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0:
            return 0
        char_set = set()

        left: int = 0
        right: int = 0
        result: int = 1
        char_set.add(s[0])
        while left <= right < len(s) - 1:
            right += 1
            while s[right] in char_set:
                char_set.remove(s[left])
                left += 1
            char_set.add(s[right])
            result = max(result, right - left + 1)

        return result
                    


        