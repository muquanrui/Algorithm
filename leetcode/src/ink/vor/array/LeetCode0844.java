package ink.vor.array;

/**
 * @author muquanrui
 * @date 03/02/2022 12:17
 */
public class LeetCode0844 {
    public boolean backspaceCompare(String s, String t) {
        return getRealString(s).equals(getRealString(t));
    }

    public String getRealString(String s) {
        char[] charS = s.toCharArray();
        int slow = charS[0] == '#' ? -1 : 0;
        for (int fast = 1; fast < charS.length; fast++) {
            if (charS[fast] == '#') {
                slow = slow < 0 ? -1 : slow - 1;
            } else {
                slow++;
                charS[slow] = charS[fast];
            }
        }
        return new String(charS).substring(0, slow + 1);
    }
}
