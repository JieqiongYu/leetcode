/**
* Given a digit string, return all possible letter combinations that the number could represent.
* A mapping of digit to letters (just like on the telephone buttons) is given below.
*
* Input:Digit string "23"
* Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*
* https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
*/
class Solution {
  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();

    if (digits == null || digits.length() == 0) {
      return result;
    }

    // construct the map
    Map<Character, char[]> map = new HashMap<>();
    map.put('0', new char[]{});
    map.put('1', new char[]{});
    map.put('2', new char[]{'a', 'b', 'c'});
    map.put('3', new char[]{'d', 'e', 'f'});
    map.put('4', new char[]{'g', 'h', 'i'});
    map.put('5', new char[]{'j', 'k', 'l'});
    map.put('6', new char[]{'m', 'n', 'o'});
    map.put('7', new char[]{'p', 'q', 'r', 's'});
    map.put('8', new char[]{'t', 'u', 'v'});
    map.put('9', new char[]{'w', 'x', 'y', 'z'});

    StringBuilder combination = new StringBuilder();
    dfs(map, digits, combination, result);
    return result;
  }

  private void dfs(Map<Character, char[]> map, String digits, StringBuilder combination, List<String> result) {
    if (digits.length() == combination.length()) {
      result.add(combination.toString());
      return;
    }

    for (char c : map.get(digits.charAt(combination.length()))) {
      combination.append(c);
      dfs(map, digits, combination, result);
      combination.deleteCharAt(combination.length() - 1);
    }
  }
}
