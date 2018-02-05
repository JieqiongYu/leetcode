/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
 * which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, 
 * is it possible for you to finish all courses?
 * 
 * For example:
 * 2, [[1,0]]
 * There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0. So it is possible.
 * 
 * 2 , [[1,0],[0,1]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0, 
 * and to take course 0 you should also have finished course 1. So it is impossible.
 * 
 * Note:
 * The input prerequisites is a graph represented by a list of edges, 
 * not adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 * click to show more hints.
 * 
 * Hints:
 * This problem is equivalent to finding if a cycle exists in a directed graph. 
 * If a cycle exists, no topological ordering exists and therefore it will be impossible 
 * to take all courses.
 * Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining 
 * the basic concepts of Topological Sort.
 * Topological sort could also be done via BFS.
 * 
 * https://leetcode.com/problems/course-schedule/description/
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List[] edges = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        Queue queue = new LinkedList();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int count = 0;
        while (!queue.isEmpty()) {
            int course = (int) queue.poll();
            count++;
            int n = edges[course].size();
            for (int i = 0; i < n; i++) {
                int prerequisite = (int) edges[course].get(i);
                degree[prerequisite]--;
                if (degree[prerequisite] == 0) {
                    queue.offer(prerequisite);
                }
            }
        }
        
        return count == numCourses;
    }
}