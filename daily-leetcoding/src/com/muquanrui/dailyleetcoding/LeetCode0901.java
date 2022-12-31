package com.muquanrui.dailyleetcoding;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/10/21 14:42
 */

public class LeetCode0901 {
    class StockSpanner {
        List<Integer> priceList;
        List<Integer> spannerList;
        public StockSpanner() {
            priceList = new ArrayList<>();
            spannerList = new ArrayList<>();
        }

        public int next(int price) {
            priceList.add(price);
            int i = spannerList.size() - 1;
            int sum = 1;
            while (i >= 0 && priceList.get(i) <= price) {
                int spanner = spannerList.get(i);
                sum += spanner;
                i -= spanner;
            }
            spannerList.add(sum);
            return sum;
        }
    }
}
