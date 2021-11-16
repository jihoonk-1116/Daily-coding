/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
//  */
class Solution {
    public ListNode middleNode(ListNode head) {
        //return the middle node
        //if the length is odd -> return the middle one
        //if the length is even -> return the second middle 
        //1. traverse the list to measure its length
        //2. set middle position by division by the length
        //3. traverse the list once more in order to find the middle node.
        ListNode tempNode = head;
        int length = 0;
      
        while(tempNode != null){. //measure the list's length
            length++;
            tempNode = tempNode.next;
        }
      
        if(length == 1) return head;
      
        int middle = length/2; //assign middle 
        
        tempNode = head; //Set tempNode to head again to start to traverse the list 
        while(middle > 0){ //iterate as middle 
            tempNode = tempNode.next;
            middle--;
        }
        return tempNode;
    }
}

//Another approach, from Leetcode solution 
//two pointers -> move twice as fast so that slow pointer's position must be fast / 2
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
