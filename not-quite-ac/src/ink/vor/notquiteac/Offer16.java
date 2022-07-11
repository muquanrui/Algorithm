package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/7/11 23:52
 */
public class Offer16 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        long N = n;
        if (n < 0) {
            x = 1 / x;
            N = -N;
        }
        double pow = 1;
        while (N > 0) {
            if ((N & 1) == 1) {
                pow *= x;
            }
            x = x * x;
            N >>= 1;
        }
        return pow;
    }
}
