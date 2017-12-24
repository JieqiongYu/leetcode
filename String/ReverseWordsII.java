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
