/**
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not. 
 * However, flowers cannot be planted in adjacent plots - they would compete for water and both 
 * would die.
 * 
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means
 * not empty), and a number n, return if n new flowers can be planted in it without violating the
 * no-adjacent-flowers rule.
 * 
 * Example 1:
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: True
 * 
 * Example 2:
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: False
 * 
 * Note:
 * The input array won't violate no-adjacent-flowers rule.
 * The input array size is in the range of [1, 20000].
 * n is a non-negative integer which won't exceed the input array size.
 * 
 * https://leetcode.com/problems/can-place-flowers/description/
 */
/**
 * Solution
 * 
 * Appraoch #1 Single Scan 
 * 
 * The solution is very simple. We can find out the extra maximum number of flowers, count, that can
 * be planted for the given flowerbed arrangement. To do so, we can traverse over all the elements
 * of the flowerbed and find out those elements which are 0 (implying an empty position). For every
 * such element, we check if its both adjacent positions are also empty. If so, we can plant a
 * flower at the current position without violating the no-adjacent-flower-rule. For the first and
 * last elements, we need not check the previous and the next adjacent positions respectively. 
 * 
 * If the count obtained is greater than or equal to n, the required number of flowers to be
 * planted, we can plant n flowers in the empty spaces, otherwise not.
 * 
 * Approach #2 Optimized 
 * 
 * Instead of finding the maximum value of count that can be obtained, as done in the last appraoch
 * we can stop the process of checking the positions for planting the flowers as soon as count
 * becomes equal to n. Doing this leads to an optimization of the first approach. If count never
 * becomes equal to n, n flowers can't be planted at the empty positions. 
 * 
 */
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0;
        int count = 0;
        
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0) && (i == flowerbed.length - 1 || flowerbed[i+1] == 0)) {
                flowerbed[i++] = 1;
                count++;
            }
            
            if (count >= n) {
                return true;
            }
            
            i++;
        }
        
        return false;
    }
}
/**
 * 
 * Complexity Analysis 
 * 	* Time complexity: O(n). A single scan of the flowerbed array of size n is done. 
 * 	* Space complexity: O(1). Constant extra space is used. 
 * 
 */