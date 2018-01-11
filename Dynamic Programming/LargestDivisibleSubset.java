/**
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) 
 * of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
 * 
 * If there are multiple solutions, return any subset is fine.
 * 
 * Example 1:
 * nums: [1,2,3]
 * Result: [1,2] (of course, [1,3] will also be ok)
 * 
 * Example 2:
 * nums: [1,2,4,8]
 * Result: [1,2,4,8]
 * 
 * https://leetcode.com/problems/largest-divisible-subset/description/
 */
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        
        Arrays.sort(nums);
        // dp -> count
        int[] dp = new int[nums.length];
        int[] index = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            index[i] = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    index[i] = j;
                }
            }
        }
        
        int maxCount = 0;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxCount < dp[i]) {
                maxCount = dp[i];
                maxIndex = i;
            }
        }
        
        result.add(nums[maxIndex]);
        
        while (maxIndex != index[maxIndex]) {
            maxIndex = index[maxIndex];
            result.add(nums[maxIndex]);
        }
        
        Collections.reverse(result);
        
        return result;
    }
}