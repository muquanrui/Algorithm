package ink.vor.top101;

/**
 * @author muquanrui
 * @date 2022/4/15 16:34
 */
public class BM62 {
    public int Fibonacci(int n) {
        int fndash2 = 1;
        int fndash1 = 1;
        int fn = 1;
        for (int i = 2; i < n; i++) {
            fn = fndash2 + fndash1;
            fndash2 = fndash1;
            fndash1 = fn;
        }
        return fn;
    }
}
