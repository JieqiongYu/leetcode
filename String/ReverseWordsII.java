/**
* Given an input string, reverse the string word by word.
* A word is defined as a sequence of non-space characters.
*
* The input string does not contain leading or trailing spaces and
* the words are always separated by a single space.
*
* For example,
* Given s = "the sky is blue",
* return "blue is sky the".
*
* Could you do it in-place without allocating extra space?
*
* https://leetcode.com/problems/reverse-words-in-a-string-ii/description/
*/
/**
 * Solution:
 * Let us indicate the ith word by wi and its reversal as wi'. 
 * Notice that when you reverse a word twice, you get back the original word. 
 * That is, (wi)' = wi.
 * 
 * The input string is w1w2...wn. If you reverse the entire string, it becomes 
 * wn'...w2'w1'. Finally, we reverse each individual word and it becomes 
 * wn...w2w1. 
 * Similarly, the same result could be reached by reversing each individual 
 * word first, and then reverse the entire string. 
 */
class Solution {
    public void reverseWords(char[] str) {
        // reverse the whole sentence
        reverse(str, 0, str.length);
        for (int i = 0, j = 0; j <= str.length; j++) {
            // reverse each word
            if (j == str.length || str[j] == ' ') {
                reverse(str, i, j);
                i = j + 1;
            }
        }
    }

    private void reverse(char[] str, int start, int end) {
        for (int i = 0; i < (end - start) / 2; i++) {
            char tmp = str[start + i];
            str[start + i] = str[end - i - 1];
            str[end - i - 1] = tmp;
        }
    }
}
/**
 * Complexity Analysis: 
 *  Time Complexity: O(n).
 *  Space Complexity: O(1). In-place reverse. 
 */