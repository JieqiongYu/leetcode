/**
* Clone an undirected graph. Each node in the graph contains a label and
* a list of its neighbors.
*
* OJ's undirected graph serialization: Nodes are labeled uniquely.
*
* We use # as a separator for each node, and , as a separator for node label
* and each neighbor of the node.
* As an example, consider the serialized graph {0,1,2#1,2#2,2}.
*
* The graph has a total of three nodes, and therefore contains
* three parts as separated by #.
*
* First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
* Second node is labeled as 1. Connect node 1 to node 2.
* Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
* Visually, the graph looks like the following:
*
*       1
*      / \
*     /   \
*    0 --- 2
*         / \
*         \_/
*
* https://leetcode.com/problems/clone-graph/description/
*/
class Solution {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return node;
		}

		// use bfs to traverse the graph and get all nodes
		ArrayList<UndirectedGraphNode> nodes = getNodes(node);

		// copy nodes, store the old-new mapping information in a hash map
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		for (UndirectedGraphNode item : nodes) {
			map.put(item, new UndirectedGraphNode(item.label));
		}

		// copy neighbors (edges)
		for (UndirectedGraphNode item : nodes) {
			UndirectedGraphNode newNode = map.get(item);
			for (UndirectedGraphNode neighbor : item.neighbors) {
				UndirectedGraphNode newNeighbor = map.get(neighbor);
				newNode.neighbors.add(newNeighbor);
			}
		}

		return map.get(node);
	}

	private ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		Set<UndirectedGraphNode> set = new HashSet<>();

		queue.offer(node);
		set.add(node);

		while (!queue.isEmpty()) {
			UndirectedGraphNode item = queue.poll();
			for (UndirectedGraphNode neighbor : item.neighbors) {
				if (!set.contains(neighbor)) {
					queue.offer(neighbor);
					set.add(neighbor);
				}
			}
		}

		return new ArrayList<UndirectedGraphNode>(set);
	}
}
