/**
 * [LeetCode][350]Intersection of Two Arrays II
 * 
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * 
 * Note:
 * Each element in the result should appear as many times as it shows in 
 * both arrays.
 * The result can be in any order.
 * 
 * Follow up:
 * What if the given array is already sorted? How would you optimize your 
 * algorithm?
 * What if nums1's size is small compared to nums2's size? 
 * Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited
 * such that you cannot load all elements into the memory at once?
 * 
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
 */
/**
 * Using HashMap to create the mapping between the characters in nums1 and 
 * the count of their appearances, and then traverse nums2.
 * If the count of the character in hashmap is more than 0, add it to the 
 * result, and reduce the count in hashmap by 1.
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
            if (map.containsKey(num) && map.get(num) > 0) {
                resultMap.put(num, resultMap.getOrDefault(num, 0) + 1);
                map.put(num, map.get(num) - 1);
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