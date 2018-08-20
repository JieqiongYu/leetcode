/**
 * [LeetCode][170]Two Sum III
 *
 * Design and implement a TwoSum class.
 * It should support the following operations: add and find.
 * 
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 * 
 * For example,
 * add(1); add(3); add(5);
 * find(4) -> true
 * find(7) -> false
 * 
 * https://leetcode.com/problems/two-sum-iii-data-structure-design/description/
 */
class TwoSum {
    
    List<Integer> list;
    Map<Integer, Integer> map;

    /** Initialize your data structure here. */
    public TwoSum() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
        if (map.get(number) == 1) {
            list.add(number);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int i = 0; i < list.size(); i++) {
            int num1 = list.get(i);
            int num2 = value - num1;
            if (num1 == num2 && map.get(num1) > 1 || num1 != num2 && map.containsKey(num2)) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */