package com.muquanrui.test;

import java.util.*;

/**
 * @author muquanrui
 * @date 2022/10/12 14:29
 */

public class Test26 {
    public static void main(String[] args) {
        System.out.println(showDown("S2 S3 H4 S5 C6 H2 C2 C10"));;
    }

    public static String showDown (String inHand) {
        // write code here
        String[] cards = inHand.split(" ");
        if (cards.length < 5) {
            return "GaoPai";
        }
        Map<Character, List<Integer>> colorMap = new HashMap<>();
        Map<Integer, List<Character>> numMap = new HashMap<>();
        for (String card : cards) {
            char color = card.charAt(0);
            String num = card.substring(1);
            int number = 0;

            if (num.equals("A")) {
                number = 14;
            } else if (num.equals("K")) {
                number = 13;
            } else if (num.equals("Q")) {
                number = 12;
            } else if (num.equals("J")) {
                number = 11;
            } else {
                number = Integer.parseInt(num);
            }

            if (colorMap.containsKey(color)) {
                colorMap.get(color).add(number);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(number);
                colorMap.put(color, list);
            }

            if (numMap.containsKey(number)) {
                numMap.get(number).add(color);
            } else {
                List<Character> list = new ArrayList<>();
                list.add(color);
                numMap.put(number, list);
            }

            if (number == 14) {
                number = 1;
                if (colorMap.containsKey(color)) {
                    colorMap.get(color).add(number);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(number);
                    colorMap.put(color, list);
                }
                if (numMap.containsKey(number)) {
                    numMap.get(number).add(color);
                } else {
                    List<Character> list = new ArrayList<>();
                    list.add(color);
                    numMap.put(number, list);
                }
            }
        }
        String ret = "";
        for (Map.Entry<Character, List<Integer>> entry : colorMap.entrySet()) {
            List<Integer> list = entry.getValue();
            if (list.size() >= 5) {
                Collections.sort(list);
                int count = 1;
                int start = list.get(list.size() - 1);
                for (int i = list.size() - 2; i >= 0; i--) {
                    if (list.get(i) == list.get(i + 1)) {
                        continue;
                    }
                    if (list.get(i) == list.get(i + 1) - 1) {
                        count++;
                    } else {
                        count = 1;
                        start = list.get(i);
                    }
                    if (count == 5) {
                        if (start == 14) {
                            return "HuangJiaTongHuaShun";
                        } else {
                            return "TongHuaShun";
                        }
                    }
                }
                ret = "TongHua";
            }
        }
        boolean flag3Tiao = false;
        boolean flag2Tiao = false;
        int count2Tiao = 0;
        for (Map.Entry<Integer, List<Character>> entry : numMap.entrySet()) {
            List<Character> list = entry.getValue();
            if (list.size() >= 4) {
                return "SiTiao";
            }
            if (list.size() >= 3) {
                flag3Tiao = true;
            } else if (list.size() >= 2) {
                flag2Tiao = true;
                count2Tiao++;
            }
        }
        if (flag3Tiao && flag2Tiao) {
            return "HuLu";
        }
        if (ret.length() > 0) {
            return ret;
        }
        Set<Integer> numSet = numMap.keySet();
        List<Integer> numList = new ArrayList<>();
        for (Integer i : numSet) {
            numList.add(i);
        }
        Collections.sort(numList);
        int count = 1;
        for (int i = numList.size() - 2; i >= 0; i--) {
            if (numList.get(i) == numList.get(i + 1) - 1) {
                count++;
            } else {
                count = 1;
            }
            if (count == 5) {
                return "ShunZi";
            }
        }
        if (flag3Tiao) {
            return "SanTiao";
        }
        if (count2Tiao >= 2) {
            return "LiangDui";
        }
        if (count2Tiao == 1) {
            return "YiDui";
        }
        return "GaoPai";
    }
}
