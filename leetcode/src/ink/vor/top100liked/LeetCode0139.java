package ink.vor.top100liked;

import java.util.*;

/**
 * @author muquanrui
 * @date 16/12/2021 18:50
 */
public class LeetCode0139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dic = new HashSet<>();
        for (String str: wordDict) {
            dic.add(str);
        }
        Map<String, Boolean> map = new HashMap<>();
        return recursiveBreak(s, dic, map);
    }

    public boolean recursiveBreak(String s, Set<String> dic, Map<String, Boolean> map) {
        if (dic.contains(s)) {
            return true;
        }
        if (map.get(s) != null) {
            return map.get(s);
        }
        for (int i = 1; i < s.length(); i++) {
            if (dic.contains(s.substring(i)) && recursiveBreak(s.substring(0, i), dic, map)) {
                map.put(s, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }
}
