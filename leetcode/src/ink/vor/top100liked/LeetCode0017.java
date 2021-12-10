package ink.vor.top100liked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author muquanrui
 * @date 30/11/2021 15:24
 */
public class LeetCode0017 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(letterCombinations("").toArray()));
    }

    public static List<String> letterCombinations(String digits) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            list.add(map.get(Character.getNumericValue(digits.charAt(i))));
        }
        List<String> res = new ArrayList<>();
        if (list.size() == 0) {
            return res;
        }
        res.add("");
        while (list.size() > 0) {
            String alphaStr = list.remove(0);
            int count = res.size();
            while (count > 0) {
                String temp = res.remove(0);
                for (int i = 0; i < alphaStr.length(); i++) {
                    res.add(temp + alphaStr.charAt(i));
                }
                count--;
            }
        }
        return res;
    }
}
