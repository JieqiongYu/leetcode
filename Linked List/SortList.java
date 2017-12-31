/**
* Sort a linked list in O(n log n) time using constant space complexity.
*
* https://leetcode.com/problems/sort-list/description/
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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMiddle(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);

        return merge(left, right);
    }

    private ListNode findMiddle(ListNode head) {
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode curt = dummy;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                curt.next = head1;
                head1 = head1.next;
            } else {
                curt.next = head2;
                head2 = head2.next;
            }
            curt = curt.next;
        }

        if (head1 != null) {
            curt.next = head1;
        } else {
            curt.next = head2;
        }

        return dummy.next;
    }
}
