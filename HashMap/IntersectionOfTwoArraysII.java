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
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> resultMap = new HashMap<>();
        
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for (int num : nums2) {
            if (map.containsKey(num)) {
                resultMap.put(num, resultMap.getOrDefault(num, 0) + 1);
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0) {
                    map.remove(num);
                }
            }
        }
        
        List<Integer> resultList = new ArrayList<>();
        for (int num : resultMap.keySet()) {
            while (resultMap.get(num) > 0) {
                resultList.add(num);
                resultMap.put(num, resultMap.get(num) - 1);
            }
        }
        
        int[] result = new int[resultList.size()];
        int index = 0;
        for (int num : resultList) {
            result[index++] = num;
        }
        
        return result;
        
    }
}