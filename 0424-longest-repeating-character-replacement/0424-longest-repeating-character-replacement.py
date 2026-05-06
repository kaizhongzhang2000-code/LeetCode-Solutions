class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        most = 0
        countmap = collections.defaultdict(set)
        strmap = collections.defaultdict(int)
        left, right, result = 0, 0, 0
        while right < len(s):
            countmap[strmap[s[right]]].discard(s[right])
            strmap[s[right]] += 1
            countmap[strmap[s[right]]].add(s[right])
            most = max(strmap[s[right]], most)
            while right - left + 1 - most > k:
                countmap[strmap[s[left]]].discard(s[left])
                strmap[s[left]] -= 1
                countmap[strmap[s[left]]].add(s[left])
                if not countmap[most]:
                    most -= 1
                left += 1
            result = max(result, right - left + 1)
            right += 1
        return result
        