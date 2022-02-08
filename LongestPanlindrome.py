class Solution:
    def longestPalindrome(self, s: str) -> str:
        
        def expand(left: int, right: int) -> str: #sliding window expandsion
            
            #left pointer moves to the left of s , right moves to opposite
            #while s[left] and s[right] both are same
            while left >= 0 and right < len(s) and s[left] == s[right]:
                left -= 1
                right += 1
            
            #python slicing method returns l ~ r-1
            #Because the element after the loop is not equal -> s[l] != s[r], we need to take the previous slice -> s[l+1:r].
            return s[left+1:right]
        
        #Exception case
        #check the string if it is already palindrome or too short to be a palindrome
        if len(s)<2 or s == s[::-1]:
            return s
        
        result=""
        
        for i in range(0, len(s)-1): #start to search as moving to the right side of the input string
            result = max(result, #result should be updated when to find longest palindrome
                         expand(i,i+1), #expand the silding window in case that s is odd palindrome
                         expand(i,i+2), #expand the silding window in case that s is even palindrome
                         key=len)
            
        return result
    
'''
From .kanhar 
https://leetcode.com/problems/longest-palindromic-substring/discuss/2954/Python-easy-to-understand-solution-with-comments-(from-middle-to-two-ends)./232977

def longestPalindrome(s):
    res = ""
    for i in range(len(s)):        
        odd  = palindromeAt(s, i, i)
        even = palindromeAt(s, i, i+1)
        
        res = max(res, odd, even, key=len)
    return res
 
# starting at l,r expand outwards to find the biggest palindrome
def palindromeAt( s, l, r):    
    while l >= 0 and r < len(s) and s[l] == s[r]:
        l -= 1
        r += 1
    return s[l+1:r]

print(longestPalindrome("babad"))
print(longestPalindrome("cbbd"))
'''
