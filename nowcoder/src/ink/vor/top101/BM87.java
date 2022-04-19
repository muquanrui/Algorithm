package ink.vor.top101;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/4/19 22:41
 */
public class BM87 {
    public void merge(int A[], int m, int B[], int n) {
        merge2(A, m, B, n);
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] copyNums1 = Arrays.copyOf(nums1, m);
        int index1 = 0;
        int index2 = 0;
        int cur = 0;
        while (index1 < m && index2 < n) {
            if (copyNums1[index1] < nums2[index2]) {
                nums1[cur++] = copyNums1[index1++];
            } else {
                nums1[cur++] = nums2[index2++];
            }
        }
        while (index1 < m) {
            nums1[cur++] = copyNums1[index1++];
        }
        while (index2 < n) {
            nums1[cur++] = nums2[index2++];
        }
    }
}
