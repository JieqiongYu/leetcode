/**
 * Equations are given in the format A / B = k, where A and B are variables represented as strings, 
 * and k is a real number (floating point number). Given some queries, return the answers. 
 * If the answer does not exist, return -1.0. 
 * 
 * Example:
 * Given a / b = 2.0, b / c = 3.0. 
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . 
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ]. 
 * 
 * The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries, 
 * where equations.size() == values.size(), and the values are positive. 
 * This represents the equations. Return vector<double>. 
 * 
 * According to the example above: 
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
 * 
 * The input is always valid. You may assume that evaluating the queries will result 
 * in no division by zero and there is no contradiction. 
 * 
 * https://leetcode.com/problems/evaluate-division/description/
 */
class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        
        Map<String, Map<String, Double>> graph = new HashMap<>();
        
        for (int i = 0; i < equations.length; i++) {
            addArc(graph, equations[i][0], equations[i][1], values[i]);
            addArc(graph, equations[i][1], equations[i][0], 1 / values[i]);
        }
        
        double[] answer = new double[queries.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = getValue(graph, queries[i][0], queries[i][1]);
        }
        
        return answer;
    }
    
    public void addArc(Map<String, Map<String, Double>> graph, String vexStart, String vexEnd, double value) {
        Map<String, Double> arcMap;
        if (graph.containsKey(vexStart)) {
            arcMap = graph.get(vexStart);
        } else {
            arcMap = new HashMap<>();
        }
        arcMap.put(vexEnd, value);
        graph.put(vexStart, arcMap);
    }
    
   public double getValue(Map<String, Map<String, Double>> graph, String vexStart, String vexEnd) {
       if (graph.get(vexStart) == null || graph.get(vexEnd) == null) {
           return -1;
       }
       
       Queue<String> queue = new LinkedList<>();
       Map<String, Double> value = new HashMap<>();
       Set<String> set = new HashSet<>();
       
       // init
       queue.offer(vexStart);
       value.put(vexStart, 1d);
       set.add(vexStart);
       
       String currentVex;
       String nextVex;
       while (!queue.isEmpty()) {
           currentVex = queue.poll();
           for (Map.Entry<String, Double> arc : graph.get(currentVex).entrySet()) {
               nextVex = arc.getKey();
               value.put(nextVex, value.get(currentVex) * arc.getValue());
               if (nextVex.equals(vexEnd)) {
                   return value.get(vexEnd);
               } else if (!set.contains(nextVex)) {
                   queue.offer(nextVex);
                   set.add(nextVex);
               }
           }
       }
       
       return -1;
   }
}