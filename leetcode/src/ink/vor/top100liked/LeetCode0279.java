package ink.vor.top100liked;

/**
 * @author muquanrui
 * @date 30/12/2021 16:58
 */
public class LeetCode0279 {
    public int leastNum;
    public int numSquares(int n) {
        leastNum = n;
        recursiveAdd(n, 1);
        return leastNum;
    }
    public void recursiveAdd(int n, int level) {
        if (level >= leastNum) {
            return;
        }
        int maxSquare = (int) Math.floor(Math.sqrt(n));
        for (int i = maxSquare; i > 0; i--) {
            if (n - i * i == 0) {
                leastNum = Math.min(leastNum, level);
            } else {
                recursiveAdd(n - i * i, level + 1);
            }
        }
    }
}
