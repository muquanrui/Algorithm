package ink.vor.greedy;

/**
 * @author muquanrui
 * @date 10/03/2022 21:09
 */
public class LeetCode0860 {
    public boolean lemonadeChange(int[] bills) {
        int count5 = 0;
        int count10 = 0;
        for (int i : bills) {
            if (i == 5) {
                count5++;
            } else if (i == 10) {
                count5--;
                count10++;
            } else {
                if (count10 > 0) {
                    count10--;
                    count5--;
                } else {
                    count5 -= 3;
                }
            }
            if (count5 < 0) {
                return false;
            }
        }
        return true;
    }
}
