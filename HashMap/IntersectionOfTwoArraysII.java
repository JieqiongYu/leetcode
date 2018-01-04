/**
* Given two arrays, write a function to compute their intersection.
*
* Example:
* Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
*
* Note:
* Each element in the result should appear as many times as it shows in both arrays.
* The result can be in any order.
*
* Follow up:
* What if the given array is already sorted? How would you optimize your algorithm?
* What if nums1's size is small compared to nums2's size? Which algorithm is better?
* What if elements of nums2 are stored on disk, and the memory is limited
* such that you cannot load all elements into the memory at once?
*
* https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
*/
/**
* 用哈希表来建立nums1中字符和其出现个数之间的映射, 然后遍历nums2数组，
* 如果当前字符在哈希表中的个数大于0，则将此字符加入结果res中，然后哈希表的对应值自减1
*/
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        if (nums1 == null || nums1.length == 0
            || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 1);
            }
        }

        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && (map.get(nums2[i]) > 0)) {
                resultList.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }

        int index = 0;
        int[] result = new int[resultList.size()];
        for (Integer number : resultList) {
            result[index++] = number;
        }

        return result;

    }
}
