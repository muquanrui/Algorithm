package com.muquanrui.dailyleetcoding;

import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author muquanrui
 * @date 2022/11/30 16:16
 */

// https://leetcode.cn/problems/maximum-frequency-stack/
public class LeetCode0895 {
}

class FreqStack {

    Map<Integer, Integer> keyFreqMap;
    Map<Integer, LinkedList<Integer>> freqKeyMap;
    int maxFreq;

    public FreqStack() {
        keyFreqMap = new HashMap<>();
        freqKeyMap = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        keyFreqMap.put(val, keyFreqMap.getOrDefault(val, 0) + 1);
        int newFreq = keyFreqMap.get(val);
        if (freqKeyMap.containsKey(newFreq)) {
            freqKeyMap.get(newFreq).addLast(val);
        } else {
            LinkedList<Integer> list = new LinkedList<>();
            list.addLast(val);
            freqKeyMap.put(newFreq, list);
            maxFreq = newFreq;
        }
    }

    public int pop() {
        LinkedList<Integer> list = freqKeyMap.get(maxFreq);
        int val = list.removeLast();
        if (list.isEmpty()) {
            freqKeyMap.remove(maxFreq);
            maxFreq--;
        }
        keyFreqMap.put(val, keyFreqMap.get(val) - 1);
        if (keyFreqMap.get(val) == 0) {
            keyFreqMap.remove(val);
        }
        return val;
    }
}