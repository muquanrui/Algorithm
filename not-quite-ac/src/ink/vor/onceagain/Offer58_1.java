package ink.vor.onceagain;

/**
 * @author muquanrui
 * @date 2022/7/22 09:55
 */

/**
 * https://leetcode.cn/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 * 字符串
 */
public class Offer58_1 {
    public String reverseWords(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int left = 0;
        while (left < s.length()) {
            if (s.charAt(left) == ' ') {
                left++;
                continue;
            }
            int right = left + 1;
            while (right < s.length() && s.charAt(right) != ' ') {
                right++;
            }
            StringBuilder tmp = new StringBuilder(s.substring(left, right));
            tmp.reverse();
            sb.append(tmp);
            sb.append(" ");
            left = right + 1;
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.reverse();
        return sb.toString();
    }
}
