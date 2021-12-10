package ink.vor.algorithm;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author muquanrui
 * @date 21/11/2021 11:32
 */
public class PrimAlgorithm {
    public static void main(String[] args) {
        //测试看看图是否创建ok
        char[] data = new char[]{'A','B','C','D','E','F','G'};
        //邻接矩阵的关系使用二维数组表示,10000这个大数，表示两个点不联通
        int [][]weight=new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000},};
        Graph graph = new Graph(data, weight);
        prim(graph, 0);
    }

    public static void prim(Graph graph, int startIndex) {
        char[] data = graph.data;
        int[][] weight = graph.weight;

        System.out.println("Add vertex <<" + data[startIndex] + ">> to spanning tree.");

        int[] visited = new int[data.length];
        visited[startIndex] = 1;
        ArrayList<Integer> visitedList = new ArrayList<>();
        visitedList.add(startIndex);

        while (visitedList.size() < data.length) {
            int minWeight = 10000;
            int preIndex = startIndex;
            int nextIndex = startIndex;
            for (int curIndex: visitedList) {
                for (int i = 0; i < data.length; i++) {
                    if (weight[curIndex][i] < minWeight && visited[i] == 0) {
                        minWeight = weight[curIndex][i];
                        preIndex = curIndex;
                        nextIndex = i;
                    }
                }
            }
            visited[nextIndex] = 1;
            visitedList.add(nextIndex);
            System.out.println("Add vertex <<" + data[nextIndex] + ">> with edge <<" + data[preIndex] + "-" + data[nextIndex] + ">> weight <<" + minWeight + ">> to spanning tree.");
        }
    }
}

class Graph {
    int vertexNum;
    char[] data;
    int[][] weight;

    public Graph(char[] data, int[][] weight) {
        this.data = data;
        this.weight = weight;
        vertexNum = data.length;
    }
}
