/**
* Given some points and a point origin in two dimensional space,
* find k points out of the some points which are nearest to origin.
* Return these points sorted by distance, if they are same with distance,
* sorted by x-axis, otherwise sorted by y-axis.
*
* Example
* Given points = [[4,6],[4,7],[4,4],[2,5],[1,1]], origin = [0, 0], k = 3
* return [[1,1],[2,5],[4,4]]
* 
* http://www.lintcode.com/en/problem/k-closest-points/
*/
 /**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /*
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<Point>(k, new Comparator<Point>() {
           public int compare(Point a, Point b) {
               int diff = getDistance(b, origin) - getDistance(a, origin);
               if (diff == 0) {
                   diff = b.x - a.x;
               }
               if (diff == 0) {
                   diff = b.y - a.y;
               }
               return diff;
           }
        });

        for (int i = 0; i < points.length; i++) {
            pq.offer(points[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        k = pq.size();
        Point[] result = new Point[k];

        while (!pq.isEmpty()) {
            result[--k] = pq.poll();
        }

        return result;
    }

    private int getDistance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }
}
