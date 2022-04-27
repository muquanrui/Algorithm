package ink.vor.sword2offer;

/**
 * @author muquanrui
 * @date 2022/4/27 15:08
 */
public class Offer62 {
    public int lastRemaining(int n, int m) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (res + m) % i;
        }
        return res;
    }
}
