/**
 * Design and implement a data structure for a compressed string iterator. 
 * It should support the following operations: next and hasNext.
 * 
 * The given compressed string will be in the form of each letter followed by a positive integer 
 * representing the number of this letter existing in the original uncompressed string.
 * 
 * next() - if the original string still has uncompressed characters, return the next letter; 
 * Otherwise return a white space.
 * hasNext() - Judge whether there is any letter needs to be uncompressed.
 * 
 * Note:
 * Please remember to RESET your class variables declared in StringIterator, 
 * as static/class variables are persisted across multiple test cases. 
 * Please see here for more details.
 * 
 * Example:
 * StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");
 * iterator.next(); // return 'L'
 * iterator.next(); // return 'e'
 * iterator.next(); // return 'e'
 * iterator.next(); // return 't'
 * iterator.next(); // return 'C'
 * iterator.next(); // return 'o'
 * iterator.next(); // return 'd'
 * iterator.hasNext(); // return true
 * iterator.next(); // return 'e'
 * iterator.hasNext(); // return false
 * iterator.next(); // return ' '
 * 
 * https://leetcode.com/problems/design-compressed-string-iterator/description/
 */
/**
 * 解题思路:
 * 将压缩字符串compressedString拆分成字母数组chars和出现次数数组counts。
 */
class StringIterator {
    
    List<Character> chars = new ArrayList<>();
    List<Integer> counts = new ArrayList<>();
    int index = 0;

    public StringIterator(String compressedString) {
        int i = 0; 
        while (i < compressedString.length()) {
            chars.add(compressedString.charAt(i));
            int j = i + 1;
            while (j < compressedString.length() && Character.isDigit(compressedString.charAt(j))) {
                j++;
            }
            counts.add(Integer.parseInt(compressedString.substring(i + 1, j)));
            i = j;
        }
    }
    
    public char next() {
        if (!hasNext()) {
            return ' ';
        }
        
        char result = chars.get(index);
        counts.set(index, counts.get(index) - 1);
        if (counts.get(index) == 0) {
            index++;
        }
        return result;
    }
    
    public boolean hasNext() {
        return index < chars.size();
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */