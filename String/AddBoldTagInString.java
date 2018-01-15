/**
 * Given a string s and a list of strings dict, you need to add a closed pair of 
 * bold tag <b> and </b> to wrap the substrings in s that exist in dict. If two such 
 * substrings overlap, you need to wrap them together by only one pair of closed bold tag. 
 * Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.
 * 
 * Example 1:
 * Input: s = "abcxyz123" dict = ["abc","123"]
 * Output: "<b>abc</b>xyz<b>123</b>"
 * 
 * Example 2:
 * Input: s = "aaabbcc" dict = ["aaa","aab","bc"]
 * Output: "<b>aaabbc</b>c"
 * 
 * Note:
 * The given dict won't contain duplicates, and its length won't exceed 100.
 * All the strings in input have length in range [1, 1000].
 * 
 * https://leetcode.com/problems/add-bold-tag-in-string/description/
 */
class Solution {
    public String addBoldTag(String s, String[] dict) {
        boolean[] mark = new boolean[s.length()];
        
        for (String word : dict) {
            for (int i = 0; i <= s.length() - word.length(); i++) {
                if (s.substring(i, i + word.length()).equals(word)) {
                    for (int j = i; j < i + word.length(); j++) {
                        mark[j] = true;
                    }
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (mark[i] && (i == 0 || !mark[i-1])) {
                sb.append("<b>");
            }
            sb.append(s.charAt(i));
            if (mark[i] && (i == s.length() - 1 || !mark[i+1])) {
                sb.append("</b>");
            }
        }
        
        return sb.toString();
    }
}