package ink.vor.top101;

/**
 * @author muquanrui
 * @date 2022/4/20 05:19
 */
public class BM97 {
    public int[] solve (int n, int m, int[] a) {
        m %= n;
        if (m == 0) {
            return a;
        }
        int start = 0;
        int cur = 0;
        int lastVal = a[start];
        for (int i = 0; i < n; i++) {
            cur = (cur + m) % n;
            lastVal ^= a[cur];
            a[cur] ^= lastVal;
            lastVal ^= a[cur];
            if (cur == start) {
                start++;
                cur = start;
                lastVal = a[start];
            }
        }
        return a;
    }
}
