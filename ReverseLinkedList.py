#Leetcode 206

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

#Approach1 : Recursive call with next node that is being handled in the next call and current node that is being assigned next of next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        def reverse(node : ListNode, prev : ListNode=None):
            if not node:
                return prev
            
            next, node.next = node.next, prev
            #The next variable is for storing the next element to be covered because node.next should be 
            #assigned prev 
            return reverse(next, node)
            #reverse function is invoked with next argument as current node 
            #and the input node as prev argument
            
        return reverse(head)
      
#Approach2 : Iteration 

class Solution:
    def reverseList(self, head:Optional[ListNode]) -> Optional[ListNode]:
      node , prev = head, None
      
      while node:
        next, node.next = node.next, prev
        node, prev = next, node
        
      return prev
