/**
 * Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.
 * 
 * Example 1:
 * Input: [1,0,1,1,0]
 * Output: 4
 * Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
 * After flipping, the maximum number of consecutive 1s is 4.
 * 
 * Note:
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 * 
 * Follow up:
 * What if the input numbers come in one by one as an infinite stream? 
 * In other words, you can't store all numbers coming from the stream as it's 
 * too large to hold in memory. Could you solve it efficiently?
 * 
 * https://leetcode.com/problems/max-consecutive-ones-ii/description/
 */
/**
 * 由于可以允许翻转一次0，所以我们记录两部分内容：zeroLeft表示在需要翻转的0之前的连续1的个数，
 * zeroRight表示在需要翻转的0之后的连续1的个数。一旦我们遇到一个0，就需要更新zeroLeft和zeroRight了。
 * 最终只要记录下来zeroLeft + zeroRight的最大值即可。
 * 注意到这里我们让zeroRight同时包含了需要翻转的0，这样就可以统一处理只有一个0的情况了。
 * 算法的时间复杂度是O(n)，空间复杂度是O(1)。由于我们不需要对原来出现的数据进行重新存取，
 * 所以这个代码也满足了Follow up的要求，可以处理无限长的数据流。
 */
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int left = 0;
        int right = 0;
        
        for (int num : nums) {
            right++;
            if (num != 1) {
                left = right;
                right = 0;
            }
            result = Math.max(result, left + right);
        }
        
        return result;
    }
}