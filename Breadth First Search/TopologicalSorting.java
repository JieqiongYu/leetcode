/**
* Given an directed graph, a topological order of the graph nodes is defined as follow:
*
* For each directed edge A -> B in graph, A must before B in the order list.
* The first node in the order can be any node in the graph with no nodes direct to it.
* Find any topological order for the given graph.
*
* Notice
* You can assume that there is at least one topological order in the graph.
* 
* http://www.lintcode.com/en/problem/topological-sorting
*/

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> order = new ArrayList<>();

        if (graph == null) {
            return order;
        }

        HashMap<DirectedGraphNode, Integer> indegree = getIndegree(graph);

        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode node : graph) {
            if (indegree.get(node) == 0) {
                queue.offer(node);
                order.add(node);
            }
        }

        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            for (DirectedGraphNode neighbor : node.neighbors) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                    order.add(neighbor);
                }
            }
        }

        if (order.size() == graph.size()) {
            return order;
        }

        return null;
    }

    private HashMap<DirectedGraphNode, Integer> getIndegree(ArrayList<DirectedGraphNode> graph) {
        HashMap<DirectedGraphNode, Integer> indegree = new HashMap<>();

        for (DirectedGraphNode node : graph) {
            indegree.put(node, 0);
        }

        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                indegree.put(neighbor, indegree.get(neighbor) + 1);
            }
        }

        return indegree;
    }
}
