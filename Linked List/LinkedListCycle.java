/**
 * [LeetCode][141]Linked List Cycle
 * 
* Given a linked list, determine if it has a cycle in it.
*
* Example
* Given -21->10->4->5, tail connects to node index 1, return true
*
* http://www.lintcode.com/en/problem/linked-list-cycle/
*/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {        
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast != null && fast.next != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        } 
    
        return false;
    }
}