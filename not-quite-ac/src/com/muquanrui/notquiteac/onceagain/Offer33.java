package com.muquanrui.notquiteac.onceagain;

/**
 * @author muquanrui
 * @date 2022/7/17 17:29
 */
public class Offer33 {
    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder, 0, postorder.length - 1, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    private boolean verifyPostorder(int[] postorder, int left, int right, int max, int min) {
        if (left > right) {
            return true;
        }
        if (postorder[right] >= max || postorder[right] <= min) {
            return false;
        }
        int smaller = right - 1;
        while (smaller >= left && postorder[smaller] >= postorder[right]) {
            smaller--;
        }
        if (smaller < left) {
            return verifyPostorder(postorder, left, right - 1, max, postorder[right]);
        } else {
            return verifyPostorder(postorder, left, smaller, postorder[right], min) && verifyPostorder(postorder, smaller + 1, right - 1, max, postorder[right]);
        }
    }
}
