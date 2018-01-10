/**
 * Given an integer array, find the top k largest numbers in it.
 * 
 * Example
 * Given [3,10,1000,-99,4,100] and k = 3.
 * Return [1000, 100, 10].
 * 
 * http://www.lintcode.com/en/problem/top-k-largest-numbers/
 */
public class Solution {
    /*
     * @param nums: an integer array
     * @param k: An integer
     * @return: the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            } 
        });
        
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        int[] result = new int[k];
        for (int i = 0;i < k; i++) {
            result[k-1-i] = pq.poll();
        }
        
        return result;
    }
}