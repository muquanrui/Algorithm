package ink.vor.sword2offer;

/**
 * @author muquanrui
 * @date 2022/4/21 14:52
 */
public class Offer10_2 {
    public int numWays(int n) {
        int step_2 = 1;
        int step_1 = 1;
        int step = 1;
        for (int i = 2; i <= n; i++) {
            step = (step_2 + step_1) % 1000000007;
            step_2 = step_1;
            step_1 = step;
        }
        return step;
    }
}
