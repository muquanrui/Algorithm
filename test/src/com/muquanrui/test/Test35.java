package com.muquanrui.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/10/31 15:53
 */

public class Test35 {
    public static void main(String[] args) {
        String[] arr1 = new String[]{"A1", "A2", "A3"};
        String[] arr2 = new String[]{"B1", "B2", "B3"};
        solve(arr1, 0, arr2, 0);
        System.out.println(resList);
        System.out.println(resList.size());
    }

    static List<String> resList = new ArrayList<>();
    static StringBuilder str = new StringBuilder();

    private static void solve(String[] arr1, int i1, String[] arr2, int i2) {
        if (i1 == arr1.length && i2 == arr2.length) {
            resList.add(str.toString());
            return;
        }
        if (i1 < arr1.length) {
            str.append(arr1[i1] + " ");
            solve(arr1, i1 + 1, arr2, i2);
            str.delete(str.length() - arr1[i1].length() - 1, str.length());
        }
        if (i2 < arr2.length) {
            str.append(arr2[i2] + " ");
            solve(arr1, i1, arr2, i2 + 1);
            str.delete(str.length() - arr2[i2].length() - 1, str.length());
        }
    }
}
