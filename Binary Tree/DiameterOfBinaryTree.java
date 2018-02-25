/**
 * 
 * [LeetCode][543]Diameter of Binary Tree
 * 
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
 * Any path can be written as two arrows (in different directions) from some node, 
 * where an arrow is a path that starts at some node and only travels from to child nodes. 
 * 
 * If we knew the maximum length arrows L, R for each child, then the best path 
 * touches L + R. 
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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

	int diameter;

	public int diameterOfBinaryTree(TreeNode root) {
		getDepth(root);
		return diameter;
	}

	private int getDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int left = getDepth(root.left);
		int right = getDepth(root.right);
		int current = left + right;

		if (diameter < current) {
			diameter = current;
		}

		return Math.max(left, right) + 1;
	}
}