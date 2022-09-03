package ink.vor.onceagain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author muquanrui
 * @date 2022/6/3 16:15
 */

/**
 * https://leetcode.cn/problems/minimum-window-substring/
 * 字符串，HashMap，滑动窗口
 */
public class LeetCode0076 {
    public String minWindow(String s, String t) {
        // 统计t中的字符及出现次数
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        // 记录结果子串的起始位置和长度
        int[] res = new int[]{-1, -1};
        int minLength = Integer.MAX_VALUE;
        // 记录当前覆盖的字符个数
        int count = 0;
        // 记录当前子串的起始位置
        int start = 0;
        // 记录当前子串的结束位置
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            // map中当前字符对应数量-1
            map.put(ch, map.getOrDefault(ch, 0) - 1);
            // map中当前字符数量>=0证明当前字符是有效字符，count+1
            if (map.get(ch) >= 0) {
                count++;
            }
            // count和t长度相等时找到一个结果，开始移动start
            while (count == t.length()) {
                // 只要当前子串比之前的结果更短，更新结果
                if (end - start < minLength) {
                    minLength = end - start;
                    res[0] = start;
                    res[1] = end;
                }
                // map中start位置字符数量+1
                char chStart = s.charAt(start);
                map.put(chStart, map.get(chStart) + 1);
                // map中start位置字符数量>0证明该字符是有效字符，count-1
                if (map.get(chStart) > 0) {
                    count--;
                }
                // start右移1位
                start++;
            }
        }
        // 注意不存在的时候返回空串
        return minLength == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
