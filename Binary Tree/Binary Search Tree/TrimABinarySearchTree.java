/**
 * [LeetCode][669] Trim a binary search tree.
 * 
 * Given a binary search tree and the lowest and highest boundaries as L and R, 
 * trim the tree so that all its elements lies in [L, R] (R >= L). 
 * You might need to change the root of the tree, 
 * so the result should return the new root of the trimmed binary search tree.
 * 
 * Example 1:
 * Input: 
 *     1
 *    / \
 *   0   2
 * 
 *   L = 1
 *   R = 2
 * 
 * Output: 
 *     1
 *       \
 *        2
 * 
 * Example 2:
 * Input: 
 *     3
 *    / \
 *   0   4
 *    \
 *     2
 *    /
 *   1
 * 
 *   L = 1
 *   R = 3
 * Output: 
 *       3
 *      / 
 *    2   
 *   /
 *  1
 * 
 * https://leetcode.com/problems/trim-a-binary-search-tree/description/
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
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return root;
        }
        
        if (root.val < L) {
            return trimBST(root.right, L, R);
        }
        
        if (root.val > R) {
            return trimBST(root.left, L, R);
        }
        
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        
        return root;
    }
}
/**
 * Complexity Analysis: 
 * Time Complexity: O(N), where N is the total number of node sin the given tree. 
 *                  We visit each node at most once. 
 * Space Complexity: O(N). Even though we don't explicitly use any additional memory, 
 *                  the call stack of our recursion could be as large as the number of 
 *                  nodes in the worst case. 
 */