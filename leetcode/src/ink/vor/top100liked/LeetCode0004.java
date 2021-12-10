package ink.vor.top100liked;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 26/11/2021 15:09
 */
public class LeetCode0004 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int indexNums1 = 0;
        int indexNums2 = 0;
        int index = -1;
        int mid = (nums1.length + nums2.length) / 2;
        List<Integer> res = new ArrayList<>();

        while (true) {
            while ((index < mid) && ((indexNums2 == nums2.length) || (indexNums1 < nums1.length && nums1[indexNums1] < nums2[indexNums2]))) {
                indexNums1++;
                index++;
                if (index == mid - 1) {
                    res.add(nums1[indexNums1 - 1]);
                }
            }

            if (index == mid) {
                res.add(nums1[indexNums1 - 1]);
                break;
            }

            while ((index < mid) && ((indexNums1 == nums1.length) || (indexNums2 < nums2.length && nums1[indexNums1] >= nums2[indexNums2]))) {
                indexNums2++;
                index++;
                if (index == mid - 1) {
                    res.add(nums2[indexNums2 -1]);
                }
            }

            if (index == mid) {
                res.add(nums2[indexNums2 - 1]);
                break;
            }

        }

        if ((nums1.length + nums2.length) % 2 == 0) {
            return (double) (res.get(0) + res.get(1)) / 2;
        }
        if (res.size() > 1) {
            return res.get(1);
        } else {
            return res.get(0);
        }
    }
}
