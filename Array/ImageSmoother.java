/**
 * Given a 2D integer matrix M representing the gray scale of an image, 
 * you need to design a smoother to make the gray scale of each cell becomes 
 * the average gray scale (rounding down) of all the 8 surrounding cells and itself. 
 * If a cell has less than 8 surrounding cells, then use as many as you can.
 * 
 * Example 1:
 * 
 * Input:
 * [[1,1,1],
 *  [1,0,1],
 *  [1,1,1]]
 * 
 * Output:
 * [[0, 0, 0],
 *  [0, 0, 0],
 *  [0, 0, 0]]
 * 
 * Explanation:
 * For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
 * For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
 * For the point (1,1): floor(8/9) = floor(0.88888889) = 0
 * 
 * Note:
 * The value in the given matrix is in the range of [0, 255].
 * The length and width of the given matrix are in the range of [1, 150].
 * 
 * https://leetcode.com/problems/image-smoother/description/
 */
/**
 * For each cell in the grid, look at the immediate neighbors -- up to 9 of them, 
 * including the original cell.
 * 
 * Then, we will add the sum of the nieghbors into ans[r][c] while recording count, 
 * the number of such neighbors. The final answer is the sum divided by the count. 
 */
class Solution {
    public int[][] imageSmoother(int[][] M) {
        int m = M.length;
        int n = M[0].length;
        
        int[][] result = new int[m][n];
        int[] range = {-1, 0, 1};
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                int count = 0;
                for (int a : range) {
                    for (int b : range) {
                        int row = i + a;
                        int col = j + b;
                        if (row >= 0 && row < m && col >= 0 && col < n) {
                            sum += M[row][col];
                            count++;
                        }
                    }
                }
                result[i][j] = (int) Math.floor((double) sum / count);
            }
        }
        
        return result;
    }
}
/**
 * Complexity Analysis
 *  Time Complexity: O(N), where N is the number of pixels in our image. We iterate over every pixel. 
 *  Space Complexity: O(N), the size of our answer. 
 */