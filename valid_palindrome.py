#1 - use list

class Solution:
    def isPalindrome(self, s: str) -> bool:
        result = list()
        for c in s:
            if c.isalnum():
                result.append(c.lower())
                
        while len(result)>1:
            if result.pop(0) != result.pop():
                return False
        
        return True
      
 #2 - use Deque
class Solution:
    def isPalindrome(self, s: str) -> bool:
        result : Deque = collections.deque()
            
        for c in s:
            if c.isalnum():
                result.append(c.lower())
                
        while len(result)>1:
            if result.popleft() != result.pop():
                return False
        
        return True

 #3 - use slicing
class Solution:
    def isPalindrome(self, s):
        s= s.lower()
        s = re.sub('[^a-z0-9]','',s)
        
        return s == s[::-1] #reverse slicing
