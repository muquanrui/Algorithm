package ink.vor.top101;

/**
 * @author muquanrui
 * @date 2022/4/13 17:13
 */
public class BM51 {
    public int MoreThanHalfNum_Solution(int [] array) {
        int major = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (major == array[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                major = array[i];
                count = 1;
            }
        }
        return major;
    }
}
