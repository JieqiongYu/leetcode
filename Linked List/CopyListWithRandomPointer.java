/**
* A linked list is given such that each node contains an additional random pointer
* which could point to any node in the list or null.
* Return a deep copy of the list.
* 
* https://leetcode.com/problems/copy-list-with-random-pointer/description/
*/
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
	public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode dummy = new RandomListNode(0);
		RandomListNode p = head;
		RandomListNode q = dummy;

        Map<RandomListNode, RandomListNode> map = new HashMap<>();

		while (p != null) {
			q.next = new RandomListNode(p.label);
			map.put(p, q.next);
			p = p.next;
			q = q.next;
		}

		p = head;
		q = dummy;

		while (p != null) {
			q.next.random = map.get(p.random);
			p = p.next;
			q = q.next;
		}

		return dummy.next;
	}
}
