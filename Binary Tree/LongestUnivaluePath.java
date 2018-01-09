/**
 * Given a binary tree, find the length of the longest path where each node in 
 * the path has the same value. This path may or may not pass through the root.
 * 
 * Note: The length of path between two nodes is represented by the number of 
 * edges between them.
 * 
 * Example 1:
 * Input:
 *            5
 *           / \
 *          4   5
 *         / \   \
 *        1   1   5
 * Output:2
 * 
 * Example 2:
 * Input:
 *           1
 *          / \
 *         4   5
 *        / \   \
 *       4   4   5
 * Output:2
 * 
 * Note: The given binary tree has not more than 10000 nodes. 
 * The height of the tree is not more than 1000.
 * 
 * https://leetcode.com/problems/longest-univalue-path/description/
 */
class Solution {
    int answer = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return answer;
    }
    
    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int left = dfs(node.left);
        int right = dfs(node.right);
        int leftPath = 0;
        int rightPath = 0;
        
        if(node.left != null && node.left.val == node.val) {
            leftPath = left + 1;
        }
        
        if (node.right != null && node.right.val == node.val) {
            rightPath = right + 1;
        }
        
        answer = Math.max(answer, leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }
}