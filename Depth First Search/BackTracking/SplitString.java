/**
 * [LintCode][680] Split String. 
 * 
 * Give a string, you can choose to split the string after one character or two adjacent characters, 
 * and make the string to be composed of only one character or two characters. 
 * Output all possible results.
 * 
 * Example
 * Given the string "123"
 * return [["1","2","3"],["12","3"],["1","23"]]
 * 
 * http://www.lintcode.com/en/problem/split-string/
 */
public class Solution {
    public List<List<String>> splitString(String s) {
        // write your code here
        List<List<String>> results = new ArrayList<>();
        if (s == null) {
            return results;
        }
        
        if (s.length() == 0) {
            results.add(new ArrayList<>());
            return results;
        }
        
        dfs(results, new ArrayList<>(), 0, s);
        return results;
    }
    
    private void dfs(List<List<String>> results, List<String> split, int index, String s) {
        if (index == s.length()) {
            results.add(new ArrayList<>(split));
            return;
        }
        
        for (int i = index; i < index + 2 && i < s.length(); i++) {
            String substring = s.substring(index, i + 1);
            split.add(substring);
            dfs(results, split, i + 1, s);
            split.remove(split.size() - 1);
        }
    }
}