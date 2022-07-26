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
/*
public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    int length  = 0;
    ListNode first = head;
    while (first != null) {
        length++;
        first = first.next;
    }
    length -= n;
    first = dummy;
    while (length > 0) {
        length--;
        first = first.next;
    }
    first.next = first.next.next;
    return dummy.next;
}
*/
// The "dummy" node is used to simplify some corner cases such as a list with only one node, or removing the head of the list.
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(head.next == null) return null;
    
        ListNode dummy = new ListNode(0,head);
        ListNode lt = dummy;
        ListNode rt = head;
        
        while(n > 0 && rt != null){
            rt = rt.next;
            n--;
        }
        
        while(rt != null){
            rt = rt.next;
            lt = lt.next;
        }
        
        lt.next = lt.next.next;
        return dummy.next;
    }
}
