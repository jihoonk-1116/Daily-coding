#1 - use list

class Solution:
    def isPalindrome(self, s: str) -> bool:
        result = list()
        for c in s:
            if c.isalnum(): #Check if c is alphabet or number, not space
                result.append(c.lower())
                
        while len(result)>1:
            if result.pop(0) != result.pop(): #list's pop(0) takes O(n)
                return False                  #So,O(n^2)
        
        return True
      
 #2 - use Deque
class Solution:
    def isPalindrome(self, s: str) -> bool:
        result : Deque = collections.deque()
            
        for c in s:
            if c.isalnum():
                result.append(c.lower())
                
        while len(result)>1:
            if result.popleft() != result.pop(): #Deque's popleft takes O(1). It's like Doubly-Linked List
                return False
        
        return True

 #3 - use slicing
class Solution:
    def isPalindrome(self, s):
        s= s.lower()
        s = re.sub('[^a-z0-9]','',s)
        
        return s == s[::-1] #reverse slicing
