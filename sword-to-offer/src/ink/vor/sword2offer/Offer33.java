package ink.vor.sword2offer;

/**
 * @author muquanrui
 * @date 2022/4/23 17:51
 */
public class Offer33 {
    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder, postorder.length - 1, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean verifyPostorder(int[] postorder, int root, int leftSide, int lowerBound, int uppderBound) {
        if (root < leftSide) {
            return true;
        }
        if (postorder[root] < lowerBound || postorder[root] > uppderBound) {
            return false;
        }
        int rightRoot = root - 1;
        int leftRoot = root - 1;
        while (leftRoot >= leftSide && postorder[leftRoot] > postorder[root]) {
            leftRoot--;
        }
        return verifyPostorder(postorder, rightRoot, leftRoot + 1, postorder[root], uppderBound)
                && verifyPostorder(postorder, leftRoot, leftSide, lowerBound, postorder[root]);
    }
}
