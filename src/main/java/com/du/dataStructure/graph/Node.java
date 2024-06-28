package com.du.dataStructure.graph;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Du YingJie (2548425238@qq.com)
 * @Description : [链表存储图]
 * @Version : [v1.1]
 * @Date : [2022/3/26 20:52]
 */
@Data
public class Node {
    // 节点值
    public int value;

    // 入度数量
    public int in;

    // 出度数量
    public int out;

    // 相连的节点
    public List<Node> nexts;

    // 边
    public List<Edge> edges;

    public Node(int value) {
        this.value = value;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
}