package ink.vor.top100liked;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author muquanrui
 * @date 06/12/2021 17:46
 */
public class LeetCode0049 {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> resList = groupAnagrams(strs);
        for (List l: resList) {
            System.out.println(Arrays.toString(l.toArray()));
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> resList = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] sortChar = strs[i].toCharArray();
            Arrays.sort(sortChar);
            String sortStr = new String(sortChar);
            if (map.get(sortStr) == null) {
                List<String> tempList = new ArrayList<>();
                tempList.add(strs[i]);
                map.put(sortStr, tempList);
            } else {
                map.get(sortStr).add(strs[i]);
            }
        }

        for (List list: map.values()) {
            resList.add(list);
        }

        return resList;
    }
}
