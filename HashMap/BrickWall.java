/**
* [LeetCode][554] Brick Wall
* 
* There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. 
* The bricks have the same height but different width. You want to draw a vertical line from the top to 
* the bottom and cross the least bricks.
*
* The brick wall is represented by a list of rows. Each row is a list of integers representing the width of 
* each brick in this row from left to right.
*
* If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out 
* how to draw the line to cross the least bricks and return the number of crossed bricks.
*
* You cannot draw a line just along one of the two vertical edges of the wall, 
* in which case the line will obviously cross no bricks.
*
* https://leetcode.com/problems/brick-wall/description/ 
*/
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> row : wall) {
            int sum = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                sum += row.get(i);
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                } else {
                    map.put(sum, 1);
                }
            }
        }
        
        int result = wall.size();
        for (int key : map.keySet()) {
            result = Math.min(result, wall.size() - map.get(key));
        }
        
        return result;
    }
}
/**
* Time Complexity: O(n). n is the total number of bricks in a wall.
* Space Complexity: O(m). map will contain atmost m entries, where m refers to the width of the wall.  
*/