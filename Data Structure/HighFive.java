/**
* There are two properties in the node student id and scores,
* to ensure that each student will have at least 5 points,
* find the average of 5 highest scores for each person.
*
* Example
* Given results = [[1,91],[1,92],[2,93],[2,99],[2,98],[2,97],[1,60],[1,58],
* [2,100],[1,61]]
*
* Return
*
* http://www.lintcode.com/en/problem/high-five/
*/
class Solution {
	public Map<Integer, Double> highFive(Record[] results) {
		Map<Integer, Double> answer = new HashMap<>();
		Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

		for (Record record : results) {
			if (!map.containsKey(record.id)) {
				map.put(record.id, new PriorityQueue<Integer>());
			}

			PriorityQueue<Integer> priorityQueue = map.get(record.id);
			if (priorityQueue.size() < 5) {
				priorityQueue.add(record.score);
			} else {
				if (priorityQueue.peek() < record.score) {
					priorityQueue.poll();
					priorityQueue.add(record.score);
				}
			}
		}

		for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
			int studentId = entry.getKey();
			PriorityQueue<Integer> scores = entry.getValue();
			double average = 0;
			for (int i = 0; i < 5; i++) {
				average += scores.poll();
			}
			average /= 5.0;
			answer.put(studentId, average);
		}

		return answer;
	}
}
