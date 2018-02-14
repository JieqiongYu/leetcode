/**
 * [LeetCode][339]Nested List Weight Sum
 * 
 * Given a nested list of integers, return the sum of all integers in the list weighted 
 * by their depth.
 * 
 * Each element is either an integer, or a list -- whose elements may also be integers or 
 * other lists.
 * 
 * Example 1:
 * Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)
 * 
 * Example 2:
 * Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at 
 * depth 3; 1 + 4*2 + 6*3 = 27)
 * 
 * https://leetcode.com/problems/nested-list-weight-sum/description/
 */
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }
    
    private int depthSum(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for (NestedInteger n : nestedList) {
            if (n.isInteger()) {
                sum += n.getInteger() * depth;
            } else {
                sum += depthSum(n.getList(), depth + 1);
            }
        }
        return sum;
    }
}
/**
 * Complexity Analysis:
 *      The algorithm takes O(N) time, where N is the total number of nested elements in the input 
 *      list. For example, the list [[[[[1]]]], 2] contains 4 nested lists and 2 nested integers 
 *      (1 and 2), so N = 6.
 *      In terms of space, at most O(D) recursive calls are placed on the stack, where D is the 
 *      maximum level of nesting in the input. For example, D = 2 for the input [[1,1], 2, [1,1]], 
 *      and D = 3 for the input [1, [4, [6]]]. 
 */