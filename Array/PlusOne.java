/**
 * Given a non-negative integer represented as a non-empty array of digits, 
 * plus one to the integer.
 * 
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * The digits are stored such that the most significant digit is at the head of the list.
 * 
 * https://leetcode.com/problems/plus-one/description/
 */
/**
 * When all digits are 9, we did something slightly strange. 
 * We append the digit 0 and modify the most significant digit to 1. 
 * Some of you might ask why not insert 1 to the front of list? 
 * Assume that the list is implemented as an ArrayList, appending 
 * an element is far more efficient than inserting to the
 * front, because all elements have to be shifted one place to the right otherwise. 
 */
class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}