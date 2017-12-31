/**
* Given a knight in a chessboard (a binary matrix with 0 as empty and 1 as barrier)
* with a source position, find the shortest path to a destination position,
* return the length of the route.
* Return -1 if knight can not reached.
*
* Notice
* source and destination must be empty.
* Knight can not enter the barrier.
*
* Clarification
* If the knight is at (x, y), he can get to the following positions in one step:
*
* (x + 1, y + 2)
* (x + 1, y - 2)
* (x - 1, y + 2)
* (x - 1, y - 2)
* (x + 2, y + 1)
* (x + 2, y - 1)
* (x - 2, y + 1)
* (x - 2, y - 1)
*
* Example
* [[0,0,0],
*  [0,0,0],
*  [0,0,0]]
* source = [2, 0] destination = [2, 2] return 2
*
* [[0,1,0],
*  [0,0,0],
*  [0,0,0]]
* source = [2, 0] destination = [2, 2] return 6
*
* [[0,1,0],
* [0,0,1],
* [0,0,0]]
* source = [2, 0] destination = [2, 2] return -1
*
* http://www.lintcode.com/en/problem/knight-shortest-path/
*/
/**
 * Definition for a point.
 * public class Point {
 *     publoc int x, y;
 *     public Point() { x = 0; y = 0; }
 *     public Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /*
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;
        }

        int[][] moves = {{1,2}, {1,-2}, {-1,2}, {-1,-2}, {2,1}, {2,-1}, {-2,1}, {-2,-1}};

        int m = grid.length;
        int n = grid[0].length;

        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                if (point.x == destination.x && point.y == destination.y) {
                    return steps;
                }
                for (int[] move : moves) {
                    Point nextPoint = new Point(point.x + move[0], point.y + move[1]);
                    if (!inBound(nextPoint, grid)) {
                        continue;
                    }
                    queue.offer(nextPoint);
                    // mark the next point as not accessible
                    grid[nextPoint.x][nextPoint.y] = true;
                }
            }
            steps++;
        }

        return -1;
    }

    private boolean inBound(Point point, boolean[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        return ((point.x >= 0 && point.y >= 0 && point.x < m && point.y < n)
            && (grid[point.x][point.y] == false));
    }
}
