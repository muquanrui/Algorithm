package ink.vor.algorithm;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 26/11/2021 14:12
 */

public class FloydAlgorithm {

    public static void main(String[] args) {
        // 测试看看图是否创建成功
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        //创建邻接矩阵
        final int INF = 65535;
        int matrix[][] = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {0, 5, 7, INF, INF, INF, 2},
                /*B*/ {5, 0, INF, 9, INF, INF, 1},
                /*C*/ {7, INF, 0, INF, 8, INF, INF},
                /*D*/ {INF, 9, INF, 0, INF, 4, INF},
                /*E*/ {INF, INF, 8, INF, 0, 5, 4},
                /*F*/ {INF, INF, INF, 4, 5, 0, 6},
                /*G*/ {2, 1, INF, INF, 4, 6, 0}};

        //创建 Graph 对象
        GraphFloyd graph = new GraphFloyd(vertex.length, matrix, vertex);
        //调用弗洛伊德算法
        graph.floyd();
        graph.show();
    }

}

// 创建图
class GraphFloyd {
    private char[] vertex; // 存放顶点的数组
    private int[][] dis; // 保存，从各个顶点出发到其它顶点的距离，最后的结果，也是保留在该数组
    private int[][] pre;// 保存到达目标顶点的前驱顶点

    // 构造器
    /**
     *
     * @param length
     *            大小
     * @param matrix
     *            邻接矩阵
     * @param vertex
     *            顶点数组
     */
    public GraphFloyd(int length, int[][] matrix, char[] vertex) {
        this.vertex = vertex;
        this.dis = matrix;
        this.pre = new int[length][length];
        // 对pre数组初始化, 注意存放的是前驱顶点的下标
        for (int i = 0; i < length; i++) {
            Arrays.fill(pre[i], i);
        }
    }

    // 显示pre数组和dis数组
    public void show() {
        for (int i = 0; i < dis.length; i++) {
            for (int j = 0; j < vertex.length; j++) {
                System.out.println("Shortest path length from <<" + vertex[i] + ">> to <<" + vertex[j] + ">> is: " + dis[i][j] + ". And the path is:");
                int temp = j;
                StringBuilder sb = new StringBuilder();
                while (dis[i][temp] != 0) {
                    sb.append(vertex[temp] + " >- ");
                    temp = pre[i][temp];
                }
                sb.append(vertex[temp]);
                System.out.println(sb.reverse());
            }
        }
    }

    //弗洛伊德算法, 比较容易理解，而且容易实现
    public void floyd() {
        int length = 0;
        for (int mid = 0; mid < vertex.length; mid++) {
            for (int start = 0; start < vertex.length; start++) {
                for (int end = 0; end < vertex.length; end++) {
                    length = dis[start][mid] + dis[mid][end];
                    if (length < dis[start][end]) {
                        dis[start][end] = length;
                        pre[start][end] = pre[mid][end];
                    }
                }
            }
        }
    }
}

