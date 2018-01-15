/**
 * Given two non-negative integers num1 and num2 represented as strings, 
 * return the product of num1 and num2.
 * 
 * Note:
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * 
 * https://leetcode.com/problems/multiply-strings/description/
 */
class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return null;
        }
        
        int len1 = num1.length();
        int len2 = num2.length();
        int len = len1 + len2;
        int[] nums = new int[len];
        int i, j, carry, product;
        
        for (i = len1 - 1; i >= 0; i--) {
            carry = 0;
            for (j = len2 - 1; j >= 0; j--) {
                product = carry + nums[i+j+1] + Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2.charAt(j));
                nums[i+j+1] = product % 10;
                carry = product / 10;
            }
            nums[i+j+1] = carry;
        }
        
        i = 0;
        while (i < len - 1 && nums[i] == 0) {
            i++;
        }
        
        StringBuilder sb = new StringBuilder();
        while (i < len) {
            sb.append(nums[i++]);
        }
        
        return sb.toString();
    }
}