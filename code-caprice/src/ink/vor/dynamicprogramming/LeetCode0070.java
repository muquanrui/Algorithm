package ink.vor.dynamicprogramming;

/**
 * @author muquanrui
 * @date 2022/5/11 20:56
 */
public class LeetCode0070 {
    public int climbStairs(int n) {
        int f1 = 1;
        int f2 = 1;
        int fn = 1;
        for (int i = 2; i <= n; i++) {
            fn = f1 + f2;
            f1 = f2;
            f2 = fn;
        }
        return fn;
    }
}
