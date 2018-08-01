/**
* [LeetCode 784] Letter Case Permutation 
* 
* Given a string S, we can transform every letter individually to be lowercase 
* or uppercase to create another string.  
* Return a list of all possible strings we could create.
*
* Examples:
* Input: S = "a1b2"
* Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
*
* Input: S = "3z4"
* Output: ["3z4", "3Z4"]
*
* Input: S = "12345"
* Output: ["12345"]
*
* Note:
* S will be a string with length at most 12.
* S will consist only of letters or digits.
* 
* https://leetcode.com/problems/letter-case-permutation/description/
*/
class Solution {
    public List<String> letterCasePermutation(String S) {
        List<StringBuilder> ans = new ArrayList<>();
        // ans = [""]
        ans.add(new StringBuilder());
        
        for (char c : S.toCharArray()) {
            int size = ans.size();
            if (Character.isLetter(c)) {
                for (int i = 0; i < size; i++) {
                    ans.add(new StringBuilder(ans.get(i)));
                    ans.get(i).append(Character.toLowerCase(c));
                    ans.get(i+size).append(Character.toUpperCase(c));
                }
            } else {
                for (int i = 0; i < size; i++) {
                    ans.get(i).append(c);
                }
            }
        }
        
        List<String> result = new ArrayList<>();
        for (StringBuilder sb : ans) {
            result.add(sb.toString());
        }
        
        return result;
    }
}

/**
* Time Complexity: O(n * 2^l), l is the number of letters in the input string. 
* Space Complexity: O(n * 2^l) 
*/