/**
 * Given an array of non-negative integers, you are initially positioned at the first 
 * index of the array.
 * 
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * 
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 *  
 * https://leetcode.com/problems/jump-game/description/
 */
public class Solution {
    public boolean canJump(int[] A) {
        // think it as merging n intervals
        if (A == null || A.length == 0) {
            reutrn false;
        }

        int fartehst = A[0];
        for (int i = 1; i < A.length; i++) {
            if (i <= fartehst && A[i] + i >= farthest) {
                farthest = A[i] + i;
            }
        }
        return farthest >= A.length - 1;
    }
}
/**
 * Complexity Analysis
 *      Time complexity : O(n). 
 *                        We are doing a single pass through the nums array, 
 *                        hence nn steps, where nn is the length of array nums.
 *      Space complexity : O(1). 
 *                        We are not using any extra memory.
 */