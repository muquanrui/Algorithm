package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/7/2 16:32
 */
public class LeetCode0844 {
    public boolean backspaceCompare(String s, String t) {
        return getRealString(s).equals(getRealString(t));
    }
    private String getRealString(String s) {
        char[] str = s.toCharArray();
        int slow = str[0] == '#' ? - 1 : 0;
        for (int fast = 1; fast < str.length; fast++) {
            if (str[fast] == '#') {
                slow = slow == -1 ? -1 : slow - 1;
            } else {
                slow++;
                str[slow] = str[fast];
            }
        }
        return new String(str).substring(0, slow + 1);
    }
}
