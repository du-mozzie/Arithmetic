package com.du.dataStructure.graph;

import java.util.*;

/**
 * @Author : Du YingJie (2548425238@qq.com)
 * @Description : [一句话描述这个类的作用]
 * @Version : [v1.1]
 * @Date : [2022/5/23 22:49]
 */
public class Question {

    public static void main(String[] args) {
        // 拓扑排序
        Graph graph = GraphUtils.createGraph();
        List<Node> nodes = sortedTopology(graph);
        for (Node node : nodes) {
            System.out.print(node.value + "\t");
        }
        System.out.println("\n---------------------");
    }

    /**
     * 拓扑排序
     *
     * @param graph 图
     * @return 拓扑排序结果
     */
    public static List<Node> sortedTopology(Graph graph) {
        // 用一个map存取入度不为0的节点、入度数
        Map<Node, Integer> map = new HashMap<>();
        // 用一个队列存放入度为0的节点
        Queue<Node> queue = new LinkedList<>();
        // 遍历节点
        for (Node node : graph.nodes.values()) {
            // 入度==0 进队列
            if (node.in == 0) {
                queue.add(node);
            } else {
                // 入度!=0 进map
                map.put(node, node.in);
            }
        }
        // 用一个list存放结果
        List<Node> result = new ArrayList<>();
        // 遍历入度为0的队列
        while (!queue.isEmpty()) {
            // 取出队尾节点,加入到结果集中
            Node curr = queue.poll();
            result.add(curr);
            // 遍历队尾节点的next节点
            for (Node next : curr.nexts) {
                // next节点入度-1
                map.put(next, map.get(next) - 1);
                // 如果有节点 入度==0 后,加入到队列中
                if (map.get(next) == 0) {
                    queue.add(next);
                }
            }
        }
        return result;
    }
}
