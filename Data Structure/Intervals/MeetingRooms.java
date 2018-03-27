/**
 * 
 * [LeetCode][252]Meeting Rooms
 * 
 * Given an array of meeting time intervals consisting of start and end times 
 * [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 * 
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return false.
 * 
 * https://leetcode.com/problems/meeting-rooms/description/
 */
/**
 * Solution:
 *  The idea here is to sort the meetings by starting time. 
 *  Then, go through the meetings one by one and make sure that each meeting 
 *  ends before the next one starts. 
 */
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
           public int compare(Interval i1, Interval i2) {
               return i1.start - i2.start;
           } 
        });
        
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].end > intervals[i+1].start) {
                return false;
            }
        }
        
        return true;
    }
}
/**
 * Time Complexity: O(nlogn). The time complexity is dominated by sorting.
 *                  Once the array has been sorted, only O(n) time is taken 
 *                  to go through the array and determine if there is any overlap.
 * Space complexity: O(1). Since no additional space is allocated. 
 */