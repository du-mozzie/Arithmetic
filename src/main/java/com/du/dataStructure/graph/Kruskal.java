package com.du.dataStructure.graph;

import java.util.*;

/**
 * 每次都从所有边中选一个最小的的边出来加到最短路径中去
 * 用一个并查集数据结构来保证每个节点只加入一次
 *
 * @Author : Du YingJie (2548425238@qq.com)
 * @Description : [克鲁斯卡尔算法,无向图]
 * @Version : [v1.1]
 * @Date : [2022/5/24 10:26]
 */
public class Kruskal {

    public static Set<Edge> kruskalMST(Graph graph) {
        // 创建一个并查集
        MySet mySet = new MySet((List<Node>) graph.nodes.values());
        // 优先级队列,对边进行排序,内部是一个堆结构,传入一个自定义比较器,从小到大排序
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        // 将所有边都加到队列中去
        priorityQueue.addAll(graph.edges);
        // 用一个set集合放入结果边
        Set<Edge> result = new HashSet<>();
        // 如果还有边没被选过就选择一条最小的边
        while (!priorityQueue.isEmpty()) {
            // 取出小顶堆堆顶边
            Edge edge = priorityQueue.poll();
            // 判断两个节点是不是已经添加过了
            if (!mySet.isSameSet(edge.from, edge.to)) {
                // 如果没有加到结果里去选择这条边
                result.add(edge);
                // 并且把这两个节点合并起来
                mySet.union(edge.from, edge.to);
            }
        }
        return result;
    }

}

// 模拟并查集
class MySet {
    public HashMap<Node, List<Node>> setMap;

    public MySet(List<Node> nodes) {
        setMap = new HashMap<>();
        for (Node node : nodes) {
            List<Node> set = new ArrayList<>();
            set.add(node);
            setMap.put(node, set);
        }
    }

    // 判断两个节点是否已经在一个集合
    public boolean isSameSet(Node from, Node to) {
        return setMap.get(from) == setMap.get(to);
    }

    // 将两个节点合并,加入一个集合中
    public void union(Node from, Node to) {
        List<Node> fromSet = setMap.get(from);
        List<Node> toSet = setMap.get(to);
        // 将toSet节点加入fromSet
        for (Node node : toSet) {
            fromSet.add(node);
            // 并且把map中对应的node节点value指向fromSet
            setMap.put(node, fromSet);
        }
    }
}