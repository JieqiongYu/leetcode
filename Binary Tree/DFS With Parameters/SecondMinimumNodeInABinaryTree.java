/**
 * Given a non-empty special binary tree consisting of nodes with the non-negative value, 
 * where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, 
 * then this node's value is the smaller value among its two sub-nodes.
 * 
 * Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' 
 * value in the whole tree.
 * 
 * If no such second minimum value exists, output -1 instead.
 * 
 * Example 1:
 * Input: 
 *     2
 *    / \
 *   2   5
 *      / \
 *     5   7
 * 
 * Output: 5
 * Explanation: The smallest value is 2, the second smallest value is 5.
 * 
 * Example 2:
 * Input: 
 *     2
 *    / \
 *   2   2
 * 
 * Output: -1
 * Explanation: The smallest value is 2, but there isn't any second smallest value.
 * 
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/description/
 */
/**
 * Solution
 * 
 * Approach #1 Brute Force
 * 
 * Traverse the tree with a depth-first search, and record every unique value in the tree 
 * using a Set structure uniques. 
 * Then, we'll look through the recorded values for the second minimum. 
 * The first minimum must be root.val.
 * 
 * Approach #2 Ad-Hoc
 * 
 * Let min1 = root.val. When traversing the tree at some node, node, if node.val > min1, 
 * we know all values in the subtree at node are at least node.val, so there cannot be a better candidate 
 * for the second minimum in this subtree. Thus, we do not need to search this subtree.
 * 
 * Also, as we only care about the second minimum ans, we do not need to record any values that are larger 
 * than our current candidate for the second minimum, so unlike Approach #1 we can skip maintaining a Set of 
 * values (uniques) entirely. 
 * 
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
    
    int min1;
    int ans = Integer.MAX_VALUE;
    
    public int findSecondMinimumValue(TreeNode root) {
        min1 = root.val;
        dfs(root);
        return ans < Integer.MAX_VALUE ? ans : -1;
    }
    
    private void dfs(TreeNode root) {
        if (root != null) {
            if (min1 < root.val && root.val < ans) {
                ans = root.val;
            } else if (min1 == root.val) {
                dfs(root.left);
                dfs(root.right);
            }
        }
    }
}
/**
 * 
 * Complexity Analysis
 * 	* Time Complexity: O(N), 
 *                     where N is the total number of nodes in the given tree. 
 *                     We visit each node at most once.
 * 	* Space Complexity: O(N). 
 *                     The information stored in ans and min1 is O(1),
 *                     but our depth-first search may store up to O(h) = O(N) information in the call stack, 
 *                     where h is the height of the tree. 
 */