/**
 * Given a sorted integer array where the range of elements are in the inclusive 
 * range [lower, upper], return its missing ranges.
 * 
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, 
 * return ["2", "4->49", "51->74", "76->99"].
 * 
 * https://leetcode.com/problems/missing-ranges/description/
 */
/**
 * Solution
 * Compare the gap between two neighbor elements and output its range, 
 * simple as that right? This seems deceptively easy, except there are 
 * multiple edge cases to consider, such as the first and last element, 
 * which does not have previous and next element respectively. Also, 
 * what happens when the given array is empty? We should output the range 
 * "0->99"
 * 
 * As it turns out, if we could add two "artificial" numbers -1 before the 
 * first element and 100 after the last element, we could avoid all the above 
 * pesky cases. 
 * 
 */
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        long previous = (long) lower - 1;
        for (int i = 0; i <= nums.length; i++) {
            long current = (i == nums.length) ? (long) upper + 1 : (long) nums[i];
            if (current - previous >= 2) {
                result.add(getRange(previous + 1, current - 1));
            }
            previous = current;   
        }
        return result;
    }
    
    public String getRange(long from, long to) {
        return (from == to) ? String.valueOf(from) : from + "->" + to;
    }
}