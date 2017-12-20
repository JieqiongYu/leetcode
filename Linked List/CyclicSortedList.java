/**
* Given a node from a cyclic linked list which has been sorted,
* write a function to insert a value into the list such that it remains a cyclic sorted list.
* The given node can be any single node in the list. Return the inserted new node.
* Notice: 3->5->1 is a cyclic list, so 3 is next node of 1.
* 3->5-> 1 is same with 5->1->3
* Example:
* Given a list, and insert a value 4:
* 3->5->1
* Return 5->1->3->4
* http://www.lintcode.com/en/problem/insert-into-a-cyclic-sorted-list/
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
class Solution {
    public ListNode insert(ListNode node, int x) {
        // write your code here
        if (node == null) {
            node = new ListNode(x);
            node.next = node;
            return node;
        }

        ListNode current = node;
        ListNode previous = null;

        do {
            previous = current;
            current = current.next;

            if (x <= current.val && x >= previous.val) {
                break;
            }

            if (previous.val > current.val && x <= current.val) {
                break;
            }
        } while (current != node);

        ListNode newNode = new ListNode(x);
        newNode.next = current;
        previous.next = newNode;

        return newNode;
    }
}
