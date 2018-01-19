/**
 * Given a positive integer n, find the least number of perfect square numbers 
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; 
 * given n = 13, return 2 because 13 = 4 + 9.
 * 
 * https://leetcode.com/problems/perfect-squares/description/
 */
/**
 * 思路
 * 如果一个数x可以表示为一个任意数a加上一个平方数bｘb，也就是x=a+bｘb，
 * 那么能组成这个数x最少的平方数个数，就是能组成a最少的平方数个数加上1
 * （因为b*b已经是平方数了）。
 * 
 */
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        // 将所有非平方数的结果置最大，保证之后比较的时候不被选中
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        // 将所有平方数的结果置1
        for (int i = 0; i * i <= n; i++) {
            dp[i * i] = 1;
        }
        
        // 从小到大找任意数a
        for (int a = 0; a <= n; a++) {
            // 从小到大招平方数b x b
            for (int b = 0; a + b * b <= n; b++) {
                // 因为a + b*b 可能本身就是平方数，所以我们要取两个中较小的
                dp[a + b * b] = Math.min(dp[a + b * b], dp[a] + 1);
            }
        }
        
        return dp[n];
    }
}