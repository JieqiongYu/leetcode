/**
 * [LintCode][839] Merge Two Sorted Interval Lists. 
 * 
 * Merge two sorted (ascending) lists of interval and return it as a new sorted list. 
 * The new sorted list should be made by splicing together the intervals of the two lists 
 * and sorted in ascending order.
 * 
 * Notice
 * The intervals in the given list do not overlap.
 * The intervals in different lists may overlap.
 * 
 * Example
 * Given list1 = [(1,2),(3,4)] and list2 = [(2,3),(5,6)], return [(1,4),(5,6)].
 * 
 * http://www.lintcode.com/en/problem/merge-two-sorted-interval-lists/
 */
public class Solution {
    /**
     * @param list1: one of the given list
     * @param list2: another list
     * @return: the new sorted list of interval
     */
    public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        // write your code here
        List<Interval> result = new ArrayList<>();
        
        if ((list1 == null || list1.size() == 0) && (list2 == null || list2.size() == 0)) {
            return result;
        }
        
        if (list1 == null || list1.size() == 0) {
            return list2;
        }
        
        if (list2 == null || list2.size() == 0) {
            return list1;
        }
         
        list1.addAll(list2);
        Collections.sort(list1, new IntervalComparator());
        Interval previous = list1.get(0);
        for (int i = 1; i < list1.size(); i++) {
            Interval current = list1.get(i);
            if (previous.end >= current.start) {
                Interval merged = new Interval(previous.start, Math.max(previous.end, current.end));
                previous = merged;
            } else {
                result.add(previous);
                previous = current;
            }
        }
        
        result.add(previous);
        return result;
        
    }
    
    class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }
}
