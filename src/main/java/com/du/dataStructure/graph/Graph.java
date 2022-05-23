package com.du.dataStructure.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author : Du YingJie (2548425238@qq.com)
 * @Description : [图]
 * @Version : [v1.1]
 * @Date : [2022/3/26 20:53]
 */
public class Graph {
    // 点的集合
    public Map<Integer,Node> nodes;

    // 边的集合
    public Set<Edge> edges;

    public Graph() {
        this.nodes = new HashMap<>();
        this.edges = new HashSet<>();
    }
}
