package ink.vor.sword2offer;

/**
 * @author muquanrui
 * @date 2022/4/24 15:05
 */
public class Offer43 {
    public int countDigitOne(int n) {
        long pow = 1;
        int ans = 0;
        while (pow <= n) {
            ans += n / (pow * 10) * pow + Math.min(Math.max(n % (pow * 10) - pow + 1, 0), pow);
            pow *= 10;
        }
        return ans;
    }
}
