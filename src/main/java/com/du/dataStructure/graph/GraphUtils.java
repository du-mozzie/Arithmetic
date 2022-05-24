package com.du.dataStructure.graph;

/**
 * @Author : Du YingJie (2548425238@qq.com)
 * @Description : [图工具类]
 * @Version : [v1.1]
 * @Date : [2022/5/23 15:16]
 */
public class GraphUtils {

    /**
     * 创建一个图的测试用例
     * matrix[0][0] weight
     * matrix[0][1] fromNode 坐标
     * matrix[0][2] toNode 坐标
     * TODO 创建无向图还有BUG,循环依赖,栈溢出
     * @return 矩阵
     */
    public static Integer[][] createMatrix() {
        Integer[][] matrix = new Integer[8][3];

        matrix[0][0] =4;
        matrix[0][1] =1;
        matrix[0][2] =2;

        matrix[1][0] =3;
        matrix[1][1] =1;
        matrix[1][2] =4;

        matrix[2][0] =2;
        matrix[2][1] =1;
        matrix[2][2] =3;

        matrix[3][0] =7;
        matrix[3][1] =2;
        matrix[3][2] =3;

        matrix[4][0] =5;
        matrix[4][1] =2;
        matrix[4][2] =5;

        matrix[5][0] =6;
        matrix[5][1] =3;
        matrix[5][2] =4;

        matrix[6][0] =1;
        matrix[6][1] =3;
        matrix[6][2] =5;

        matrix[7][0] =3;
        matrix[7][1] =4;
        matrix[7][2] =5;

        // 无向图另外一边,无向图链表存储会存在循环依赖问题,栈溢出
        // matrix[8][0] =4;
        // matrix[8][1] =2;
        // matrix[8][2] =1;
        //
        // matrix[9][0] =3;
        // matrix[9][1] =4;
        // matrix[9][2] =1;
        //
        // matrix[10][0] =2;
        // matrix[10][1] =3;
        // matrix[10][2] =1;
        //
        // matrix[11][0] =7;
        // matrix[11][1] =3;
        // matrix[11][2] =2;
        //
        // matrix[12][0] =5;
        // matrix[12][1] =5;
        // matrix[12][2] =2;
        //
        // matrix[13][0] =6;
        // matrix[13][1] =4;
        // matrix[13][2] =3;
        //
        // matrix[14][0] =1;
        // matrix[14][1] =5;
        // matrix[14][2] =3;
        //
        // matrix[15][0] =3;
        // matrix[15][1] =5;
        // matrix[15][2] =4;

        return matrix;
    }

    /**
     * 一个 n * 3的矩阵
     * matrix[0][0] weight
     * matrix[0][1] fromNode 坐标
     * matrix[0][2] toNode 坐标
     *
     * @return 图
     */
    public static Graph createGraph() {
        Integer[][] matrix = createMatrix();
        Graph graph = new Graph();
        // 遍历矩阵
        for (int i = 0; i < matrix.length; i++) {
            Integer weight = matrix[i][0];
            Integer from = matrix[i][1];
            Integer to = matrix[i][2];
            if (!graph.nodes.containsKey(from)) {
                graph.nodes.put(from, new Node(from));
            }
            if (!graph.nodes.containsKey(to)) {
                graph.nodes.put(to, new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge edge = new Edge(weight, fromNode, toNode);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            toNode.in++;
            fromNode.edges.add(edge);
            graph.edges.add(edge);
        }
        return graph;
    }

}
