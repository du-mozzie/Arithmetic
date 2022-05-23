package com.du.dataStructure.tree;

/**
 * @Author : Du YingJie (2548425238@qq.com)
 * @Description : [树的工具类]
 * @Version : [v1.1]
 * @Date : [2022/5/21 14:04]
 */
public class TreeUtils {

    // 创建一棵二叉树,不是搜索二叉树,不是完全二叉树,不是平衡二叉树
    public static Node createNode(){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);

        node1.left = node2;
        node1.right = node3;

        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node7.left = node4;

        node4.left = node8;
        return node1;
    }

    // 创建一棵搜索二叉树
    public static Node createBST(){
        Node node1 = new Node(5);
        Node node2 = new Node(2);
        Node node3 = new Node(9);
        Node node4 = new Node(1);
        Node node5 = new Node(3);
        Node node6 = new Node(6);
        Node node7 = new Node(10);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;
        return node1;
    }

    // 创建一棵完全二叉树
    public static Node createCBT(){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        // node3.left = node6;
        // node3.right = node7;
        return node1;
    }

    // 创建一棵满二叉树
    public static Node createFBT(){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;
        return node1;
    }

    // 创建一棵平衡二叉树
    public static Node createBBT() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;
        return node1;
    }

    // 寻找最近公共祖先 测试用例
    public static Node createLCA(){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.right = node8;
        return node1;
    }
}
