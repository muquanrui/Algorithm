package com.muquanrui.dailyleetcoding;

/**
 * @author muquanrui
 * @date 2023/2/13 10:18
 */

public class LeetCode1234 {
    public int balancedString(String s) {
        int[] count = new int[4];
        for (char ch : s.toCharArray()) {
            modifyCount(ch, count, 1);
        }

        if (isEqual(count, s)) {
            return 0;
        }

        int ans = s.length();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            modifyCount(ch, count, -1);
            while (left <= right) {
                if (!isEqual(count, s)) {
                    break;
                }
                ans = Math.min(ans, right - left + 1);
                modifyCount(s.charAt(left), count, 1);
                left++;
            }
        }
        return ans;
    }

    private void modifyCount(char ch, int[] count, int val) {
        switch (ch) {
            case 'Q':
                count[0] += val;
                break;
            case 'W':
                count[1] += val;
                break;
            case 'E':
                count[2] += val;
                break;
            case 'R':
                count[3] += val;
                break;
        }
    }

    private boolean isEqual(int[] count, String s) {
        for (int i : count) {
            if (i > s.length() / 4) {
                return false;
            }
        }
        return true;
    }
}
