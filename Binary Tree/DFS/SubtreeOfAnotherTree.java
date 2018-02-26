/**
 * [LeetCode][572]Subtree of Another Tree.
 * 
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure 
 * and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. 
 * The tree s could also be considered as a subtree of itself.
 * 
 * Example 1:
 * Given tree s:
 * 
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 
 * Given tree t:
 *    4 
 *   / \
 *  1   2
 * 
 * Return true, because t has the same structure and node values with a subtree of s.
 * 
 * Example 2:
 * Given tree s:
 * 
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return false.
 * 
 * https://leetcode.com/problems/subtree-of-another-tree/description/
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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return dfs(s, t);
    }
    
    private boolean dfs(TreeNode s, TreeNode t) {
        return s!= null && (isEqual(s, t) || dfs(s.left, t) || dfs(s.right, t));
    }
    
    private boolean isEqual(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        return (s.val == t.val) && isEqual(s.left, t.left) && isEqual(s.right, t.right);
    }
}
/**
 * Time Complexity: O(m * n). In worst case (skewed tree), dfs function takes O(m * n) times.
 * Space Compleixty: O(n).The depth of the recursion tree can go up to n. n refers to the number of nodes in s. 
 */