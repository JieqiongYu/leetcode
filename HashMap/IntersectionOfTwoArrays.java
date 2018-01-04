/**
* Given two arrays, write a function to compute their intersection.
*
* Example:
* Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
*
* Note:
* Each element in the result must be unique.
* The result can be in any order.
*
* https://leetcode.com/problems/intersection-of-two-arrays/description/
*/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        if (nums1 == null || nums1.length == 0
            || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }

        Set<Integer> set = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                resultSet.add(nums2[i]);
            }
        }

        int index = 0;
        int[] result = new int[resultSet.size()];
        for (Integer num : resultSet) {
            result[index++] = num;
        }

        return result;
    }
}
