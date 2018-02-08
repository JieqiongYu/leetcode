/**
 * [LeetCode][447]Number of Boomerangs
 * 
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is 
 * a tuple of points (i, j, k) such that the distance between i and j equals the 
 * distance between i and k (the order of the tuple matters).
 * 
 * Find the number of boomerangs. You may assume that n will be at most 500 and 
 * coordinates of points are all in the range [-10000, 10000] (inclusive).
 * 
 * Example:
 * Input: [[0,0],[1,0],[2,0]]
 * Output: 2
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 * 
 * https://leetcode.com/problems/number-of-boomerangs/
 */
/**
 * 解题思路：
 * 道题定义了一种类似回旋镖形状的三元组结构，要求第一个点和第二个点之间的距离跟第一个点
 * 和第三个点之间的距离相等。现在给了我们n个点，让我们找出回旋镖的个数。那么我们想，
 * 如果我们有一个点a，还有两个点b和c，如果ab和ac之间的距离相等，那么就有两种排列方法abc和acb；
 * 如果有三个点b，c，d都分别和a之间的距离相等，那么有六种排列方法，abc, acb, acd, adc, abd, adb，
 * 那么是怎么算出来的呢，很简单，如果有n个点和a距离相等，那么排列方式为n(n-1)，
 * 这属于最简单的排列组合问题了，我大天朝中学生都会做的。那么我们问题就变成了遍历所有点，
 * 让每个点都做一次点a，然后遍历其他所有点，统计和a距离相等的点有多少个，
 * 然后分别带入n(n-1)计算结果并累加到res中，只有当n大于等于2时，res值才会真正增加，
 * 参见代码如下：
 */
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if (points == null) {
            return 0;
        }
        
        int answer = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int distance = getDistance(points[i], points[j]);
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }
            
            for (int count : map.values()) {
                answer += count * (count - 1);
            }
        }
        
        return answer;
    }
    
    public int getDistance(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}