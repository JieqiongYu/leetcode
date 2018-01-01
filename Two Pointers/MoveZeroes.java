/**
* Given an array nums, write a function to move all 0's to the end of it
* while maintaining the relative order of the non-zero elements.
*
* For example, given nums = [0, 1, 0, 3, 12], after calling your function,
* nums should be [1, 3, 12, 0, 0].
*
* Note:
* You must do this in-place without making a copy of the array.
* Minimize the total number of operations.
* 
* https://leetcode.com/problems/move-zeroes/description/
*/
/**
* 完成本题需要下面两个步骤
* 1）将非0数字依次向前移动
* 2）将后面空出的部分全部补0
*/
class Solution {
    public void moveZeroes(int[] nums) {

        int curt = 0;

        // 将非0数字向前挪
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[curt++] = nums[i];
            }
        }

        // 后面的元素全部补0
        for (int i = curt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
