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
            if q.pop(0) != q.pop():   #q.pop() takes O(n) because list is singly link list
                return False
        
        return True

    
#Approach 2 - using deque that is doubly linked list to access to both end side of the list with O(1)
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        dq = deque()
        
        if not head:
            return True
        
        node = head
        while node is not None:
            dq.append(node.val)
            node = node.next
            
        while len(dq) > 1:
            if dq.pop() != dq.popleft():   
                return False
            
        return True
    
# solution#2 takes 844 ms whereas solution#1 takes 2302ms.  
# solution3 : two pointers -> slow , fast pointers
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) ->bool:
        rev = None
        slow = fast = head
        while fast is not None and fast.next is not None:
            fast = fast.next.next
            rev, rev.next, slow = slow, rev, slow.next      #add new node in front of the rev list
            
        if fast is not None:   #In case that list.size is odd
            slow = slow.next
        
        while rev and rev.val == slow.val:
            slow, rev = slow.next, rev.next
            
        return not rev
