class Solution {
    public String customSortString(String S, String T) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), i);
        }
        
        StringBuilder answer = new StringBuilder();
        Map<Character, Integer> subMap = new HashMap<>();
        Map<Character, Integer> duplicateMap = new HashMap<>();

        for (int i = 0; i < T.length(); i++) {
            if (map.containsKey(T.charAt(i))) {
                if (!subMap.containsKey(T.charAt(i))) {
                    subMap.put(T.charAt(i), map.get(T.charAt(i)));
                } else {
                    duplicateMap.put(T.charAt(i), duplicateMap.getOrDefault(T.charAt(i), 0) + 1);
                }
                
            } else {
                answer.append(T.charAt(i));
            }
        }
        
        List<Map.Entry<Character, Integer>> list = new LinkedList<>(subMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
        	public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
        		return (o1.getValue()).compareTo(o2.getValue());
        	}
        });

        for (Map.Entry<Character, Integer> entry : list) {
            while (duplicateMap.containsKey(entry.getKey())) {
                answer.append(entry.getKey());
                duplicateMap.put(entry.getKey(), duplicateMap.get(entry.getKey()) - 1);
                if (duplicateMap.get(entry.getKey()) == 0) {
                    duplicateMap.remove(entry.getKey());
                }
            }
            answer.append(entry.getKey());
            
        }

        return answer.toString();
        
    }
}