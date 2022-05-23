package com.du.dataStructure.link;

/**
 * @Author : Du YingJie (2548425238@qq.com)
 * @Description : [链表的工具类]
 * @Version : [v1.1]
 * @Date : [2022/5/21 0:55]
 */
public class ListNodeUtils {

    // 创建一个链表
    public static ListNode createListNode(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        return node1;
    }
}
