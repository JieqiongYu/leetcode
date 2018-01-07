/**
* Given an integer array, find a subarray with sum closest to zero.
* Return the indexes of the first number and last number.
*
* Example
* Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4].
*
* http://www.lintcode.com/en/problem/subarray-sum-closest/
*/
/**
* 解题思路：
* Prefix Sum: 对于数组[1, 2, 3, 4]，它的Prefix Sum是 [1, 3, 6, 10]
* 分别表示前1个数之和，前2个数之和，前3个数之和，前4个数之和。
* 这个时候如果你想要知道子数组从下标 1到下标 2 的这一段的和 （2+3），就用前3个数之和减去
* 前1个数之和 = PrefixSum[2] - PrefixSum[0]
* 前x个数和具体对应的下标之间存在+-1的问题
* 第x个数的下标是x - 1。反之下标x是第x+1个数
*/
public class Solution {

    class Pair {
        int sum;
        int index;
        public Pair(int sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }

    /*
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {

        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }

        if (nums.length == 1) {
            res[0] = res[1] = 0;
            return res;
        }

        Pair[] sums = new Pair[nums.length+1];
        sums[0] = new Pair(0, 0);
        int prev = 0;
        for (int i = 1; i < sums.length; i++) {
            sums[i] = new Pair(prev + nums[i-1], i);
            prev = sums[i].sum;
        }

        Arrays.sort(sums, new Comparator<Pair>(){
            public int compare(Pair a, Pair b) {
                return a.sum - b.sum;
            }
        });

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < sums.length; i++) {
            if (ans > sums[i].sum - sums[i-1].sum) {
                ans = sums[i].sum - sums[i-1].sum;
                int[] temp = new int[] {sums[i].index - 1, sums[i-1].index - 1};
                Arrays.sort(temp);
                res[0] = temp[0] + 1;
                res[1] = temp[1];
            }
        }

        return res;
    }
}
