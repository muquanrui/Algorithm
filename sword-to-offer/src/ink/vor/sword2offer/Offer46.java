package ink.vor.sword2offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author muquanrui
 * @date 2022/4/25 08:44
 */
public class Offer46 {
    public int translateNum(int num) {
        int i1 = num % 10;
        num /= 10;
        int dp1 = 1;
        int dp2 = 1;
        while (num > 0) {
            int i2 = num % 10;
            int temp = dp2;
            if ((i2 == 1) || (i2 == 2 && i1 <= 5)) {
                dp2 = dp2 + dp1;
            }
            i1 = i2;
            dp1 = temp;
            num /= 10;
        }
        return dp2;
    }
}
