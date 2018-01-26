/**
 * https://leetcode.com/problems/binary-tree-vertical-order-traversal/description/
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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Integer> qCol = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        qCol.offer(0);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int col = qCol.poll();
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<Integer>(Arrays.asList(node.val)));
            } else {
                map.get(col).add(node.val);
            }
            
            if (node.left != null) {
                queue.offer(node.left);
                qCol.offer(col - 1);
            }
            
            if (node.right != null) {
                queue.offer(node.right);
                qCol.offer(col + 1);
            }
        }
        
        for (int n : map.keySet()) {
            result.add(map.get(n));
        }
        
        return result;
    }
}