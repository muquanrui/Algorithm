package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/7/17 17:29
 */
public class Offer33 {
    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder, 0, postorder.length - 1, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    private boolean verifyPostorder(int[] postorder, int left, int right, int max, int min) {
        if (left >= right) {
            return true;
        }
        int i = right;
        for (; i >= left; i--) {
            if (postorder[i] < postorder[right]) {
                break;
            }
            if (postorder[i] >= max || postorder[i] <= min) {
                return false;
            }
        }
        return verifyPostorder(postorder, left, i, postorder[right], min) && verifyPostorder(postorder, i + 1, right - 1, max, postorder[right]);
    }
}
