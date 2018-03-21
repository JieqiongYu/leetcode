/**
 * [LeetCode][110]Balanced Binary Tree.
 * 
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as 
 * a binary tree in which the depth of the two subtrees of every node 
 * never differ by more than 1.
 * 
 * https://leetcode.com/problems/balanced-binary-tree/description/
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
    
    class ResultType {
        boolean isBalanced;
        int maxDepth;
        public ResultType(boolean isBalanced, int maxDepth) {
            this.isBalanced = isBalanced;
            this.maxDepth = maxDepth;
        }
    }
    
    public boolean isBalanced(TreeNode root) {
        return dfs(root).isBalanced; 
    }
    
    public ResultType dfs(TreeNode node) {
        if (node == null) {
            return new ResultType(true, 0);
        }
        
        ResultType left = dfs(node.left);
        ResultType right = dfs(node.right);
        
        // subtree not balance
        if (!left.isBalanced || !right.isBalanced) {
            return new ResultType(false, -1);
        }
        
        // root not balance
        if (Math.abs(left.maxDepth - right.maxDepth) > 1) {
            return new ResultType(false, -1);
        }
        
        return new ResultType(true, Math.max(left.maxDepth, right.maxDepth) + 1);
    }
}