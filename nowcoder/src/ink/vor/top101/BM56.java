package ink.vor.top101;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author muquanrui
 * @date 2022/4/14 17:51
 */
public class BM56 {
    private ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();
    private boolean[] isVisited;
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        isVisited = new boolean[num.length];
        Arrays.sort(num);
        backtracking(num);
        return resList;
    }

    private void backtracking(int[] num) {
        if (list.size() == num.length) {
            resList.add(new ArrayList(list));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (isVisited[i] || (i > 0 && num[i] == num[i - 1] && !isVisited[i - 1])) {
                continue;
            }
            isVisited[i] = true;
            list.add(num[i]);
            backtracking(num);
            list.remove(list.size() - 1);
            isVisited[i] = false;
        }
    }
}
