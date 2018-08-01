/**
 * [LeetCode][13]Roman To Integer
 * 
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * https://leetcode.com/problems/roman-to-integer/description/
 */
class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int length = s.length();
        int result = map.get(s.charAt(length - 1));
        
        for (int i = length - 2; i >= 0; i--) {
            if (map.get(s.charAt(i+1)) <= map.get(s.charAt(i))) {
                result += map.get(s.charAt(i));
            } else {
                result -= map.get(s.charAt(i));
            }
        }
        
        return result;
    }
}