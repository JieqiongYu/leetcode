/**
* Given a binary tree, find the subtree with maximum average.
* Return the root of the subtree.
*
* Notice
* LintCode will print the subtree which root is your return node.
* It's guaranteed that there is only one subtree with maximum average.
*
* Example
* Given a binary tree:
*
*      1
*    /   \
*  -5     11
*  / \   /  \
* 1   2 4    -2
*
* return the node 11.
* 
* http://www.lintcode.com/en/problem/subtree-with-maximum-average/
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
public class Solution {

    class ResultType {
        int sum;
        int size;
        public ResultType(int sum, int size) {
            this.sum = sum;
            this.size = size;
        }
    }

    TreeNode subtree = null;
    ResultType subtreeResult = null;

    /*
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
    public TreeNode findSubtree2(TreeNode root) {
        dfs(root);
        return subtree;
    }

    private ResultType dfs(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }

        ResultType left = dfs(root.left);
        ResultType right = dfs(root.right);

        ResultType result = new ResultType(left.sum + right.sum + root.val,
            left.size + right.size + 1);

        if (subtree == null || subtreeResult.sum * result.size
            < result.sum * subtreeResult.size) {
            subtree = root;
            subtreeResult = result;
        }

        return result;
    }
}
