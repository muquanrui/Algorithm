package ink.vor.top101;

/**
 * @author muquanrui
 * @date 2022/4/15 16:39
 */
public class BM63 {
    public int jumpFloor(int target) {
        int curdash2 = 1;
        int curdash1 = 1;
        int cur = 1;
        for (int i = 1; i < target; i++) {
            cur = curdash2 + curdash1;
            curdash2 = curdash1;
            curdash1 = cur;
        }
        return cur;
    }
}
