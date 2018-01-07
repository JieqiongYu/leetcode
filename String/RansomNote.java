/**
* Given an arbitrary ransom note string and another string containing letters
* from all the magazines, write a function that will return true if the ransom
* note can be constructed from the magazines ; otherwise, it will return false.
*
* Each letter in the magazine string can only be used once in your ransom note.
*
* Note: You may assume that both strings contain only lowercase letters.
*
* canConstruct("a", "b") -> false
* canConstruct("aa", "ab") -> false
* canConstruct("aa", "aab") -> true
* 
* https://leetcode.com/problems/ransom-note/description/
*/
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (map.containsKey(ransomNote.charAt(i))) {
                if (map.get(ransomNote.charAt(i)) == 1) {
                    map.remove(ransomNote.charAt(i));
                } else {
                    map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i)) - 1);
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
