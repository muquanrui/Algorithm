package ink.vor.daily;

/**
 * @author muquanrui
 * @date 2022/12/9 13:53
 */

public class LeetCode1780 {
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 != 0 && n % 3 != 1) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
}
