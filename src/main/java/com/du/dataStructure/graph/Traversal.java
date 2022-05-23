package com.du.dataStructure.graph;

import java.util.*;

/**
 * @Author : Du YingJie (2548425238@qq.com)
 * @Description : [图的遍历]
 * @Version : [v1.1]
 * @Date : [2022/5/23 15:54]
 */
public class Traversal {

    /**
     * 宽度优先搜索
     * 从node节点出发
     *
     * @param node 节点
     */
    public static void BFS(Node node) {
        if (node == null) return;
        // 用一个队列来进行宽度遍历
        Queue<Node> queue = new LinkedList<>();
        // 用一个set集合,防止遍历重复节点
        Set<Node> set = new HashSet<>();
        // 把node放入queue、set
        queue.add(node);
        set.add(node);
        // 如果队列不是空开始遍历
        while (!queue.isEmpty()) {
            // 取出队尾节点
            Node curr = queue.poll();
            // 打印节点,如果在BFS要进行操作,就在这边操作
            System.out.print(curr.value + "\t");
            // 遍历当前节点相邻节点
            for (Node next : curr.nexts) {
                // 判断next是否已经遍历过,没有遍历过的放入queue遍历
                if (!set.contains(next)) {
                    queue.add(next);
                    set.add(next);
                }
            }
        }
    }
}
