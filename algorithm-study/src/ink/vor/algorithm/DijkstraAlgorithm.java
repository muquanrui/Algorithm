package ink.vor.algorithm;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 24/11/2021 16:27
 */
public class DijkstraAlgorithm {
    private static final int INF = 65535;
    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //克鲁斯卡尔算法的邻接矩阵
        int matrix[][] = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {INF, 5, 7, INF, INF, INF, 2},
                /*B*/ {5, INF, INF, 9, INF, INF, 1},
                /*C*/ {7, INF, INF, INF, 8, INF, INF},
                /*D*/ {INF, 9, INF, INF, INF, 4, INF},
                /*E*/ {INF, INF, 8, INF, INF, 5, 4},
                /*F*/ {INF, INF, INF, 4, 5, INF, 6},
                /*G*/ {2, 1, INF, INF, 4, 6, INF}};
        dijkstraAlgorithm(vertexs, matrix, 'A');
    }

    public static void dijkstraAlgorithm(char[] vertex, int[][] matrix, char start) {
        int startIndex = 0;
        final int LENGTH = vertex.length;

        for (int i = 0; i < LENGTH; i++) {
            if (vertex[i] == start) {
                startIndex = i;
                break;
            }
        }
        int[] visited = new int[LENGTH];
        int[] distance = new int[LENGTH];
        String[] path = new String[LENGTH];

        for (int i = 0; i < LENGTH; i++) {
            path[i] = String.valueOf(start);
        }

        visited[startIndex] = 1;
        for (int i = 0; i < LENGTH; i++) {
            distance[i] = INF;
        }
        distance[startIndex] = 0;

        int curIndex = startIndex;

        for (int i = 0; i < LENGTH - 1; i++) {
            for (int j = 0; j < LENGTH; j++) {
                if (distance[j] > matrix[curIndex][j] + distance[curIndex]){
                    distance[j] = matrix[curIndex][j] + distance[curIndex];
                    path[j] = path[curIndex] + " -> " + vertex[j];
                }
            }
            int min = INF;
            for (int j = 0; j < LENGTH; j++) {
                if (distance[j] < min && visited[j] == 0) {
                    min = distance[j];
                    curIndex = j;
                }
            }
            visited[curIndex] = 1;
        }

        System.out.println(Arrays.toString(distance));
        System.out.println(Arrays.toString(path));
    }
}
