#Leetcode 206

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next


'''
1. save node.next in next
2. assign node.next to prev
3. assign node to next
4. assign prev to node
'''
#Approach1 : Recursive call with next node that is being handled in the next call and current node that is being assigned next of next
# Which data shold be passed for the next recursion. 
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        def reverse(node : ListNode, prev : ListNode=None):
            if not node:
                return prev
            
            next, node.next = node.next, prev
            #The next variable is for storing the next element to be covered in the next invocation
            #To reverse, node.next should be prev
            return reverse(next, node)
            #next becomes the node argument that points to the current position for the next recursion.
            #node becomes the prev argument being assigned to in front of the node for the next recursion.
            
        return reverse(head)
      
#Approach2 : Iteration 

class Solution:
    def reverseList(self, head:Optional[ListNode]) -> Optional[ListNode]:
      node , prev = head, None
      
      while node:
        next, node.next = node.next, prev
        node, prev = next, node
        
      return prev
