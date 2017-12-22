/**
* Given two strings s and t, write a function to determine if t is an anagram of s.
*
* For example,
* s = "anagram", t = "nagaram", return true.
* s = "rat", t = "car", return false.
*
* Note:
* You may assume the string contains only lowercase alphabets.
*
* Follow up:
* What if the inputs contain unicode characters?
* How would you adapt your solution to such case?
*
* https://leetcode.com/problems/valid-anagram/description/
*/
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                if (map.get(c) > 1) {
                    map.put(c, map.get(c) - 1);
                } else {
                    map.remove(c);
                }
            } else {
                return false;
            }
        }

        if (map.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
