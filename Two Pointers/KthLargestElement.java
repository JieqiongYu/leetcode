/**
* Find the kth largest element in an unsorted array.
* Note that it is the kth largest element in the sorted order, not the kth distinct element.
*
* For example,
* Given [3,2,1,5,6,4] and k = 2, return 5.
*
* Note:
* You may assume k is always valid, 1 ≤ k ≤ array's length.
*
* https://leetcode.com/problems/kth-largest-element-in-an-array/description/
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }

        int left = start;
        int right = end;
        int pivot = nums[(start + end) / 2];

        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                left++;
            }
            while (left <= right && nums[right] < pivot) {
                right--;
            }

            if (left <= right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }

        if (left <= k && left <= end) {
            return quickSelect(nums, left, end, k);
        } else if (right >= k && right >= start) {
            return quickSelect(nums, start, right, k);
        } else {
            return nums[k];
        }
    }
}
