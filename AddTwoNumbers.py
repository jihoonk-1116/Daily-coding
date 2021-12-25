#Leetcode 2. Add Two Number

#Approach 1:
'''
Step 1 : Reverse each list
Step 2 : Convert each list to string 
Step 3 : Add two strings as casting integer
Step 4 : Reverse the sum
Step 5 : Convert the reversed sum into Linked List, and return it
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        root = head = ListNode(0)
        strnum , strnum2 = "",""
        
        node, prev = l1, None
        while node:
            next, node.next = node.next, prev
            prev, node = node, next
        
        l1 = prev
        
        node, prev = l2, None
        while node:
            next, node.next = node.next, prev
            prev, node = node, next

        l2 = prev
        
        while l1 or l2:
            if l1:
                strnum += str(l1.val)
                l1= l1.next
            if l2:
                strnum2 += str(l2.val)
                l2 = l2.next
    
        print(strnum, strnum2)
            
        sum = str(int(strnum) + int(strnum2))
        sum = sum[::-1]
        l = len(sum)
        
        for i in range(l):
            head.next = ListNode(sum[i])
            head = head.next
        
        return root.next
      
#Appraoch2 full-adder logic

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        root = head = ListNode(0)
        carry =0
        
        while l1 or l2 or carry:
            sum=0
            if l1:
                sum += l1.val
                l1 = l1.next
            if l2:
                sum += l2.val
                l2 = l2.next
            
            carry , value = divmod(sum + carry, 10) #divmod() returns a tuple that is made of quotient, remainder 
            head.next = ListNode(value)
            head = head.next
        
        return root.next
