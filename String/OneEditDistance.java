/**
 * Given two strings S and T, determine if they are both one edit distance apart.
 * 
 * https://leetcode.com/problems/one-edit-distance/description/
 */
/**
 * 解题思路：
 * 三种情况：
 *  1. 两个字符串的长度之差大于1，那么直接返回False
 *  2. 两个字符串的长度之差等于1，那么长的那个字符串去掉一个字符，剩下的应该和短的字符串相同
 *  3. 两个字符串的长度之差等于0，那么两个字符串对应位置的字符只能有一处不同。
 */
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        if (m > n) {
            return isOneEditDistance(t, s);
        }
        
        if (n - m > 1) {
            return false;
        }
        
        int i = 0; 
        int shift = n - m;
        
        while (i < m && s.charAt(i) == t.charAt(i)) {
            i++;
        }
        
        if (i == m) {
            return shift > 0;
        }
        
        if (shift == 0) {
            i++;
        }
        
        while (i < m && s.charAt(i) == t.charAt(i + shift)) {
            i++;
        }
        
        return i == m;
    }
}