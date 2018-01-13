/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * 
 * For example,  
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * 
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 */
/**
 * Intuition 
 * We notice that the problem could be simply reduced to another one: 
 * Remove the (L-n+1)th node from the beginning in the list, where L is the list length.
 * This problem is easy to solve once we found list length L.
 * 
 * Algorithm
 * First we will add an auxiliary “dummy” node, which points to the list head. 
 * The “dummy” node is used to simplify some corner cases such as a list with 
 * only one node, or removing the head of the list. On the first pass, we find 
 * the list length L. Then we set a pointer to the dummy node and start to move 
 * it through the list till it comes to the (L-n) node. We relink next pointer 
 * of the (L-n) th node to the (L-n+2)th node and we are done. 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        
        ListNode pointer = head;
        while (pointer != null) {
            length++;
            pointer = pointer.next;
        }
        
        length -= n;
        pointer = dummy;
        while (length > 0) {
            length--;
            pointer = pointer.next;
        }
        
        pointer.next = pointer.next.next;
        return dummy.next;
    }
}