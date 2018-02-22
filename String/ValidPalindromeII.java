/**
 * [LeetCode][680]Valid Palindrome II
 * 
 * Given a non-empty string s, you may delete at most one character. 
 * Judge whether you can make it a palindrome.
 * 
 * Example 1:
 * Input: "aba"
 * Output: True
 * 
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * 
 * Note:
 * The string will only contain lowercase characters a-z. 
 * The maximum length of the string is 50000.
 * 
 * https://leetcode.com/problems/valid-palindrome-ii/description/
 */
/**
 * 解题思路：
 * 允许删除一个字符，那么当遇到不匹配的时候，我们到底是删除左边的字符，还是右边的字符呢，
 * 我们的做法是两种情况都要算一遍，只要有一种能返回true，那么结果就返回true。
 * 我们可以写一个子函数来判断字符串中的某一个范围内的子字符串是否为回文串，参见代码如下：
 */
class Solution {
    public boolean validPalindrome(String s) {
        int head = 0;
        int tail = s.length() - 1;
        
        while (head < tail) {
            if (s.charAt(head) != s.charAt(tail)) {
                return isValid(s, head, tail - 1) || isValid(s, head + 1, tail);
            }
            head++;
            tail--;
        }
        
        return true;
    }
    
    public boolean isValid(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}