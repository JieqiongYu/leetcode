/**
 * Given a string which consists of lowercase or uppercase letters, 
 * find the length of the longest palindromes that can be built with those letters.
 * 
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * 
 * Example:
 * Input: "abccccdd"
 * Output: 7
 * 
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 * 
 * https://leetcode.com/problems/longest-palindrome/description/
 */
class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!set.contains(c)) {
                set.add(c);
            } else {
                set.remove(c);
            }
        }
        
        int remove = set.size();
        if (remove > 0) {
            remove -= 1;
        }
        
        return s.length() - remove;
    }
}