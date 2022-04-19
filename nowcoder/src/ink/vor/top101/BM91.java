package ink.vor.top101;

/**
 * @author muquanrui
 * @date 2022/4/19 22:45
 */
public class BM91 {
    public String solve (String str) {
        char[] arr = str.toCharArray();
        int l = 0;
        int r = str.length() - 1;
        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
        return new String(arr);
    }
}
