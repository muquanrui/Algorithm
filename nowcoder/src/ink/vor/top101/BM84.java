package ink.vor.top101;

/**
 * @author muquanrui
 * @date 2022/4/19 22:40
 */
public class BM84 {
    public String longestCommonPrefix (String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder prefix = new StringBuilder(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            int j = 0;
            for (; j < str.length(); j++) {
                if (j >= prefix.length() || prefix.charAt(j) != str.charAt(j))
                    break;
            }
            if (j < prefix.length()) {
                prefix.delete(j, prefix.length());
            }
        }
        return prefix.toString();
    }
}
