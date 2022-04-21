package ink.vor.sword2offer;

/**
 * @author muquanrui
 * @date 2022/4/21 14:52
 */
public class Offer10_1 {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int f0 = 0;
        int f1 = 1;
        int f2 = 1;
        for (int i = 2; i <= n; i++) {
            f2 = (f0 + f1) % 1000000007;
            f0 = f1;
            f1 = f2;
        }
        return f2;
    }
}
