package ink.vor.top100liked;

/**
 * @author muquanrui
 * @date 09/01/2022 11:38
 */
public class LeetCode0647 {
    public int countSubstrings(String s) {
        int res = s.length();
        for (int i = 0; i < s.length(); i++) {
            int left = i - 1;
            int right = i + 1;
            while (left > -1 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                res++;
                left--;
                right++;
            }
            left = i;
            right = i + 1;
            while (left > -1 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                res++;
                left--;
                right++;
            }
        }
        return res;
    }
}
