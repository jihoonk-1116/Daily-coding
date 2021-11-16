/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //1. measure the list's length
        //2. traverse from the end of the list to nth 
        ListNode tempNode = head;
        int length = 0;
        
        while(tempNode!=null){
            length++;
            tempNode = tempNode.next;
        }
        
        if(length == 1) return null;
        
        int target = length - n; //if 5 nodes , n=2, target = 3
        
        if(target == 0){ //length == n -> means remove the first 
            head = head.next;
            return head;
        }
        
        ListNode prevTempNode = null; //Use slow pointer
        
        while(target>0){
            if(prevTempNode == null){ //if the first loop
                tempNode = head.next;
                prevTempNode = head;
            }
            else{
                prevTempNode = prevTempNode.next;
                tempNode = tempNode.next;
            }
            target--;
        }
        
        if(tempNode.next == null) prevTempNode.next= null;
        else prevTempNode.next = tempNode.next;
        
        return head;
        
    }
}
