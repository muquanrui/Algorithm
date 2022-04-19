package ink.vor.top101;

/**
 * @author muquanrui
 * @date 2022/4/19 22:41
 */
public class BM86 {
    public String solve (String s, String t) {
        return addStrings(s, t);
    }

    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        while (index1 >= 0 || index2 >= 0) {
            int i1 = index1 >= 0 ? num1.charAt(index1) - '0' : 0;
            int i2 = index2 >= 0 ? num2.charAt(index2) - '0' : 0;
            int cur = (i1 + i2 + carry) % 10;
            res.append((char)(cur + 48));
            carry = (i1 + i2 + carry) / 10;
            index1--;
            index2--;
        }
        if (carry > 0) {
            res.append((char)(carry + 48));
        }
        return res.reverse().toString();
    }
}
