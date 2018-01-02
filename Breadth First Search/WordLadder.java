/**
* Given two words (start and end), and a dictionary,
* find the length of shortest transformation sequence from start to end,
* such that:
* 1) Only one letter can be changed at a time
* 2) Each intermediate word must exist in the dictionary
*
* Notice
* 1) Return 0 if there is no such transformation sequence.
* 2) All words have the same length.
* 3) All words contain only lowercase alphabetic characters.
*
* Example
* Given:
* start = "hit"
* end = "cog"
* dict = ["hot","dot","dog","lot","log"]
* As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
* return its length 5.
* 
* http://www.lintcode.com/en/problem/word-ladder/
*/
public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (dict == null || dict.size() == 0) {
            return 0;
        }

        if (start.equals(end)) {
            return 1;
        }

        dict.add(start);
        dict.add(end);

        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.offer(start);
        set.add(start);

        int length = 1;
        while (!queue.isEmpty()) {
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String nextWord : getNextWords(word, dict)) {
                    if (set.contains(nextWord)) {
                        continue;
                    }
                    if (end.equals(nextWord)) {
                        return length;
                    }
                    queue.offer(nextWord);
                    set.add(nextWord);
                }
            }
        }

        return 0;
    }

    private List<String> getNextWords(String word, Set<String> dict) {
        List<String> nextWords = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String nextWord = replace(word, i, c);
                if (dict.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }

        return nextWords;
    }

    private String replace(String word, int index, char c) {
        char[] wordChar = word.toCharArray();
        wordChar[index] = c;
        return new String(wordChar);
    }
}
