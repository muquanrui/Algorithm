package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/7/22 11:54
 */
public class Offer65 {
    public int add(int a, int b) {
        int sum = a ^ b;
        int carry = (a & b) << 1;
        while (carry != 0) {
            a = sum;
            b = carry;
            sum = a ^ b;
            carry = (a & b) << 1;
        }
        return sum;
    }
}
