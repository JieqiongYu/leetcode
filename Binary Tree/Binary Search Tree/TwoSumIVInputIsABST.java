/**
 * [LeetCode][653]Two Sum IV - Input is a BST.
 * 
 * Given a Binary Search Tree and a target number, 
 * return true if there exist two elements in the BST such that their 
 * sum is equal to the given target.
 * 
 * Example 1:
 * Input: 
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 * 
 * Target = 9
 * Output: True
 * 
 * Example 2:
 * Input: 
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 * 
 * Target = 28
 * Output: False
 * 
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int left = 0;
        int right = list.size() - 1;
        
        while (left < right) {
            if (list.get(left) + list.get(right) == k) {
                return true;
            }
            if (list.get(left) + list.get(right) < k) {
                left++;
            } else {
                right--;
            }
        }
        
        return false;
    }
    
    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
/**
 * Time Complexity: O(n). We need to traverse over the whole tree once to do the 
 *                  inorder traversal. Binary Search for sorted is O(logn)
 * Space Complexity: O(n). The sorted list will contain n elements. 
 */