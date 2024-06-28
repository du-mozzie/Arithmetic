package com.du.dataStructure.graph;

import java.util.*;

/**
 * @Author : Du YingJie (2548425238@qq.com)
 * @Description : [图的遍历]
 * @Version : [v1.1]
 * @Date : [2022/5/23 15:54]
 */
public class Traversal {

    public static void main(String[] args) {
        Graph graph = GraphUtils.createGraph();

        // BFS
        System.out.print("BFS：");
        BFS(graph.nodes.get(1));
        System.out.println("\n------------------------------");

        // DFS
        System.out.print("DFS：");
        // DFS(graph.nodes.get(1));
        System.out.println("\n------------------------------");
    }

    /**
     * 广度优先搜索
     * 从node节点出发
     * 从队列取出节点的时候处理
     *
     * @param node 节点
     */
    public static void BFS(Node node) {
        if (node == null) return;
        // 用一个队列来进行广度遍历
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

    /**
     * 递归广度优先搜索
     */
    public static void recursionBFS(Node node){
        if(node == null) return;
    }

    /**
     * 深度优先搜索 从node节点出发
     * 从栈加入节点的时候处理
     *
     * @param node node
     */
    public static void DFS(Node node) {
        if (node == null) return;
        // 用一个栈来进行深度遍历
        Stack<Node> stack = new Stack<>();
        // 用一个set集合,防止遍历重复节点
        Set<Node> set = new HashSet<>();
        // 把node放入queue、set
        stack.add(node);
        set.add(node);
        System.out.print(node.value + "\t");
        while (!stack.isEmpty()) {
            // 取出栈顶节点
            Node curr = stack.pop();
            for (Node next : curr.nexts) {
                // 如果当前节点没有遍历过
                if (!set.contains(next)){
                    // 当前取出的节点也要重新入栈,先入栈,放到栈底
                    stack.add(curr);
                    stack.add(next);
                    set.add(next);
                    System.out.print(next.value + "\t");
                    // 加入了一个节点直接跳出循环,进行深度遍历
                    break;
                }
            }
        }
    }

    /**
     * 递归深度优先搜索
     */
    public static void recursionDFS(Node node){
    }
}
