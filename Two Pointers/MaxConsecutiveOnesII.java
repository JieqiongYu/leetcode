class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutive = 0;
        int zeroLeft = 0;
        int zeroRight = 0;

        for (int i = 0; i < nums.length; i++) {
            zeroRight++;
            if (nums[i] == 0) {
                zeroLeft = zeroRight;
                zeroRight = 0;
            }
            maxConsecutive = Math.max(maxConsecutive, zeroLeft + zeroRight);
        }
        return maxConsecutive;
    }
}