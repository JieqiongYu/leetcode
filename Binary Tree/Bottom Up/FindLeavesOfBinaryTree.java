/**
 * 
 * [LeetCode][366]Find Leaves of Binary Tree.
 * 
 * Given a binary tree, collect a tree's nodes as if you were doing this: 
 * Collect and remove all leaves, repeat until the tree is empty.
 *
 * Example:
 * Given binary tree 
 *          1
 *         / \
 *        2   3
 *       / \     
 *      4   5    
 * Returns [4, 5, 3], [2], [1].
 *
 * Explanation:
 * 1. Removing the leaves [4, 5, 3] would result in this tree:
 *
 *          1
 *         / 
 *        2          
 * 2. Now removing the leaf [2] would result in this tree:
 *
 *          1          
 * 3. Now removing the leaf [1] would result in the empty tree:
 *
 *          []         
 * Returns [4, 5, 3], [2], [1].
 * 
 * https://leetcode.com/problems/find-leaves-of-binary-tree/description/
 */
public class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        height(root, result);
        return result;
    }

    private int height(TreeNode node, List<List<Integer>> result) {
        if (null == node) {
            return -1;
        }

        int level = 1 + Math.max(height(node.left, result), height(node.right, result));
        if (result.size() < level + 1) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        return level;
    }
}