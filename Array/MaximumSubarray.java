/**
* Find the contiguous subarray within an array (containing at least one number)
* which has the largest sum.
*
* For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
* the contiguous subarray [4,-1,2,1] has the largest sum = 6.
*
* More practice:
* If you have figured out the O(n) solution, try coding another solution using
* the divide and conquer approach, which is more subtle.
*
* https://leetcode.com/problems/maximum-subarray/description/
*/
/**
* 解题思路：
* 从头遍历数组，对于数组中的其中一个元素，它只有两个选择：
* 1. 要么加入之前的数组加和之中（跟别人一组）
* 2. 要么自己单立一个数组（自己单开一组）
* 所以对于这个元素应该如何选择，就看他能对哪个组的贡献大，如果跟别人一组，
* 能让总加和变大，还是跟别人一组好了；如果自己起个头一组，自己的值比之前加和的值还要打，
* 那么还是自己单开一组好了。
* 
*/
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;

        for (int i = 0; i < nums.length; i++) {
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
            maxEndingHere += nums[i];
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}
