/**
* Given a string s, partition s such that every substring of the partition is a palindrome.
*
* Return all possible palindrome partitioning of s.
*
* For example, given s = "aab",
*
* Return
*
* [
*   ["aa","b"],
*   ["a","a","b"]
* ]
*
* https://leetcode.com/problems/palindrome-partitioning/description/
*/
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();

        if (s == null || s.length() == 0) {
            return results;
        }

        List<String> palindrome = new ArrayList<>();
        dfs(s, 0, results, palindrome);
        return results;
    }

    private void dfs(String s, int startIndex, List<List<String>> results, List<String> palindrome) {
        if (startIndex == s.length()) {
            results.add(new ArrayList<String>(palindrome));
        }

        for (int i = startIndex; i < s.length(); i++) {
            String substring = s.substring(startIndex, i + 1);
            if (!isPalindrome(substring)) {
                continue;
            }
            palindrome.add(substring);
            dfs(s, i+1, results, palindrome);
            palindrome.remove(palindrome.size() -1);
        }
    }

    private boolean isPalindrome(String str) {
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
