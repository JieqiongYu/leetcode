/**
* You are given two non-empty linked lists representing two non-negative integers.
* The digits are stored in reverse order and each of their nodes contain a single digit.
* Add the two numbers and return it as a linked list.
*
* You may assume the two numbers do not contain any leading zero, except the number 0 itself.
*
* Example
*
* Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
* Output: 7 -> 0 -> 8
* Explanation: 342 + 465 = 807.
*
* https://leetcode.com/problems/add-two-numbers/description/
*/
public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode p = l1;
		ListNode q = l2;
		ListNode curt = dummy;
		int carry = 0;

		while (p != null || q != null) {
			int x = (p == null) ? 0 : p.val;
			int y = (q == null) ? 0 : q.val;
			int digit = x + y + carry;
			carry = digit / 10;
			curt.next = new ListNode(digit % 10);
			curt = curt.next;

			if (p != null) {
				p = p.next;
			}

			if (q != null) {
				q = q.next;
			}

		}

		if (carry > 0) {
			curt.next = new ListNode(1);
		}

		return dummy.next;
	}
}
