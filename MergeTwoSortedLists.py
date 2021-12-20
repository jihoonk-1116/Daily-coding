# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

#Approach1 : Back Tracking
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if (not list1) or (list2 and list1.val > list2.val): #list1 is empty or list2 is not empty and list1 node is greater than list2 node
            list1, list2 = list2, list1
        if list1:
            list1.next = self.mergeTwoLists(list1.next, list2)
        return list1
      
#Approach2 : Linked list iteration
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        
        merged_list = ListNode()
        head = ListNode()
        
        if not list1:
            return list2
        elif not list2:
            return list1
        
        if list1.val > list2.val:
            merged_list.val = list2.val
            list2 = list2.next
        else:
            merged_list.val = list1.val
            list1 = list1.next            
        head = merged_list
        
        while list1 and list2:
            
            temp_node = ListNode()
            
            if list1.val > list2.val:
                temp_node.val = list2.val
                list2 = list2.next
            else:
                temp_node.val = list1.val
                list1 = list1.next
                
            merged_list.next = temp_node
            merged_list = merged_list.next
        
        if list1:
            merged_list.next = list1
        else:
            merged_list.next = list2
        
        return head
      
#Java solution
#  * Definition for singly-linked list.
#  * public class ListNode {
#  *     int val;
#  *     ListNode next;
#  *     ListNode() {}
#  *     ListNode(int val) { this.val = val; }
#  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
#  * }
#  */
# class Solution {
#     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
#         ListNode merged_list = new ListNode();
#         ListNode head = new ListNode();
        
#         if(list1 == null) return list2;
#         else if(list2 == null) return list1;
            
#         if(list1.val < list2.val){
#             merged_list.val = list1.val;
#             list1 = list1.next;
#         }
#         else{
#             merged_list.val = list2.val;
#             list2= list2.next;
#         }
#         head = merged_list;
#         while(list1 != null & list2 != null){
#             ListNode tempNode = new ListNode();
#             if(list1.val<list2.val){
#                 tempNode.val = list1.val;
#                 list1 = list1.next;
#             }
#             else{
#                 tempNode.val = list2.val;
#                 list2 = list2.next;
#             }
#             merged_list.next = tempNode;
#             merged_list = merged_list.next;
#             //System.out.println(merged_list);
#         }
#         if(list1 != null){
#             merged_list.next = list1;
#         }
#         else{
#             merged_list.next = list2;
#         }
#         return head;
      
#     }
# }
