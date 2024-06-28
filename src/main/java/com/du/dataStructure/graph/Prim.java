package com.du.dataStructure.graph;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 先选择一个点,在该点的边集合中选择一个最小的
 * 如果to点没有被选过,就把这条边加入结果集中,并且把当前to点的边加入边集合在选择最小的一条边,重复直到所有边都选过
 * 如果to点被选过,换一条边选,重复直到所有边都选过
 * @Author : Du YingJie (2548425238@qq.com)
 * @Description : [普里姆算法,无向图]
 * @Version : [v1.1]
 * @Date : [2022/5/24 10:26]
 */
public class Prim {

    public static Set<Edge> primMST(Graph graph){
        // 存放边集合
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        // 记录选择过的节点
        Set<Node> set = new HashSet<>();
        // 记录结果边
        Set<Edge> result = new HashSet<>();

        // 如果是森林,随机选择一个点开始,需要把块区域的最短边都选出来
        for (Node node : graph.nodes.values()) {
            // node是开始点,没有选过该点就选这个点
            if (!set.contains(node)){
                // 把这个点的边都加入优先队列中
                priorityQueue.addAll(node.edges);
                // 如果还有边就继续选
                while (!priorityQueue.isEmpty()){
                    // 取一个最短的边
                    Edge edge = priorityQueue.poll();
                    // 可能的一个新节点
                    Node to = edge.to;
                    // 如果该点没有选择过
                    if (!set.contains(to)){
                        // 把这条边加到结果中去
                        result.add(edge);
                        // 把这个节点加到选择过的节点中去
                        set.add(to);
                        // 把这个点的边加到优先队列中去
                        priorityQueue.addAll(to.edges);
                    }
                }
            }
        }
        return result;
    }
}
