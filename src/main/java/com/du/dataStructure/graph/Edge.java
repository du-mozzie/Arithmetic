package com.du.dataStructure.graph;

import lombok.Data;

/**
 * @Author : Du YingJie (2548425238@qq.com)
 * @Description : [边]
 * @Version : [v1.1]
 * @Date : [2022/5/23 15:07]
 */
@Data
public class Edge {
    // 边的权值
    public int weight;

    // 边的起始节点
    public int from;

    // 边的结束节点
    public int to;

    public Edge(int weight, int from, int to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
