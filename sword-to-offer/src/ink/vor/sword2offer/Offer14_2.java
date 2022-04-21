package ink.vor.sword2offer;

/**
 * @author muquanrui
 * @date 2022/4/21 14:54
 */
public class Offer14_2 {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int x = 3;
        int a = n / 3;
        int b = n % 3;
        int mod = 1000000007;
        long res = 1;
        for (int i = 0; i < (b == 1 ? a - 1 : a); i++) {
            res = res * x % mod;
        }
        if (b == 1) {
            res = res * 4 % mod;
        } else if (b == 2) {
            res = res * 2 % mod;
        }
        return (int) res;
    }
}
