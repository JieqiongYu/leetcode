/**
 * [LintCode][459]Closest Number in Sorted Array
 * 
 * Given a target number and an integer array A sorted in ascending order,
 * find the index i in A such that A[i] is closest to the given target.
 * 
 * Return -1 if there is no element in the array.
 * 
 * Notice
 * There can be duplicate elements in the array,
 * and we can return any of the indices with same value.
 * 
 * http://www.lintcode.com/en/problem/closest-number-in-sorted-array/
 */
public class Solution {
    public int closestNumber(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int candidate = findCandidate(A, target);

        if (candidate == 0) {
            return 0;
        }

        if (candidate == A.length) {
            return A.length - 1;
        }

        if (target - A[candidate - 1] < A[candidate] - target) {
            return candidate - 1;
        }

        return candidate;
    }

    private int findCandidate(int[] A, int target) {

        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (A[start] > target) {
            return start;
        }

        if (A[end] > target) {
            return end;
        }

        return A.length;
    }
}
