/**
* Given a binary tree, find the subtree with minimum sum.
* Return the root of the subtree.
*
* Notice
* LintCode will print the subtree which root is your return node.
* It's guaranteed that there is only one subtree with minimum sum
* and the given binary tree is not an empty tree.
*
* Example
* Given a binary tree:
*      1
*    /   \
*  -5     2
*  / \   /  \
* 0   2 -4  -5
* return the node 1.
* 
* http://www.lintcode.com/en/problem/minimum-subtree/
*/
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
 // Traverse + Divide Conquer: Use global variables to record the Min Values
public class Solution {

    private int min = Integer.MAX_VALUE;
    private TreeNode minSubtree;

    /*
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    public TreeNode findSubtree(TreeNode root) {
        if (root == null) {
            return root;
        }
        dfs(root);
        return minSubtree;
    }

    // 1. return root's sum
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // divide + conquer + merge
        int sum = dfs(root.left) + dfs(root.right) + root.val;
        if (sum < min) {
            min = sum;
            minSubtree = root;
        }

        return sum;
    }
}
