/**
 * [LeetCode][345]Reverse Vowels of a String.
 * 
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * 
 * Example 1:
 * Given s = "hello", return "holle".
 * 
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 * 
 * Note:
 * The vowels does not include the letter "y".
 * 
 * https://leetcode.com/problems/reverse-vowels-of-a-string/description/
 */
class Solution {
    public String reverseVowels(String s) {
        
        Set<Character> vowelsSet = new HashSet<>();
        vowelsSet.add('a');
        vowelsSet.add('e');
        vowelsSet.add('u');
        vowelsSet.add('i');
        vowelsSet.add('o');
        vowelsSet.add('A');
        vowelsSet.add('E');
        vowelsSet.add('U');
        vowelsSet.add('I');
        vowelsSet.add('O');
        
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (vowelsSet.contains(c)) {
                stack.push(c);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (vowelsSet.contains(c)) {
                sb.append(stack.pop());
            } else {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}