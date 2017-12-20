/**
* Merge two sorted linked lists and return it as a new list.
* The new list should be made by splicing together the nodes of the first two lists.
* Example:
* Input: 1->2->3-4, 1->3-4
* Outpu: 1->1->2->3->4->4
* https://leetcode.com/problems/merge-two-sorted-lists/description/
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curt = dummyHead;

				// neither l1 and l2 is empty, compare each value from each node
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curt.next = l1;
                l1 = l1.next;
            } else {
                curt.next = l2;
                l2 = l2.next;
            }
            curt = curt.next;
        }

				// when l2 is empty
        if (l1 != null) {
            curt.next = l1;
        }

				// when l1 is empty
        if (l2 != null) {
            curt.next = l2;
        }

        return dummyHead.next;
    }
}
