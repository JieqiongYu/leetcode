/**
* Given an array of integers, remove the duplicate numbers in it.
*
* You should:
* 1. Do it in place in the array.
* 2. Move the unique numbers to the front of the array.
* 3. Return the total number of the unique numbers.
*
* Notice
* You don't need to keep the original order of the integers.
*
* Example
* Given nums = [1,3,1,4,4,2], you should:
*
* Move duplicate integers to the tail of nums => nums = [1,3,4,2,?,?].
* Return the number of unique integers in nums => 4.
* Actually we don't care about what you place in ?,
* we only care about the part which has no duplicate integers.
* 
* http://www.lintcode.com/en/problem/remove-duplicate-numbers-in-array/
*/
public class Solution {
    /*
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int deduplication(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                nums[++index] = nums[i];
            }
        }

        return index + 1;
    }
}
