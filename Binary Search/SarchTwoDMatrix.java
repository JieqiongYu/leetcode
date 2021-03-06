/**
* Write an efficient algorithm that searches for a value in an m x n matrix.
* This matrix has the following properties:
*
* Integers in each row are sorted from left to right.
* The first integer of each row is greater than the last integer of
* the previous row.
*
* For example,
* Consider the following matrix:
* [
*   [1,   3,  5,  7],
*   [10, 11, 16, 20],
*   [23, 30, 34, 50]
* ]
*
* https://leetcode.com/problems/search-a-2d-matrix/description/
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int start;
        int end;

        // find the col
        start = 0;
        end = row - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (matrix[start][0] == target || matrix[end][0] == target) {
            return true;
        }

        if (matrix[end][0] < target) {
            row = end;
        } else if (matrix[start][0] < target) {
            row = start;
        } else {
            return false;
        }

        // find the row
        start = 0;
        end = col - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (matrix[row][start] == target || matrix[row][end] == target) {
            return true;
        }

        return false;
    }
}
