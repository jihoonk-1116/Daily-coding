#Two pointers
class solution:
  def reverseString(self, s: List[str]) -> None:
    left, right = 0, len(s) -1
    
    while left < right:
      s[left], s[right] = s[right], s[left]
      left += 1
      right += 1
      
 #Pythonic way
class solution:
  def reverseString(self, s: List[str]) -> None:
    s[:] = s[::-1] #Leetcode dosen't allow to use extra space
    # Or s.reverse()
