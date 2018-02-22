/**
 * [LeetCode][515]Find Largest Value in Each Tree Row
 * 
 * You need to find the largest value in each row of a binary tree.
 * 
 * Example:
 * Input: 
 *
 *          1
 *         / \
 *        3   2
 *       / \   \  
 *      5   3   9 
 *
 * Output: [1, 3, 9]
 * 
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.val > max) {
                    max = current.val;
                }
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            ans.add(max);
        }
        
        return ans;
    }
}