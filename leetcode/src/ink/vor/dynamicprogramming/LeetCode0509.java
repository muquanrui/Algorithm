package ink.vor.dynamicprogramming;

/**
 * @author muquanrui
 * @date 14/03/2022 21:46
 */
public class LeetCode0509 {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int fn2 = 0;
        int fn1 = 1;
        int fn = 0;
        for (int i = 2; i <= n; i++) {
            fn = fn2 + fn1;
            fn2 = fn1;
            fn1 = fn;
        }
        return fn;
     }
}
