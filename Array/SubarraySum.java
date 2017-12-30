/**
* Given an integer array, find a subarray where the sum of numbers is zero.
* Your code should return the index of the first number and the index of the
* last number.
*
* Notice
* There is at least one subarray that it's sum equals to zero.
*
* Example
* Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].
*
* http://www.lintcode.com/en/problem/subarray-sum/
*/
public class Solution {
    /*
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> subarraySum(int[] nums) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            if (map.containsKey(sum)) {
                result.add(map.get(sum) + 1);
                result.add(i);
                return result;
            }

            map.put(sum, i);
        }

        return result;
    }
}
