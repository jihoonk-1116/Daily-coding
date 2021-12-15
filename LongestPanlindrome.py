class Solution:
    def longestPalindrome(self, s: str) -> str: #s is string and return value is also string 
        def expand(left:int, right:int) -> str: #Nested function expand() that have two int parameters, left & right. 
                                                #They move and expand left and right side of the input string to find valid palindrome and its length
            while left >= 0 and right < len(s) and s[left] == s[right]:
                left -= 1
                right += 1
            return s[left+1:right]        #return s[left+1] ~ s[right-1] because the slicing split s upto n-1
        
        if len(s) < 2 or s == s[::-1]:    #check the string if it is already palindrome or too short to be a palindrome
            return s
        
        result = ''
        for i in range(len(s)-1):     #start to search as moving the right side of the string
            result = max(result,      #result should be updated when to find longest palindrome
                         expand(i,i+1), #expand the silding window in case that s is odd palindrome
                         expand(i,i+2), #expand the silding window in case that s is even palindrome
                         key=len
                        )
        
        return result
