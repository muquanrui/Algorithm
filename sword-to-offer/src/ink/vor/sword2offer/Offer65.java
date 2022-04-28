package ink.vor.sword2offer;

/**
 * @author muquanrui
 * @date 2022/4/28 18:04
 */
public class Offer65 {
    public int add(int a, int b) {
        int sum=a^b;
        int carry=(a&b)<<1;
        while(carry!=0){
            a=sum;
            b=carry;
            sum=a^b;
            carry=(a&b)<<1;
        }
        return sum;
    }
}
