package com.muquanrui.dailyleetcoding;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author muquanrui
 * @date 2023/2/28 15:33
 */

public class LeetCode2363 {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] item : items1) {
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        }
        for (int[] item : items2) {
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]);
        }
        return map.entrySet().stream()
                .map(integerIntegerEntry -> Arrays.asList(integerIntegerEntry.getKey(), integerIntegerEntry.getValue()))
                .sorted((o1, o2) -> Integer.compare(o1.get(0), o2.get(0)))
                .collect(Collectors.toList());
    }
}
