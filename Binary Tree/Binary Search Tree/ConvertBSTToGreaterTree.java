/**
* Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the
* original BST is changed to the original key plus sum of all keys greater
* than the original key in BST.
*
* Example:
*
* Input: The root of a Binary Search Tree like this:
*               5
*             /   \
*           2     13
*
* Output: The root of a Greater Tree like this:
*              18
*             /   \
*           20     13
*
* https://leetcode.com/problems/convert-bst-to-greater-tree/description/
*/
/**
* 仔细观察题目中的例子可以发现，2变成了20，而20是所有结点之和，因为2是最小结点值，
* 要加上其他所有结点值，所以肯定就是所有结点值之和。5变成了18，是通过20减去2得来的，
* 而13还是13，是由20减去7得来的，而7是2和5之和。
* 不用先求出的所有的结点值之和，而是巧妙的将中序遍历左根右的顺序逆过来，
* 变成右根左的顺序
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

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.right != null) {
            dfs(root.right);
        }

        root.val = sum+= root.val;

        if (root.left != null) {
            dfs(root.left);
        }
    }
}
