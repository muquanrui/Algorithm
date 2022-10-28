package ink.vor.daily;

import java.util.List;

/**
 * @author muquanrui
 * @date 2022/10/29 01:33
 */

// https://leetcode.cn/problems/count-items-matching-a-rule/
public class LeetCode1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        int key = -1;
        if (ruleKey.equals("type")) {
            key = 0;
        } else if (ruleKey.equals("color")) {
            key = 1;
        } else {
            key = 2;
        }
        for (List<String> item : items) {
            if (item.get(key).equals(ruleValue)) {
                count++;
            }
        }
        return count;
    }
}
