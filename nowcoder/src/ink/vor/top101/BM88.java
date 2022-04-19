package ink.vor.top101;

/**
 * @author muquanrui
 * @date 2022/4/19 22:42
 */
public class BM88 {
    public boolean judge (String str) {

        int l = 0;
        int r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l++) != str.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}
