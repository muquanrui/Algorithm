package ink.vor.notquiteac;

import java.util.*;

/**
 * @author muquanrui
 * @date 2022/6/2 12:12
 */

// https://leetcode.cn/problems/group-anagrams/
public class LeetCode0049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> resList = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sortS = new String(arr);
            if (map.containsKey(sortS)) {
                map.get(sortS).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sortS, list);
            }
        }
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            resList.add(entry.getValue());
        }
        return resList;
    }
}
