/**
 * [LeetCode][415]Add Strings
 * 
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * 
 * Note:
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * 
 * https://leetcode.com/problems/add-strings/description/
 */
class Solution {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        
        if (len1 == 0 || len2 == 0) {
            return len1 == 0 ? num2 : num1;
        }
        
        int sum = 0;
        int carry = 0;
        int i = 0;
        
        StringBuilder sb = new StringBuilder();
        
        while (i < Math.max(len1, len2) || carry != 0) {
            sum = (i > len1 - 1 ? 0 : num1.charAt(len1 - 1 - i) - '0')
                + (i > len2 - 1 ? 0 : num2.charAt(len2 - 1 - i) - '0')
                + carry;
            sb.insert(0, sum % 10 + "");
            carry = sum / 10;
            i++;
        }
        
        return sb.toString();
    }
}