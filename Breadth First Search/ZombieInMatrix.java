/**
* Given a 2D grid, each cell is either a wall 2, a zombie 1 or
* people 0 (the number zero, one, two).Zombies can turn the nearest
* people(up/down/left/right) into zombies every day, but can not through wall.
* How long will it take to turn all people into zombies?
* Return -1 if can not turn all people into zombies.
*
* Example
* Given a matrix:
*
* 0 1 2 0 0
* 1 0 0 2 1
* 0 1 0 0 0
* return 2
* 
* http://www.lintcode.com/en/problem/zombie-in-matrix/
*/
public class Solution {

    class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int PEOPLE = 0;
    int ZOMBIE = 1;
    int WALL = 2;

    /*
     * @param grid: a 2D integer grid
     * @return: an integer
     */
    public int zombie(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;
        }

        int row = grid.length;
        int col = grid[0].length;

        int[][] moves = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        Queue<Point> queue = new LinkedList<>();

        // get the number of people and put the zombie in the queue
        int people = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == PEOPLE) {
                    people++;
                }
                if (grid[i][j] == ZOMBIE) {
                    queue.offer(new Point(i,j));
                }
            }
        }

        if (people == 0) {
            return 0;
        }

        int days = 0;
        while (!queue.isEmpty()) {
            days++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point zombie = queue.poll();
                for (int[] move : moves) {
                    Point nextPoint = new Point(zombie.x + move[0],
                    zombie.y + move[1]);
                    if (!inBound(nextPoint, grid)) {
                        continue;
                    }
                    people--;
                    if (people == 0) {
                        return days;
                    }
                    queue.offer(nextPoint);
                    grid[nextPoint.x][nextPoint.y] = ZOMBIE;
                }
            }
        }

        return -1;

    }

    private boolean inBound(Point point, int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        return ((point.x >= 0 && point.x < row && point.y >= 0 && point.y < col)
            && (grid[point.x][point.y] == PEOPLE));
    }
}
