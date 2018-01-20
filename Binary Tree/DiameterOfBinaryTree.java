/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. 
 * The diameter of a binary tree is the length of the longest path between any two 
 * nodes in a tree. This path may or may not pass through the root.
 * 
 * Example:
 * Given a binary tree 
 * 
 *           1
 *          / \
 *         2   3
 *        / \     
 *       4   5    
 * 
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * Note: The length of path between two nodes is represented by the number 
 * of edges between them.
 * 
 * https://leetcode.com/problems/diameter-of-binary-tree/description/
 */
/**
 * 定义一个类变量diameter, 保存最大diameter值。
 * 通过递归计算左右子树的深度来计算根节点的diameter(记为temp)，
 * 通过和类变量diameter进行比较，保存较大值。
 * 在每一次递归结束后，返回左右子树的深度，
 * 将二者相加再加2就是根节点的diameter. 
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
    int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return diameter;
    }
    
    public int getDepth(TreeNode root) {
        if (root == null) {
            return -1;
        }
        
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        int temp = left + right + 2;
        if (diameter < temp) {
            diameter = temp;
        }
        return Math.max(left, right) + 1;
    }
}