package ink.vor.sword2offer;

/**
 * @author muquanrui
 * @date 2022/4/28 18:04
 */
public class Offer64 {
    public int sumNums(int n) {
        boolean flag = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
