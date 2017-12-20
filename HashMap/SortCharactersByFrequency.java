/**
* Given a string, sort it in decreasing order based on the frequency of characters.
*
* Example 1:
* Input: "tree"
* Output: "eert"
* Exaplanation: 'e' appears twice while 'r' and 't' both appear once.
* So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
*
* Example 2:
* Input: "cccaaa"
* Output: "cccaaa"
* Explanation: Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
* Note that "cacaca" is incorrect, as the same characters must be together.
*
* Example 3:
* Input: "Aabb"
* Output: "bbAa";
* Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
* Note that 'A' and 'a' are treated as two different characters.
*
* https://leetcode.com/problems/sort-characters-by-frequency/description/
*/
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort(new Comparator<Map.Entry<Character, Integer>>() {
           public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
               return o2.getValue().compareTo(o1.getValue());
           }
        });

        StringBuffer sb = new StringBuffer();
        for (Map.Entry<Character, Integer> e : list) {
            for (int i = 0; i < e.getValue(); i++) {
                sb.append(e.getKey());
            }
        }

        return sb.toString();
    }
}
