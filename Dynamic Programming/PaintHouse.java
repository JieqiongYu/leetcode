/**
 * There are a row of n houses, each house can be painted with one of the three colors: 
 * red, blue or green. The cost of painting each house with a certain color is different. 
 * You have to paint all the houses such that no two adjacent houses have the same color.
 * 
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix. 
 * For example, costs[0][0] is the cost of painting house 0 with color red; 
 * costs[1][2] is the cost of painting house 1 with color green, and so on... 
 * Find the minimum cost to paint all houses.
 * 
 * Note:
 * All costs are positive integers.
 * 
 * https://leetcode.com/problems/paint-house/description/
 */
/**
 * 直到房子i，其最小的涂色开销是直到房子i-1的最小涂色开销，加上房子i本身的涂色开销。
 * 但是房子i的涂色方式需要根据房子i-1的涂色方式来确定，所以我们对房子i-1要记录涂三种颜色分别不同的开销，
 * 这样的房子i在涂色的时候，我们就知道三种颜色各自的最小开销是多少了。我们在原数组上修改，可以做到不用空间。
 */
public class Solution {
    public int minCost(int[][] costs) {
        if (costs != null && costs.length == 0) {
            return 0;
        }
        for (int i = 1; i < costs.length; i++) {
            // 涂第一种颜色的话，上一个房子就不能涂第一种颜色，这样外面要在上一个房子的第二和第三个颜色的
            // 最小开销中找最小的那个加上
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
            // 涂第二或者第三种颜色同理
            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }
        return Math.min(costs[costs.length-1][0], Math.min(costs[costs.length-1][1], costs[costs.length-1][2]));
    }
}
/**
 * Complexity Analysis:
 *      * Time Complexity: O(N)
 *      * Space Complexity: O(1)
 */