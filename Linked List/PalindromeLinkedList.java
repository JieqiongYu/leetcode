/**
* Given a singly linked list, determine if it is a palindrome.
*
* Follow up:
* Could you do it in O(n) time and O(1) space?
*
* https://leetcode.com/problems/palindrome-linked-list/description/
*/
/**
* This can be solved by reversing the 2nd half and compare the two halves.
* (1) Find (2) Reverse (3) Compare
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /*
     * @param head: A ListNode.
     * @return: A boolean.
     */
    public boolean isPalindrome(ListNode head) {

        if (head == null) {
            return true;
        }

        ListNode mid = findMiddle(head);
        mid.next = reverse(mid.next);

        ListNode p1 = head;
        ListNode p2 = mid.next;

        while (p1 != null && p2 != null && p1.val == p2.val) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2 == null;
    }

    private ListNode findMiddle(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private ListNode reverse(ListNode head) {

        ListNode prev = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;
    }
}
