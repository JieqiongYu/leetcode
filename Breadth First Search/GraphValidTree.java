/**
* Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
* write a function to check whether these edges make up a valid tree.
*
* For example:
*
* Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
* Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
*
* Note: you can assume that no duplicate edges will appear in edges.
* Since all edges are undirected, [0, 1] is the same as [1, 0]
* and thus will not appear together in edges.
*
* https://leetcode.com/problems/graph-valid-tree/description/
*/
/**
* 这道题给了我们一个无向图，让我们来判断其是否为一棵树，我们知道如果是树的话，
* 所有的节点必须是连接的，也就是说必须是连通图，而且不能有环，所以我们的焦点就变成了
* 验证是否是连通图和是否含有环。
*/
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n == 0 || edges.length != n - 1) {
            return false;
        }

        Map<Integer, Set<Integer>> graph = initialGraph(n, edges);

        Queue<Integer> queue = new LinkedList<Integer>();
        Set<Integer> set = new HashSet<>();

        queue.offer(0);
        set.add(0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (set.contains(neighbor)) {
                    continue;
                }
                queue.offer(neighbor);
                set.add(neighbor);
            }
        }

        return set.size() == n;
    }

    private Map<Integer, Set<Integer>> initialGraph(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<Integer>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return graph;
    }
}
