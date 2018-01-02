/**
* Given a linked list and a value x, partition it such that all nodes less than x come
* before nodes greater than or equal to x.
*
* You should preserve the original relative order of the nodes in each of the two partitions.
*
* For example,
* Given 1->4->3->2->5->2 and x = 3,
* return 1->2->2->4->3->5.
*
* https://leetcode.com/problems/partition-list/description/
*/
/**
* 解题思路：
* 这道题要求我们划分链表，把所有小于给定值的节点都移到前面，大于该值的节点顺序不变，
* 相当于一个局部排序的问题。那么可以想到的一种解法是首先找到第一个大于或等于给定值的节点，
* 用题目中给的例子来说就是先找到4，然后再找小小于3的值，每找到一个就将其取出置于4之前即可，
* 这种解法的链表变化顺序为：
* 1 -> 4 -> 3 -> 2 -> 5 -> 2
* 1 -> 2 -> 4 -> 3 -> 5 -> 2
* 1 -> 2 -> 2 -> 4 -> 3 -> 5
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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curt = head;

        // find the first node >= x
        while (prev.next != null && prev.next.val < x) {
            prev = prev.next;
        }

        curt = prev;
        while (curt.next != null) {
            if (curt.next.val < x) {
                ListNode tmp = curt.next;
                curt.next = tmp.next;
                tmp.next = prev.next;
                prev.next = tmp;
                prev = prev.next;
            } else {
                curt = curt.next;
            }
        }

        return dummy.next;
    }
}
