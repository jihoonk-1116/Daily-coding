#Approach #1
#convert the input linked list to python list 

class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        q = list()
        
        if not head:
            return True
        
        node = head
        while node is not None:
            q.append(node.val)
            node = node.next
        
        while len(q)>1:
            if q.pop(0) != q.pop():
                return False
        
        return True
