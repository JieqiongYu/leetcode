/**
* There are a total of n courses you have to take, labeled from 0 to n - 1.
* Some courses may have prerequisites, for example to take course 0 you have to
* first take course 1, which is expressed as a pair: [0,1].
*
* Given the total number of courses and a list of prerequisite pairs,
* return the ordering of courses you should take to finish all courses.
*
* There may be multiple correct orders, you just need to return one of them.
* If it is impossible to finish all courses, return an empty array.
*
* For example:
* 2, [[1,0]]
* There are a total of 2 courses to take. To take course 1 you should have finished course 0.
* So the correct course order is [0,1]
*
* 4, [[1,0],[2,0],[3,1],[3,2]]
* There are a total of 4 courses to take. To take course 3 you should have finished
* both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
* So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
*
* Note:
* The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
* Read more about how a graph is represented.
* You may assume that there are no duplicate edges in the input prerequisites.
*
* https://leetcode.com/problems/course-schedule-ii/discuss/
*/
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        int[] degree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }

        // get indegeree
        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
            edges.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] order = new int[numCourses];
        int count = 0;

        // start point
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
                order[count++] = i;
            }
        }

        // bfs
        while (!queue.isEmpty()) {
            int prerequisite = queue.poll();
            int size = edges.get(prerequisite).size();
            for (int i = 0; i < size; i++) {
                int course = edges.get(prerequisite).get(i);
                degree[course]--;
                if (degree[course] == 0) {
                    queue.offer(course);
                    order[count++] = course;
                }
            }
        }

        if (count == numCourses) {
            return order;
        }

        return new int[0];
    }
}
