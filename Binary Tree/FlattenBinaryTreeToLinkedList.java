/**
* Given a binary tree, flatten it to a linked list in-place.
*
* For example,
* Given
*
*          1
*        / \
*       2   5
*      / \   \
*     3   4   6
*
* The flattened tree should look like:
*
*   1
*    \
*     2
*      \
*       3
*        \
*         4
*          \
*           5
*            \
*             6
*
* https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }

            // connect
            node.left = null;
            if (stack.empty()) {
                node.right = null;
            } else {
                node.right = stack.peek();
            }
        }
    }
}
