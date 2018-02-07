/**
 * [LeetCode][3]Longest Substring Without Repeating Characters
 * 
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Examples:
 * 
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3.
 * 
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * 
 */
/**
 * 题目意思是在一个字符串中找一个最长的子串（没有重复的字母）
 * 最简单的思路：从左往右扩展子串，维持2个变量i和j来维持一个新的子串，
 * j不断移动，每加入一个新的字符，判断是否有重复的，如果有重复的，移动i，
 * 生成新子串……
 *      len = max(len, j - i + 1)  
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] charMap = new int[256];
        
        int left = 0;
        int right = 0;
        int result = 0;
        
        for (left = 0; left < s.length(); left++) {
            while (right < s.length() && charMap[s.charAt(right)] == 0) {
                charMap[s.charAt(right)] = 1;
                right++;
                result = Math.max(result, right - left);
            } 
            charMap[s.charAt(left)] = 0;
        }
        
        return result;
    }
}