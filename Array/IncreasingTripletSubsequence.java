/**
 * Given an unsorted array return whether an increasing subsequence of length 3 
 * exists or not in the array.
 * 
 * Formally the function should:
 * Return true if there exists i, j, k 
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * 
 * Your algorithm should run in O(n) time complexity and O(1) space complexity.
 * 
 * Examples:
 * Given [1, 2, 3, 4, 5],
 * return true.
 * 
 * Given [5, 4, 3, 2, 1],
 * return false.
 * 
 * https://leetcode.com/problems/increasing-triplet-subsequence/description/
 */
/**
 * 思路：
 * Iterate through the array, keep track the 2 min(so far) variables, 
 * initialize with Integer.MAX_VALUE to overwrite.
 * If there is any element greater than firstMin and secondMin. 
 * We find answer.
 */
class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        
        for (int num : nums) {
            if (num <= firstMin) {
                firstMin = num;
            } else if (num <= secondMin) {
                secondMin = num;
            } else {
                return true;
            }
        }
        
        return false;
    }
}