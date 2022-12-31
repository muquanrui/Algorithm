package com.muquanrui.dailyleetcoding;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 2022/11/10 15:28
 */

// https://leetcode.cn/problems/shortest-path-to-get-all-keys/
public class LeetCode0864 {
    int keysNum = 0;
    char[][] matrix;
    Deque<int[]> queue = new LinkedList<>();
    int[][][] record;

    public int shortestPathAllKeys(String[] grid) {
        matrix = new char[grid.length][grid[0].length()];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                char ch = grid[i].charAt(j);
                matrix[i][j] = ch;
                if (ch == '@') {
                    queue.offer(new int[]{i, j, 0});
                } else if (Character.isLowerCase(ch)) {
                    keysNum++;
                }
            }
        }

        record = new int[matrix.length][matrix[0].length][1 << keysNum];

        int target = (1 << keysNum) - 1;
        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();
            int curI = curPos[0];
            int curJ = curPos[1];
            int curState = curPos[2];
            int step = record[curI][curJ][curState];

            if (tryWalk(curI - 1, curJ, curState, step) == target ||
                    tryWalk(curI, curJ + 1, curState, step) == target ||
                    tryWalk(curI + 1, curJ, curState, step) == target ||
                    tryWalk(curI, curJ - 1, curState, step) == target) {
                return step + 1;
            }
        }


        return -1;
    }

    private int tryWalk(int i, int j, int state, int lastStep) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == '#') {
            return state;
        }

        char ch = matrix[i][j];
        if (Character.isLowerCase(ch)) {
            state |= 1 << (ch - 'a');
        } else if (Character.isUpperCase(ch)) {
            if (((state >> (ch - 'A')) & 1) == 0) {
                return state;
            }
        }

        int step = record[i][j][state];

        if (step == 0 || step > lastStep + 1) {
            queue.offer(new int[]{i, j, state});
            record[i][j][state] = lastStep + 1;
        }

        return state;
    }
}
