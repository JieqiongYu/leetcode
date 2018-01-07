/**
* Write a function to find the longest common prefix string amongst
* an array of strings.
*
* https://leetcode.com/problems/longest-common-prefix/
*/
/**
* Solution:
* Method 1: start from the first one, compare prefix with next string, until end;
* Method 2: start from the first char, compare it with all string, and then the second char
* Here use the first method.
*/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 0; i < strs.length; i++) {
            int j = 0;
            while (j < strs[i].length() && j < prefix.length()
                  && strs[i].charAt(j) == prefix.charAt(j)) {
                j++;
            }
            if (j == 0) {
                return "";
            }
            prefix = prefix.substring(0, j);
        }
        return prefix;
    }
}
