package com.du.dataStructure.link;

/**
 * @Author : Du YingJie (2548425238@qq.com)
 * @Description : [链表的工具类]
 * @Version : [v1.1]
 * @Date : [2022/5/21 0:55]
 */
public class LinkNodeUtils {

    // 创建一个链表
    public static LinkNode createListNode(){
        LinkNode node1 = new LinkNode(1);
        LinkNode node2 = new LinkNode(2);
        LinkNode node3 = new LinkNode(3);
        LinkNode node4 = new LinkNode(4);
        LinkNode node5 = new LinkNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        return node1;
    }
}
