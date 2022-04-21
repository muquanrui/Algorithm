package ink.vor.sword2offer;

/**
 * @author muquanrui
 * @date 2022/4/21 14:54
 */
public class Offer16 {
    public double myPow(double x, int n) {
        long N = n;
        return n >= 0 ? quickPow(x, N) : 1.0 / quickPow(x, -N);
    }

    private double quickPow(double x, long n) {
        double res = 1.0;
        while (n > 0) {
            if (n % 2 == 1) {
                res *= x;
            }
            x *= x;
            n >>= 1;
        }
        return res;
    }
}
