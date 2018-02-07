/**
 * [LeetCode][692]Top K Frequent Words
 * 
 * Given a non-empty list of words, return the k most frequent elements.
 * 
 * Your answer should be sorted by frequency from highest to lowest. 
 * If two words have the same frequency, then the word with the lower alphabetical order comes first.
 * 
 * Example 1:
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 * 
 * Example 2:
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 * with the number of occurrence being 4, 3, 2 and 1 respectively.
 * 
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Input words contain only lowercase letters.
 * Follow up:
 * Try to solve it in O(n log k) time and O(n) extra space.
 * 
 * https://leetcode.com/problems/top-k-frequent-words/description/
 */
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue(new Comparator<String>() {
            public int compare(String s1, String s2) {                
                if (map.get(s1).equals(map.get(s2))) {
                    return s2.compareTo(s1);
                } else {
                    return map.get(s1) - map.get(s2);
                }
                
            }
        });

        for (String word : map.keySet()) {
            pq.offer(word);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        Collections.reverse(result);
        return result;
    }
}
/**
 * Time Complexity: 
 *      O(Nlogk), where N is the length of words. 
 *      We count the frequency of each word in O(N) time, 
 *      then we add N words to the heap, each in O(logk) time. 
 *      Finally, we pop from the heap up to kk times. 
 *      As k≤N, this is O(Nlogk) in total.
 * Space Complexity: 
 *      O(N), the space used to store our count.
 */