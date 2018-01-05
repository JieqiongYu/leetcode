/**
* On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
*
* Once you pay the cost, you can either climb one or two steps.
* You need to find minimum cost to reach the top of the floor,
* and you can either start from the step with index 0, or the step with index 1.
*
* Example 1:
* Input: cost = [10, 15, 20]
* Output: 15
* Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
*
* Example 2:
* Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
* Output: 6
* Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
*
* Note:
* cost will have a length in the range [2, 1000].
* Every cost[i] will be an integer in the range [0, 999].
*
* https://leetcode.com/problems/min-cost-climbing-stairs/description/
*/
/**
* 首先创建dp数组，找出约束条件，统计2种登上台阶的方式所需要的花费的最小值。
* 存入dp数组，即dp[i] = min(cost[i-2] + dp[i-2], cost[i-1] + dp[i-1])
* 最后一个dp[n]就是所求的最短花费。
*/
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i-2] + cost[i-2], dp[i-1] + cost[i-1]);
        }
        return dp[cost.length];
    }
}
