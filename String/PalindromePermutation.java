/**
* Given a string, determine if a permutation of the string could form a palindrome.
*
* For example,
* "code" -> False, "aab" -> True, "carerac" -> True.
*
* https://leetcode.com/problems/palindrome-permutation/description/
*/
class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) == 1 ? 0 : 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        int count = 0;
        for (int number : map.values()) {
            if (number == 1) {
                count++;
            }
        }

        return !(count > 1);

    }
}
