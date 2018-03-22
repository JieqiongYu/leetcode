/**
 * [LeetCode][658] Find K Closest Elements. 
 * 
 * Given a sorted array, two integers k and x, find the k closest elements to x in the array. 
 * The result should also be sorted in ascending order. 
 * If there is a tie, the smaller elements are always preferred.
 * 
 * Example 1:
 * Input: [1,2,3,4,5], k=4, x=3
 * Output: [1,2,3,4]
 * 
 * Example 2:
 * nput: [1,2,3,4,5], k=4, x=-1
 * Output: [1,2,3,4]
 * 
 * Note:
 *  * The value k is positive and will always be smaller than the length of the sorted array.
 *  * Length of the given array is positive and will not exceed 104
 *  * Absolute value of elements in the array and x will not exceed 104
 * 
 * https://leetcode.com/problems/find-k-closest-elements/description/
 */
/**
 * Solution:
 * The original array has been sorted: 
 *      1) It's a hint for binary search solution.
 *      2) We need take advantage of it.
 * 
 * 1) If the target x is less or equal than the first element in the sorted array, 
 * the first k elements are the result. 
 * 2) Similarly, if the target is more or equal than the last element in the sorted array, 
 * the last k elements are the result. 
 * 3) Otherwise, we can use binary search to find the index of the element, which is 
 * equal (when this list has x) or a little bit larger than x (when this list does not have it). 
 * Then set low to its left k-1 position, and high to the right k - 1 position of this index as 
 * a start. 
 * Then desired k numbers must in this range [index - k - 1, index + k - 1]. So we can shrink 
 * this range to get the result using the following rules. 
 *      If low reaches the lowest index 0 or the low element is closer to x than the high element, 
 *      decrease the high index. 
 *      If high reaches to the highest index arr.size() - 1 or it is nearer to x than the low element, 
 *      increase the low index. 
 *      The looping ends when there are exactly k elements in [low, high], the subList of which is the result. 
 */
public class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<Integer>();
        }
        List<Integer> original = new ArrayList<>();
        for (int num : arr) {
            original.add(num);
        }

        int candidate = findClosestElement(arr, x);

        if (candidate == 0) {
            return original.subList(0, k);
        } else if (candidate == arr.length - 1) {
            return original.subList(arr.length - k, arr.length);
        } else {
            int index = candidate;
            int low = Math.max(0, index - k - 1);
            int high = Math.min(arr.length - 1, index + k -1);

            while (high - low > k -1 ) {
                if (low < 0 || (x - original.get(low) <= original.get(high) - x)) {
                    high--;
                } else {
                    low++;
                }
            }

            return original.subList(low, high + 1);
        }
    }

    private int findClosestElement(int[] arr, int x) {

        int candidate = findCandidate(arr, x);

        if (candidate == 0) {
            return 0;
        }

        if (candidate == arr.length) {
            return arr.length - 1;
        }

        if (x - arr[candidate - 1] < arr[candidate] - x) {
            return candidate - 1;
        }

        return candidate;
        
    }

    private int findCandidate(int[] arr, int x) {
        int start = 0; 
        int end = arr.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (arr[end] > x) {
            return end;
        }

        if (arr[start] > x) {
            return start;
        }

        return arr.length;
    }
}