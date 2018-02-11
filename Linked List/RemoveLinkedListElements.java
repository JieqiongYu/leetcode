/**
 * 
 * [LeetCode][203]Remove Linked List Elements
 * 
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 * 
 * https://leetcode.com/problems/remove-linked-list-elements/description/
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode current = head;
        ListNode previous = dummyHead;
        
        while (current != null) {
            if (current.val == val) {
                previous.next = current.next;
            } else {
                previous = previous.next;
            }
            current = current.next;
        }
        
        return dummyHead.next;
    }
}