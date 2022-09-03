package ink.vor.onceagain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/6/3 16:38
 */

/**
 * https://leetcode.cn/problems/combinations/
 * 回溯算法
 */
public class LeetCode0077 {
    List<List<Integer>> resList = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return resList;
    }
    private void backtracking(int n, int k, int start) {
        if (list.size() == k) {
            resList.add(new ArrayList<>(list));
            return;
        }
        // 注意这里的条件优化，当前遍历到的数字必须<=最大数-需要的个数+1+list已经有的个数
        for (int i = start; i <= n - k + 1 + list.size(); i++) {
            list.addLast(i);
            backtracking(n, k, i + 1);
            list.removeLast();
        }
    }
}
