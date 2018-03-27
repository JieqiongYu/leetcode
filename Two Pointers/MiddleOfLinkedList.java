/**
 * [LintCode][228] Middle of Linked List
 * 
 * Find the middle node of a linked list.
 * 
 * Example
 * Given 1->2->3, return the node with value 2.
 * Given 1->2, return the node with value 1.
 * 
 * http://www.lintcode.com/en/problem/middle-of-linked-list/
 */
/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /*
     * @param head: the head of linked list.
     * @return: a middle node of the linked list
     */
    public ListNode middleNode(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}