package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/7/22 13:21
 */
public class Offer62 {
    public int lastRemaining(int n, int m) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (m + ans) % i;
        }
        return ans;
    }
}
