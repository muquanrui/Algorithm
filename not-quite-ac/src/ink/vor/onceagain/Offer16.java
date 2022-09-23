package ink.vor.onceagain;

/**
 * @author muquanrui
 * @date 2022/7/11 23:52
 */

/**
 * https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 * 快速幂
 */
public class Offer16 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double res = 1;
        while (N > 0) {
            if ((N & 1) == 1) {
                res *= x;
            }
            x *= x;
            N >>= 1;
        }
        return res;
    }
}
