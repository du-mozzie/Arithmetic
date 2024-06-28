package com.du.dataStructure.graph;

import java.util.Comparator;

/**
 * @Author : Du YingJie (2548425238@qq.com)
 * @Description : [边比较器]
 * @Version : [v1.1]
 * @Date : [2022/5/24 11:18]
 */
public class EdgeComparator implements Comparator<Edge> {

    @Override
    public int compare(Edge o1, Edge o2) {
        return o1.weight - o2.weight;
    }

}
