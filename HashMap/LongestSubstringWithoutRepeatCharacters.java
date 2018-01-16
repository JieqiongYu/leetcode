/**
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
        boolean[] exist = new boolean[256];
        int i = 0;
        int maxLen = 0;
        for (int j = 0; j < s.length(); j++) {
            while (exist[s.charAt(j)]) {
                exist[s.charAt(i)] = false;
                i++;
            }
            exist[s.charAt(j)] = true;
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }
}