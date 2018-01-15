/**
 * The Hamming distance between two integers is the number of positions at 
 * which the corresponding bits are different.
 * 
 * Given two integers x and y, calculate the Hamming distance.
 * Note: 0 ≤ x, y < 231.
 * Example:
 * Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * 
 * The above arrows point to positions where the corresponding bits are different.
 * 
 * https://leetcode.com/problems/hamming-distance/description/
 */
class Solution {
    public int hammingDistance(int x, int y) {
        String binaryX = Integer.toBinaryString(x);
        String binaryY = Integer.toBinaryString(y);

        int len = Math.max(binaryX.length(), binaryY.length());
        int diff = Math.abs(binaryX.length() - binaryY.length());
        if (binaryX.length() > binaryY.length()) {
            for (int i = 0; i < diff; i++) {
                binaryY = "0" + binaryY;
            }
        } else {
            for (int i = 0; i < diff; i++) {
                binaryX = "0" + binaryX;
            }
        }
  
        int result = 0;
        for (int i = 0; i < len; i++) {  
            if (binaryX.charAt(i) != binaryY.charAt(i)) {                
                result++;
            }
        }
        
        return result;
        
    
        
    }
}