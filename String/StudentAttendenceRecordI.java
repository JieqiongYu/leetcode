/**
* You are given a string representing an attendance record for a student.
* The record only contains the following three characters:
* 'A' : Absent.
* 'L' : Late.
* 'P' : Present.
* A student could be rewarded if his attendance record doesn't contain
* more than one 'A' (absent) or more than two continuous 'L' (late).
*
* You need to return whether the student could be rewarded according to
* his attendance record.
*
* Example 1:
* Input: "PPALLP"
* Output: True
*
* Example 2:
* Input: "PPALLL"
* Output: False
*
* https://leetcode.com/problems/student-attendance-record-i/description/
*/
/**
* Solution:
* One simple way of solving this problem is to count number of A’s in the string
* and check whether the string LLL is a substring of a given string.
* If number of A’s is less than 2 and LLL is not substring of a given string
* then return true, otherwise return false.
*
* indexOf method can be used to check substring in a string.
* It return the index within this string of the first occurrence of the 
* specified character or -1, if the character does not occur.
*/
class Solution {
    public boolean checkRecord(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                count++;
            }
        }
        return count < 2 && s.indexOf("LLL") < 0;
    }
}
