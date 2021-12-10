package ink.vor.algorithm;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author muquanrui
 * @date 27/11/2021 14:26
 */
public class HorseChessboard {

    private static int X; // 棋盘的行数
    private static int Y; // 棋盘的列数
    //创建一个数组，标记棋盘的各个位置是否被访问过
    private static boolean visited[][];
    //使用一个属性，标记是否棋盘的所有位置都被访问
    private static boolean finished; // 如果为true,表示成功

    public static void main(String[] args) {
        System.out.println("骑士周游算法，开始运行~~");
        //测试骑士周游算法是否正确
        X = 6;
        Y = 6;
        int initiaX = 0; //马儿初始位置的行，从1开始编号
        int initiaY = 2; //马儿初始位置的列，从1开始编号
        //创建棋盘
        int[][] chessboard = new int[X][Y];
        visited = new boolean[X][Y];//初始值都是false
        //测试一下耗时
        long start = System.currentTimeMillis();
        traversalChessboard(chessboard, initiaX, initiaY, 1);
        long end = System.currentTimeMillis();
        System.out.println("共耗时: " + (end - start) + " 毫秒");

        //输出棋盘的最后情况
        for(int[] rows : chessboard) {
            for(int step: rows) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 完成骑士周游问题的算法
     * @param chessboard 棋盘
     * @param x 马儿当前的位置的行 从0开始
     * @param y 马儿当前的位置的列  从0开始
     * @param step 是第几步 ,初始位置就是第1步
     */
    public static void traversalChessboard(int[][] chessboard, int x, int y, int step) {
        ArrayList<Point> nextPoints = next(new Point(x, y));
        sort(nextPoints);
        visited[y][x] = true;
        chessboard[y][x] = step;
        while (!finished && nextPoints.size() > 0) {
            Point nextP = nextPoints.remove(0);
            if (!visited[nextP.y][nextP.x]) {
                traversalChessboard(chessboard, nextP.x, nextP.y, step + 1);
            }
        }
        if (!finished && step < X * Y) {
            chessboard[y][x] = 0;
            visited[y][x] = false;
        } else {
            finished = true;
        }
    }

    /**
     * 功能： 根据当前位置(Point对象)，计算马儿还能走哪些位置(Point)，并放入到一个集合中(ArrayList), 最多有8个位置
     * @param curPoint
     * @return
     */
    public static ArrayList<Point> next(Point curPoint) {
        ArrayList<Point> nextPoints = new ArrayList<>();
        if (curPoint.y + 2 < X && curPoint.x - 1 >= 0) {
            nextPoints.add(new Point(curPoint.x - 1, curPoint.y + 2));
        }
        if (curPoint.y + 2 < X && curPoint.x + 1 < Y) {
            nextPoints.add(new Point(curPoint.x + 1, curPoint.y + 2));
        }
        if (curPoint.y + 1 < X && curPoint.x - 2 >= 0) {
            nextPoints.add(new Point(curPoint.x - 2, curPoint.y + 1));
        }
        if (curPoint.y + 1 < X && curPoint.x + 2 < Y) {
            nextPoints.add(new Point(curPoint.x + 2, curPoint.y + 1));
        }
        if (curPoint.y - 2 >= 0 && curPoint.x - 1 >= 0) {
            nextPoints.add(new Point(curPoint.x - 1, curPoint.y - 2));
        }
        if (curPoint.y - 2 >= 0 && curPoint.x + 1 < Y) {
            nextPoints.add(new Point(curPoint.x + 1, curPoint.y - 2));
        }
        if (curPoint.y - 1 >= 0 && curPoint.x - 2 >= 0) {
            nextPoints.add(new Point(curPoint.x - 2, curPoint.y - 1));
        }
        if (curPoint.y - 1 >= 0 && curPoint.x + 2 < Y) {
            nextPoints.add(new Point(curPoint.x + 2, curPoint.y - 1));
        }
        return nextPoints;
    }

    //根据当前这个一步的所有的下一步的选择位置，进行非递减排序, 减少回溯的次数
    public static void sort(ArrayList<Point> ps) {
        Collections.sort(ps, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return next(o1).size() - next(o2).size();
            }
        });
    }
}

