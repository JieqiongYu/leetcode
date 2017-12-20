/**
* Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
* An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
* You may assume all four edges of the grid are all surrounded by water.
*
* Example 1:
* 11110
* 11010
* 11000
* 00000
* Answer: 1
*
* Example 2:
* 11000
* 11000
* 00100
* 00011
* Answer: 3
*
* https://leetcode.com/problems/number-of-islands/description/
*/
class Solution {

    private class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;

        int island = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    markByBFS(grid, i, j);
                    island++;
                }
            }
        }

        return island;
    }

    private void markByBFS(char[][] grid, int x, int y) {
        int[][] moves = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x,y));
        grid[x][y] = '0';

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int[] move : moves) {
                Point newPoint = new Point(point.x + move[0], point.y + move[1]);
                if (!inBound(grid, newPoint)) {
                    continue;
                }
                if (grid[newPoint.x][newPoint.y] == '1') {
                    queue.offer(newPoint);
                    grid[newPoint.x][newPoint.y] = '0';
                }
            }
        }
    }

    private boolean inBound(char[][] grid, Point point) {
        int row = grid.length;
        int col = grid[0].length;

        return point.x >= 0 && point.y >= 0 && point.x < row && point.y < col;
    }
}
