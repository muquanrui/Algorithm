package ink.vor.notquiteac;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/7/18 22:04
 */
public class Offer46 {
    public int translateNum(int num) {
        List<Integer> dp = new ArrayList<>();
        dp.add(1);
        dp.add(1);
        int last = num % 10;
        num /= 10;
        while (num > 0) {
            int cur = num % 10;
            num /= 10;
            if (cur != 0 && cur * 10 + last <= 25) {
                dp.add(dp.get(dp.size() - 1) + dp.get(dp.size() - 2));
            } else {
                dp.add(dp.get(dp.size() - 1));
            }
            last = cur;
        }
        return dp.get(dp.size() - 1);
    }
}
