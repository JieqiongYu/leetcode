/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of 
 * the matrix in spiral order.
 * 
 * For example,
 * Given the following matrix:
 * 
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 
 * You should return [1,2,3,6,9,8,7,4,5].
 * 
 * https://leetcode.com/problems/spiral-matrix/description/
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }
        
        int rStart = 0;
        int rEnd = matrix.length - 1;
        int cStart = 0;
        int cEnd = matrix[0].length - 1;
        
        while (rStart <= rEnd && cStart <= cEnd) {
            for (int c = cStart; c <= cEnd; c++) {
                result.add(matrix[rStart][c]);
            }
            for (int r = rStart + 1; r <= rEnd; r++) {
                result.add(matrix[r][cEnd]);
            }
            if (rStart < rEnd && cStart < cEnd) {
                for (int c = cEnd - 1; c > cStart; c--) {
                    result.add(matrix[rEnd][c]);
                }
                for (int r = rEnd; r > rStart; r--) {
                    result.add(matrix[r][cStart]);
                }
            }
            rStart++;
            rEnd--;
            cStart++;
            cEnd--;
        }
        
        return result;
    }
}