/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined 
 * between two nodes v and w as the lowest node in T that has both v and w as descendants 
 * (where we allow a node to be a descendant of itself).”
 * 
 *         _______3______
 *        /              \
 *     ___5__          ___1__
 *    /      \        /      \
 *    6      _2       0       8
 *          /  \
 *          7   4
 * 
 *  For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. 
 * Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of 
 * itself according to the LCA definition.
 * 
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        // Exit
        if (root == null || root == node1 || root == node2) {
            return root;
        }

        // Divide
        TreeNode left = lowestCommonAncestor(root.left, node1, node2);
        TreeNode right = lowestCommonAncestor(root.right, node1, node2);

        // Conquer
        if (left != null && right != null) {
            return root;
        }

        if (left != null) {
            return left;
        }

        if (right != null) {
            return right;
        }

        return null;
    }
}