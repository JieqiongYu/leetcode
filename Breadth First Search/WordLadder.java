/**
* [LeetCode][127]Word Ladder
*
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
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) {
            return 0;
        }
        
        Set<String> wordSet = new HashSet<>();
        for (String word : wordList) {
            wordSet.add(word);
        }
        
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.offer(beginWord);
        set.add(beginWord);
        
        int length = 1;
        while (!queue.isEmpty()) {
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String nextWord : getNextWords(word, wordSet)) {
                    if (set.contains(nextWord)) {
                        continue;
                    }
                    if (endWord.equals(nextWord)) {
                        return length;
                    }
                    queue.offer(nextWord);
                    set.add(nextWord);
                }
            }
        }
        
        return 0;
    }
    
    private List<String> getNextWords(String word, Set<String> wordSet) {
        List<String> nextWords = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                String nextWord = replace(word, i, c);
                if (wordSet.contains(nextWord)) {
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