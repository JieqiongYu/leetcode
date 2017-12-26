/**
* Given a binary tree, return all root-to-leaf paths.
*
* Example
* Given the following binary tree:
*
*    1
*  /   \
* 2     3
*  \
*   5
*
* All root-to-leaf paths are:
* [
*  "1->2->5",
*  "1->3"
* ]
* 
* https://leetcode.com/problems/binary-tree-paths/description/
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        
        // Exit
        if (root.left == null && root.right == null) {
            result.add(root.val + "");
            return result;
        }
        
        // Divide 
        List<String> leftResult = binaryTreePaths(root.left);
        List<String> rightResult = binaryTreePaths(root.right);
        

        // Merge
        for (String path : leftResult) {
            result.add(root.val + "->" + path);
        }
        
        for (String path : rightResult) {
            result.add(root.val + "->" + path);
        }
        
        return result;
        
    }
}