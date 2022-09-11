package ink.vor.onceagain;

/**
 * @author muquanrui
 * @date 2022/6/14 16:09
 */

/**
 * https://leetcode.cn/problems/compare-version-numbers/
 * 字符串
 */
public class LeetCode0165 {
    public int compareVersion(String version1, String version2) {
        int p1 = 0;
        int p2 = 0;
        while (p1 < version1.length() || p2 < version2.length()) {
            while (p1 < version1.length() && version1.charAt(p1) == '0') {
                p1++;
            }
            while (p2 < version2.length() && version2.charAt(p2) == '0') {
                p2++;
            }
            int start1 = p1;
            int start2 = p2;
            while (p1 < version1.length() && version1.charAt(p1) != '.') {
                p1++;
            }
            while (p2 < version2.length() && version2.charAt(p2) != '.') {
                p2++;
            }
            int v1 = start1 < p1 ? Integer.parseInt(version1.substring(start1, p1)) : 0;
            int v2 = start2 < p2 ? Integer.parseInt(version2.substring(start2, p2)) : 0;
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
            p1++;
            p2++;
        }
        return 0;
    }
}
