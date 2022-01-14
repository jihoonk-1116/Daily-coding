class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        used={}
        max_length = start = 0
        for index, c in enumerate(s):
            if c in used and start <= used[c]:
                start = used[c] +1
            else:
                max_length = max(max_length, index - start + 1)
                
            used[c] = index
            
        return max_length
