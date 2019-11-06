package com.dean.practice.algorithm.primary;

/*
 * 问题: Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times).
 *
 * 示例:
 * Input: [7,1,5,3,6,4] Output: 7
 * Input: [1,2,3,4,5] Output: 4
 *
 * 分析: 预测第i天的股票价格，如果会比i - 1天低的话，则在第i - 1天售出。如果i - 1天比第i天高时，则在第i - 1天购入。
 * buy = -1表示还没有买入。
 *
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 */

public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = new int[]{2, 1, 4};
        System.out.println("累计赚了" + maxProfit(prices) + "元。");
    }

    private static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;

        int profit = 0, buy = prices[0], size = prices.length;
        System.out.println("购入了第1天的股票，价格:" + prices[0]);
        for (int i = 1; i < size; i++) {
            if (buy != -1 && prices[i] < prices[i - 1]) {
                profit += (prices[i - 1] - buy);
                System.out.println("第" + (i + 1) + "天会降价，赶紧抛售。赚取" + (prices[i - 1] - buy) + "元。");
                buy = -1;
            }

            if (buy == -1 && prices[i] > prices[i - 1]) {
                buy = prices[i - 1];
                System.out.println("购入第" + i + "天的股票，价格:" + prices[i - 1]);
            }

            if (i == size - 1 && buy != -1 && prices[size - 1] > buy) {
                System.out.println("最后一天了，出售手中剩余的股票。赚了" + (prices[size - 1] - buy) + "元。");
                profit += (prices[size - 1] - buy);
            }
        }
        return profit;
    }
}
