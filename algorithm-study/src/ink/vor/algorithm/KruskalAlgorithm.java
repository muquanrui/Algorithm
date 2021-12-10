package ink.vor.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author muquanrui
 * @date 24/11/2021 14:10
 */
public class KruskalAlgorithm {
    private static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //克鲁斯卡尔算法的邻接矩阵
        int matrix[][] = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {   0,  12, INF, INF, INF,  16,  14},
                /*B*/ {  12,   0,  10, INF, INF,   7, INF},
                /*C*/ { INF,  10,   0,   3,   5,   6, INF},
                /*D*/ { INF, INF,   3,   0,   4, INF, INF},
                /*E*/ { INF, INF,   5,   4,   0,   2,   8},
                /*F*/ {  16,   7,   6, INF,   2,   0,   9},
                /*G*/ {  14, INF, INF, INF,   8,   9,   0}};
        kruskalAlgorithm(vertexs, matrix);
    }

    public static ArrayList<Edge> constructOrderedEdges(int[][] matrix) {
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                if (matrix[i][j] > 0 && matrix[i][j] < INF) {
                    edges.add(new Edge(i, j, matrix[i][j]));
                }
            }
        }
        edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
        return edges;
    }

    public static ArrayList<Edge> kruskal(char[] vertex, ArrayList<Edge> edges) {
        int[] next = new int[vertex.length];

        ArrayList<Edge> spanningTree = new ArrayList<>();
        int index = 0;

        while (spanningTree.size() < next.length - 1) {
            Edge popEdge = edges.get(index++);
            int start = popEdge.start;
            int end = popEdge.end;
            while (next[start] != 0) {
                start = next[start];
            }
            while (next[end] != 0) {
                end = next[end];
            }
            if (start != end) {
                next[start] = end;
                spanningTree.add(popEdge);
            }
        }

        return spanningTree;
    }

    public static void kruskalAlgorithm(char[] vertex, int[][] matrix) {
        ArrayList<Edge> spanningTree = kruskal(vertex, constructOrderedEdges(matrix));
        for (Edge edge: spanningTree) {
            System.out.println("Add edge from <<" + vertex[edge.start] + ">> to <<" + vertex[edge.end] + ">> with wight <<" + edge.weight + ">>.");
        }
    }
}

class Edge {
    int start;
    int end;
    int weight;
    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}
