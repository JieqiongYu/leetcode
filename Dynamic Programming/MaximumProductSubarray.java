/**
 * [LeetCode][152]Maximum Product Subarray
 * 
 * Find the contiguous subarray within an array (containing at least one 
 * number) which has the largest product.
 * 
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 * 
 * https://leetcode.com/problems/maximum-product-subarray/description/
 */
class Solution {
    public int maxProduct(int[] nums) {
        // store the result that is the max we have found so far.
        int answer = nums[0];
        
        // imax/imin stores the max/min product of 
        // subarray that ends with the current number A[i]
        for (int i = 1, iMax = answer, iMin = answer; i < nums.length; i++) {
            // multiplied by a negative makes big number smaller, small number bigger
            // so we redefine the extremums by swapping them
            if (nums[i] < 0) {
                int temp = iMax;
                iMax = iMin;
                iMin = temp;
            }
            // max/min product for the current number is either the current number itself
            // or the max/min by the previous number times the current one
            iMax = Math.max(nums[i] * iMax, nums[i]);
            iMin = Math.min(nums[i] * iMin, nums[i]);
            answer = Math.max(answer, iMax);
        }
        return answer;
    }
}
/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */