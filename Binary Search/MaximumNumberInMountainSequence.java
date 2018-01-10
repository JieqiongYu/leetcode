/**
 * Given a mountain sequence of n integers which increase firstly and then decrease, 
 * find the mountain top.
 * 
 * Example
 * Given nums = [1, 2, 4, 8, 6, 3] return 8
 * Given nums = [10, 9, 8, 7], return 10
 * 
 * http://www.lintcode.com/en/problem/maximum-number-in-mountain-sequence/
 */
public class Solution {
    /*
     * @param nums: a mountain sequence which increase firstly and then decrease
     * @return: then mountain top
     */
    public int mountainSequence(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[mid-1]) {
                end = mid;
            } else if (nums[mid] < nums[mid+1]) {
                start = mid;
            } else {
                return nums[mid];
            }
        } 
        
        if (nums[start] < nums[end]) {
            return nums[end];
        } else {
            return nums[start];
        }
    }
}