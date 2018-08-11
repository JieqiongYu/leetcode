/**
* [LeetCode][253] Meeting Rooms II
* 
* Given an array of meeting time intervals consisting of start and end times 
* [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
*
* Example 1:
* Input: [[0, 30],[5, 10],[15, 20]]
* Output: 2
*
* Example 2:
* Input: [[7,10],[2,4]]
* Output: 1
* 
* https://leetcode.com/problems/meeting-rooms-ii/description/
*/
/**
* 算法描述
* 1. 将所有Meeting按开始时间进行升序排序
* 2. 创建一个最小堆来维护结束时间最短的Meeting（此处的Meeting有可能是merge之后的），
* 因为最快结束的Meeting才有可能跟start时间晚的Meeting进行merge（也就是使用同一间Meeting Room）
* 3. 返回最小堆里item的个数就是最少需要的会议室数量
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
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        
        Arrays.sort(intervals, new Comparator<Interval>(){
           public int compare(Interval i1, Interval i2) {
               return i1.start - i2.start;
           } 
        });
        
        PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
           public int compare(Interval i1, Interval i2) {
               return i1.end - i2.end;
           } 
        });
        
        heap.offer(intervals[0]);
        
        for (int i = 1; i < intervals.length; i++) {
            Interval interval = heap.poll();
            if (intervals[i].start >= interval.end) {
                interval.end = intervals[i].end;
            } else {
                heap.offer(intervals[i]);
            }
            heap.offer(interval);
        }
        
        return heap.size();
    }
}
/**
* Time Complexity: O(nlogn)
* Space Complexity: O(n) 
*/