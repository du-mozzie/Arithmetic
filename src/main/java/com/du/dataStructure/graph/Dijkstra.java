package com.du.dataStructure.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 适用权值没有负数的
 * 从一个节点出发,用一个map存储该节点到每个节点的距离(edge weight),该节点到自己是0
 * <p>
 * 每一次都从map中选择一个距离最短的节点
 * 如果有出现一条边到另外一个点的距离更短就替换它(
 * 从原点出发到from的距离 + from到to边的距离 < map中记录过原点到该点的距离
 * ) 把该点每条都比较过后,把该点加入到已经选择过的点中去,重复该步骤,直到所有点都选过
 *
 * @Author : Du YingJie (2548425238@qq.com)
 * @Description : [迪杰斯特拉算法]
 * @Version : [v1.1]
 * @Date : [2022/5/24 10:27]
 */
public class Dijkstra {

    public static Map<Node, Integer> dijkstra(Node node) {
        /**
         * 用一个map来记录从node到其他点的距离
         * 初始化时只加入node节点,其他点不加入,代表node节点到其他点的距离都是无穷
         */
        Map<Node, Integer> distanceMap = new HashMap<>();
        // node到自己距离是0
        distanceMap.put(node, 0);
        // 用一个set集合存储已经选择过的点
        Set<Node> touchedSet = new HashSet<>();
        // 先找一个最小的点
        Node minNode = getMinDistanceAndUnselectedNode(distanceMap, touchedSet);
        // 如果minNode存在就遍历
        while (minNode != null) {
            // 获取node -> minNode的距离
            int distance = distanceMap.get(minNode);
            // 遍历minNode的边
            for (Edge edge : minNode.edges) {
                Node to = edge.to;
                // 如果to节点还没有加到distanceMap直接加进去
                if (!distanceMap.containsKey(to)) {
                    distanceMap.put(to, distance);
                } else {
                    // 如果当前边的距离+ node -> minNode的距离 小于 之前记录的值就把它重新给map
                    distanceMap.put(to, Math.min(distanceMap.get(to), edge.weight + distance));
                }
            }
            // 把当前节点放入选过的节点集合中
            touchedSet.add(minNode);
            // 找到下一个最小的点
            minNode = getMinDistanceAndUnselectedNode(distanceMap, touchedSet);
        }
        return distanceMap;
    }

    // 找到没有选择过的点,并且原点到该点的距离是最小的节点
    public static Node getMinDistanceAndUnselectedNode(Map<Node, Integer> distanceMap, Set<Node> touchedSet) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        // 遍历map
        for (Map.Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node node = entry.getKey();
            // 如果这个点没有被选过,并且它的值更小
            if (!touchedSet.contains(node) && distanceMap.get(node) < minDistance) {
                minNode = node;
                minDistance = entry.getValue();
            }
        }
        return minNode;
    }

    public static void main(String[] args) {
        Node mce1 = new Node(1);
        Node mce2 = new Node(2);
        Node mce3 = new Node(3);
        Node mce4 = new Node(4);
        Node mce5 = new Node(5);
        Node mce6 = new Node(6);
    }
}