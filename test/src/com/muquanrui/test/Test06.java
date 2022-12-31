package com.muquanrui.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author muquanrui
 * @date 2022/9/16 18:48
 */

public class Test06 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int recordCount = Integer.parseInt(br.readLine());
            List<String[]> list = new ArrayList<>();
            for (int i = 0; i < recordCount; i++) {
                list.add(br.readLine().split(" "));
            }
            int n = Integer.parseInt(br.readLine());
            System.out.println(solve(list, n));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public static int solve(List<String[]> list, int n) throws ParseException {
        Map<Date, Set<String>> map = new HashMap<>();
        DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        for (String[] record : list) {
            String userName = record[0];
            Date date = format.parse(record[1]);
            if (map.containsKey(date)) {
                map.get(date).add(userName);
            } else {
                Set<String> set = new HashSet<>();
                set.add(userName);
                map.put(date, set);
            }
        }
        List<Date> dateList = new ArrayList<>();
        for (Map.Entry<Date, Set<String>> entry : map.entrySet()) {
            dateList.add(entry.getKey());
        }
        Collections.sort(dateList);
        Set<String> userSet = new HashSet<>();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < dateList.size(); i++) {
            int j = i;
            for (; j < dateList.size(); j++) {
                userSet.addAll(map.get(dateList.get(j)));
                if (userSet.size() >= n) {
                    break;
                }
            }
            if (j < dateList.size()) {
                res = Math.min(res, (int) ((dateList.get(j).getTime() - dateList.get(i).getTime()) / (1000 * 3600 * 24)) + 1);
            }
            userSet = new HashSet<>();
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
