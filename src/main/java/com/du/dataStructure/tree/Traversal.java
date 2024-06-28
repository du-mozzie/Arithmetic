package com.du.dataStructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author : Du YingJie (2548425238@qq.com)
 * @Description : [遍历二叉树]
 * @Version : [v1.1]
 * @Date : [2022/5/20 14:22]
 */
public class Traversal {

    public static void main(String[] args) {
        // 先构造一颗二叉树
        TreeNode head = TreeUtils.createNode();

        System.out.println("递归先序遍历");
        preOrderRecur(head);
        System.out.println("\n---------------------------");

        System.out.println("迭代先序遍历");
        preOrderNoRecur(head);
        System.out.println("\n---------------------------");

        System.out.println("递归中序遍历");
        inOrderRecur(head);
        System.out.println("\n---------------------------");

        System.out.println("迭代中序遍历");
        inOrderNoRecur(head);
        System.out.println("\n---------------------------");

        System.out.println("递归后序遍历");
        posOrderRecur(head);
        System.out.println("\n---------------------------");

        System.out.println("迭代后序遍历");
        posOrderNoRecur(head);
        System.out.println("\n---------------------------");

        System.out.println("BFS");
        BFS(head);
        System.out.println("\n---------------------------");
    }

    // 递归先序遍历
    public static TreeNode preOrderRecur(TreeNode head) {
        if (head == null) return null;
        System.out.print(head.value + "\t");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
        return head;
    }

    // 递归中序遍历
    public static TreeNode inOrderRecur(TreeNode head) {
        if (head == null) return null;
        inOrderRecur(head.left);
        System.out.print(head.value + "\t");
        inOrderRecur(head.right);
        return head;
    }

    // 递归后序遍历
    public static TreeNode posOrderRecur(TreeNode head) {
        if (head == null) return null;
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + "\t");
        return head;
    }

    // 非递归先序遍历
    public static void preOrderNoRecur(TreeNode head) {
        if (head == null) return;
        // 创建一个栈
        Stack<TreeNode> stack = new Stack<>();
        // 先将根节点入栈
        stack.push(head);
        while (!stack.isEmpty()) {
            // 将栈顶元素移出打印
            TreeNode treeNode = stack.pop();
            System.out.print(treeNode.value + "\t");
            // 如果左右子节点不为空,将右子节点先入栈,然后再将左子节点入栈,在执行循环里面的步骤,直到遍历完树
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }
    }

    // 非递归中序遍历
    public static void inOrderNoRecur(TreeNode head) {
        if (head == null) return;
        // 创建一个栈
        Stack<TreeNode> stack = new Stack<>();
        // 栈不为空
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                // 如果当前节点不为空,就将当前节点放入栈中,并且把当前节点指向它的左子节点
                stack.push(head);
                head = head.left;
            } else {
                // 如果当前节点为空,就把栈顶元素弹出打印,并且把当前节点指向栈顶元素的右子节点
                TreeNode treeNode = stack.pop();
                System.out.print(treeNode.value + "\t");
                head = treeNode.right;
            }
        }
    }

    // 非递归后序遍历,跟先序顺序相反
    public static void posOrderNoRecur(TreeNode head) {
        if (head == null) return;
        // 创建一个栈
        Stack<TreeNode> stack = new Stack<>();
        // 创建一个辅助栈
        Stack<TreeNode> auxiliary = new Stack<>();
        // 先将头节点放入栈中
        stack.push(head);
        while (!stack.isEmpty()) {
            // 取出头节点,放入辅助栈
            TreeNode treeNode = stack.pop();
            auxiliary.push(treeNode);
            // 如果左右子节点不为空,将左子节点先入栈,然后再将右子节点入栈   根右左
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
        }
        // 将辅助栈的元素取出打印就是后序遍历的结果     入栈顺序(根右左)逆序 左右根
        while (!auxiliary.isEmpty()) {
            System.out.print(auxiliary.pop().value + "\t");
        }
    }

    // 宽度优先遍历       深度优先遍历就是先序遍历
    public static void BFS(TreeNode head) {
        if (head == null) return;
        // 创建一个队列
        Queue<TreeNode> queue = new LinkedList<>();
        // 先把头节点加入队列中
        queue.add(head);
        while (!queue.isEmpty()) {
            // 取出队头元素打印
            TreeNode treeNode = queue.poll();
            System.out.print(treeNode.value + "\t");
            // 如果左右子节点不为空,先放入左子节点,再放入右子节点
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
    }

    /**
     * 线索二叉树
     *
     * @param head 头节点
     */
    public static void morris(TreeNode head) {
        if (head == null) return;
        TreeNode cur = head;
        TreeNode mostRight;
        while (cur != null) {
            // mostRight是cur左孩子
            mostRight = cur.left;
            if (mostRight != null) {
                // 有左孩子
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                // mostRight变成了cur左子树上,最右的节点
                if (mostRight.right == null) {
                    // 这是第一次来到cur
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    // mostRight.right == cur
                    mostRight.right = null;
                }
            }
            cur = cur.right;
        }
    }

    // morris先序遍历
    public static void morrisPre(TreeNode head) {
        if (head == null) return;
        TreeNode cur = head;
        TreeNode mostRight;
        while (cur != null) {
            // mostRight是cur左孩子
            mostRight = cur.left;
            if (mostRight != null) {
                // 有左孩子
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                // mostRight变成了cur左子树上,最右的节点
                if (mostRight.right == null) {
                    // 这是第一次来到cur
                    System.out.println(cur.value);
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    // mostRight.right == cur
                    mostRight.right = null;
                }
            } else {
                // 没有左子树
                System.out.println(cur.value);
            }
            cur = cur.right;
        }
    }

    // morris中序遍历
    public static void morrisIn(TreeNode head) {
        if (head == null) return;
        TreeNode cur = head;
        TreeNode mostRight;
        while (cur != null) {
            // mostRight是cur左孩子
            mostRight = cur.left;
            if (mostRight != null) {
                // 有左孩子
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                // mostRight变成了cur左子树上,最右的节点
                if (mostRight.right == null) {
                    // 这是第一次来到cur
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    // mostRight.right == cur
                    mostRight.right = null;
                }
            }
            System.out.println(cur.value);
            cur = cur.right;
        }
    }

    // morris后序遍历
    public static void morrisPos(TreeNode head) {
        if (head == null) return;
        TreeNode cur = head;
        TreeNode mostRight;
        while (cur != null) {
            // mostRight是cur左孩子
            mostRight = cur.left;
            if (mostRight != null) {
                // 有左孩子
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                // mostRight变成了cur左子树上,最右的节点
                if (mostRight.right == null) {
                    // 这是第一次来到cur
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    // mostRight.right == cur
                    mostRight.right = null;
                    printEdge(cur.left);
                }
            }
            cur = cur.right;
        }
        printEdge(head);
        System.out.println();
    }

    // 以X为头的树，逆序打印这棵树的右边界
    public static void printEdge(TreeNode x) {
        TreeNode tail = reverseEdge(x);
        TreeNode cur = tail;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    private static TreeNode reverseEdge(TreeNode from) {
        TreeNode pre = null;
        TreeNode next = null;
        while (from != null) {
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
    }

}
