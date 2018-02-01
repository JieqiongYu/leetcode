/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
 * (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple 
 * transactions at the same time (ie, you must sell the stock before you buy again).
 * 
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 */
/**
 * Solution:
 * In this case, instead of looking for every peak following a valley, we can simply go on crawling 
 * over the slope and keep on adding the profit obtained from every consecutive transaction. 
 * In the end, we will be using teh peaks and valleys effetively, but we need not track the costs 
 * corresponding to the peaks and valleys along with the maximum profit, 
 * but we can directly keep on adding the difference between the consecutive numbers of the array 
 * if the second number is larger than the first one, and at the total sum we obtain will be the 
 * maximum profit. This approach will simplify the solution. 
 */
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i-1] > 0) {
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }
}