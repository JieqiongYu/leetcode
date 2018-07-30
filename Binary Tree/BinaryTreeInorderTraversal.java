/**
* [LeetCode 94] Binary Tree Inorder Traversal
* 
* Given a binary tree, return the inorder traversal of its nodes' values. 
* 
* Example
* Input: [1,null,2,3]
*   1
*    \
*     2
*    /
*   3
* Output: [1,3,2]
* Follow up: Recursive solution is trivial, could you do it iteratively?
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
/**
Inorder:
Left Root Right
 */
// Non-Recursion (Stack)
public class Solution {
    /*
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curt = root;
        while (curt != null || !stack.isEmpty()) {
            while (curt != null) {
                stack.push(curt);
                curt = curt.left;
            }
            curt = stack.pop();
            inorder.add(curt.val);
            curt = curt.right;
        }

        return inorder;
    }
}
