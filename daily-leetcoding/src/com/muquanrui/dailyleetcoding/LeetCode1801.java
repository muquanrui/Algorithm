package com.muquanrui.dailyleetcoding;

import java.util.PriorityQueue;

/**
 * @author muquanrui
 * @date 2023/1/2 13:50
 */

public class LeetCode1801 {
    public static int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> minSellHeap = new PriorityQueue<>((arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        PriorityQueue<int[]> maxBuyHeap = new PriorityQueue<>((arr1, arr2) -> Integer.compare(arr2[0], arr1[0]));

        for (int[] order : orders) {
            int price = order[0];
            int amount = order[1];
            int orderType = order[2];
            if (orderType == 0) {
                while (!minSellHeap.isEmpty() && price >= minSellHeap.peek()[0]) {
                    int[] sellOrder = minSellHeap.poll();
                    int minAmount = Math.min(amount, sellOrder[1]);
                    amount -= minAmount;
                    if ((sellOrder[1] -= minAmount) > 0) {
                        minSellHeap.offer(sellOrder);
                        break;
                    }
                }
                if (amount > 0) {
                    maxBuyHeap.offer(new int[]{price, amount});
                }
            } else {
                while (!maxBuyHeap.isEmpty() && price <= maxBuyHeap.peek()[0]) {
                    int[] buyOrder = maxBuyHeap.poll();
                    int minAmount = Math.min(amount, buyOrder[1]);
                    amount -= minAmount;
                    if ((buyOrder[1] -= minAmount) > 0) {
                        maxBuyHeap.offer(buyOrder);
                        break;
                    }
                }
                if (amount > 0) {
                    minSellHeap.offer(new int[]{price, amount});
                }
            }
        }

        long ans = 0;
        while (!minSellHeap.isEmpty()) {
            ans += minSellHeap.poll()[1];
        }
        while (!maxBuyHeap.isEmpty()) {
            ans += maxBuyHeap.poll()[1];
        }
        int DIVIDE = 1000000007;
        return (int) (ans % DIVIDE);
    }
}
