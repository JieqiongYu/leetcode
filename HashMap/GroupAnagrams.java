/**
 * Given an array of strings, group anagrams together.
 * 
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
 * Return:
 * [
 *  ["ate", "eat","tea"],
 *  ["nat","tan"],
 *  ["bat"]
 * ]
 * 
 * https://leetcode.com/problems/group-anagrams/description/
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String keyStr = String.valueOf(cs);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<String>());
            }
            map.get(keyStr).add(s);
        }
        
        for (List<String> list : map.values()) {
            result.add(list);
        }
        
        return result;
    }
}