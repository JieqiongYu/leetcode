/**
 * [LeetCode][50]Pow(x, n)
 * 
 * Implement pow(x, n).
 *
 * Example 1:
 * Input: 2.00000, 10
 * Output: 1024.00000
 *
 * Example 2:
 * Input: 2.10000, 3
 * Output: 9.26100
 * 
 * https://leetcode.com/problems/powx-n/description/
 */
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (n < 0) {
            x = 1 / x;
            N = -N;
        }
        
        double ans = 1;
        double currentProduct = x;
        for (long i = N; i > 0; i /= 2) {
            if (i % 2 == 1) {
                ans = ans * currentProduct;
            }
            currentProduct = currentProduct * currentProduct;
        }
        
        return ans;
    }
}
/**
 * Time Complexity: O(log(n))
 * Space Complexity: O(1)
 */