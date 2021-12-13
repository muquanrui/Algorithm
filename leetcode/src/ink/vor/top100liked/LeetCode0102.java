package ink.vor.top100liked;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author muquanrui
 * @date 13/12/2021 16:33
 */
public class LeetCode0102 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        List<List<Integer>> resList = levelOrder(root);
        System.out.println(Arrays.toString(resList.toArray()));
    }

    public static HashMap<Integer, List<Integer>> levelMap;
    public static List<List<Integer>> levelOrder(TreeNode root) {
        levelMap = new HashMap<>();
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        recursiveLevel(root, 1);
        ArrayList<Integer> keyList= new ArrayList<>(levelMap.keySet());
        Collections.sort(keyList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1>o2?1:-1;
            }
        });
        for (int i: keyList) {
            resList.add(levelMap.get(i));
        }
        return resList;
    }

    public static void recursiveLevel(TreeNode node, int level) {
        if (levelMap.get(level) == null) {
            List<Integer> tempList = new ArrayList<>();
            tempList.add(node.val);
            levelMap.put(level, tempList);
        } else {
            levelMap.get(level).add(node.val);
        }
        if (node.left != null) {
            recursiveLevel(node.left, level + 1);
        }
        if (node.right != null) {
            recursiveLevel(node.right, level + 1);
        }
    }
}
