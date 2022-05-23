package com.du.dataStructure.tree;

import java.util.*;

/**
 * @Author : Du YingJie (2548425238@qq.com)
 * @Description : [问题]
 * @Version : [v1.1]
 * @Date : [2022/5/21 13:35]
 */
public class Question {

    static Long preValue = Long.MIN_VALUE;

    public static void main(String[] args) {
        System.out.println("计算一棵树的宽度用map的方法：" + maxBreadth(TreeUtils.createNode()));
        System.out.println("计算一棵树的宽度不用map的方法：" + maxBreadthNoMap(TreeUtils.createNode()));

        // 非递归
        System.out.println("判断一棵树是不是搜索二叉树：" + isBST(TreeUtils.createNode())); // false
        preValue = Long.MIN_VALUE;
        System.out.println("判断一棵树是不是搜索二叉树：" + isBST(TreeUtils.createBST())); // true

        // 递归
        System.out.println("递归判断一棵树是不是搜索二叉树：" + isBSTRecur(TreeUtils.createNode()).isBST); // false
        System.out.println("递归判断一棵树是不是搜索二叉树：" + isBSTRecur(TreeUtils.createBST()).isBST); // true

        System.out.println("判断一棵树是不是完全二叉树：" + isCBT(TreeUtils.createNode())); // false
        System.out.println("判断一棵树是不是完全二叉树：" + isCBT(TreeUtils.createCBT())); // true

        System.out.println("判断一棵树是不是满二叉树：" + isFBT(TreeUtils.createNode())); // false
        System.out.println("判断一棵树是不是满二叉树：" + isFBT(TreeUtils.createFBT())); // true

        System.out.println("判断一棵树是不是平衡二叉树：" + isBBT(TreeUtils.createNode()).isBalance); // false
        System.out.println("判断一棵树是不是平衡二叉树：" + isBBT(TreeUtils.createBBT()).isBalance); // true

        Node head = TreeUtils.createLCA();
        // 4
        Node node4 = head.left.left;
        // 6 return 1
        Node node6 = head.right.left;

        System.out.println("寻找两个节点最近公共祖先：" + lowestCommonAncestor(head, node4, node6).value);
        System.out.println("递归寻找两个节点最近公共祖先：" + LCARecur(head, node4, node6).value);

        // 8 return 2
        Node node8 = head.left.right.right;
        System.out.println("寻找两个节点最近公共祖先：" + LCARecur(head, node4, node8).value);
        System.out.println("递归寻找两个节点最近公共祖先：" + LCARecur(head, node4, node8).value);

    }

    // 返回一棵树的最大宽度
    public static int maxBreadth(Node head) {
        if (head == null) return 0;
        // 记录最大宽度
        int max = Integer.MIN_VALUE;
        // 用一个map记录当前节点所在层数
        Map<Node, Integer> levelMap = new HashMap<>();
        // 记录当前层扫描了的节点数
        int currLevelNum = 0;
        // 记录当前第几层
        int currLevel = 1;
        // 存放head的层数
        levelMap.put(head, currLevel);
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            // 取出当前节点
            Node node = queue.poll();
            // 查看当前节点的层数,currLevelNum++
            Integer level = levelMap.get(node);
            // 如果当前层等于正在扫描的层
            if (currLevel == level) {
                currLevelNum++;
            } else {
                // 如果当前层不等于正在扫描的层,说明已经到了下一层了,就判断上一层扫描了的节点数跟max那个更大
                max = Math.max(currLevelNum, max);
                // 让当前层扫描了的节点数 == 1
                currLevelNum = 1;
                currLevel = level;
            }
            if (node.left != null) {
                Node left = node.left;
                // 存放节点在第几层,left节点是当前层+1
                levelMap.put(left, level + 1);
                queue.add(left);
            }
            if (node.right != null) {
                Node right = node.right;
                // 存放节点在第几层,right节点是当前层+1
                levelMap.put(right, level + 1);
                queue.add(right);
            }
        }
        return Math.max(currLevelNum, max);
    }

    // 二叉树最大宽度不用map的方法
    public static int maxBreadthNoMap(Node head) {
        if (head == null) return 0;
        int max = Integer.MIN_VALUE;
        // 当前层总节点数
        int curLevelTotal = 0;
        // 辅助队列
        Queue<Node> queue = new LinkedList<>();
        // 当前层最后一个节点
        Node currEnd = head;
        // 下一层最后一个节点
        Node nextEnd = null;
        queue.add(head);
        while (!queue.isEmpty()) {
            // 队顶元素出列
            Node node = queue.poll();
            curLevelTotal++;
            // 如果当前节点左右子节点不为空,先把左子节点入列，在把右子节点入列,并且把入队的节点设置为下一层最后一个节点;
            if (node.left != null) {
                Node left = node.left;
                queue.add(left);
                nextEnd = left;
            }
            if (node.right != null) {
                Node right = node.right;
                queue.add(right);
                nextEnd = right;
            }
            // 如果当前节点等于当前层最后一个节点
            if (node == currEnd) {
                // 计算max
                max = Math.max(max, curLevelTotal);
                // 把下一层最后一个节点设置为当前层最后一个节点
                currEnd = nextEnd;
                // 清空nextEnd
                nextEnd = null;
                // 清空curLevelTotal
                curLevelTotal = 0;
            }
        }
        return max;
    }

    // 判断一棵树是不是搜索二叉树
    public static boolean isBST(Node head) {
        if (head == null) return true;
        boolean isLeftBST = isBST(head.left);
        if (!isLeftBST) {
            return false;
        }
        if (head.value <= preValue) {
            return false;
        } else {
            preValue = Long.valueOf(head.value);
        }
        return isBST(head.right);
    }

    // 递归判断一棵树是不是搜索二叉树
    public static BSTReturnData isBSTRecur(Node head) {
        if (head == null) return null;
        BSTReturnData left = isBSTRecur(head.left);
        BSTReturnData right = isBSTRecur(head.right);

        int min = head.value;
        int max = head.value;
        boolean isBST = true;
        // if (left != null) {
        //     min = Math.min(min, left.min);
        //     max = Math.max(max, left.max);
        // }
        // if (right != null) {
        //     min = Math.min(min, right.min);
        //     max = Math.max(max, right.max);
        // }
        // 判断左子树是不是搜索二叉树,
        if (left != null && (!left.isBST || left.min >= head.value)) {
            isBST = false;
        }
        // 判断右子树是不是搜索二叉树
        if (right != null && (!right.isBST || right.max <= head.value)) {
            isBST = false;
        }
        return new BSTReturnData(min, max, isBST);
    }

    // 递归判断搜索二叉树 返回数据
    public static class BSTReturnData {
        public int min;
        public int max;
        public boolean isBST;

        public BSTReturnData(int min, int max, boolean isBST) {
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }

    // 判断一棵树是不是完全二叉树
    public static boolean isCBT(Node head) {
        // 使用宽度搜索来判断
        if (head == null || (head.left == null && head.right == null)) return true;
        Queue<Node> queue = new LinkedList<>();
        // 根节点入队
        queue.add(head);
        // 标志位,接下来的节点是否要为叶子节点
        boolean leaf = false;
        Node left;
        Node right;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            left = node.left;
            right = node.right;
            // 如果当前节点要为叶子节点而它不是叶子节点 || 前节点(有右节点,没有左节点),则这棵树不是完全二叉树
            if (leaf && (left != null || right != null) || left == null && right != null) {
                return false;
            }
            // 左右子节点入队
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
            // 如果当前节点没有右节点,则后面的节点都要是叶子节点
            if (right == null) {
                leaf = true;
            }
        }
        return true;
    }

    // 判断一棵树是不是满二叉树 求二叉树深度H,节点数N    满足关系N = 2^l - 1就是满二叉树
    public static boolean isFBT(Node head) {
        ReturnInfo returnInfo = FBTProcess(head);
        return returnInfo.nodes == ((1 << returnInfo.height) - 1);
    }

    public static ReturnInfo FBTProcess(Node head) {
        if (head == null) return new ReturnInfo(0, 0);
        // 查看左子树的高度根节点数
        ReturnInfo left = FBTProcess(head.left);
        // 查看右子树的高度根节点数
        ReturnInfo right = FBTProcess(head.right);
        int height = 1 + Math.max(left.height, right.height);
        int nodes = 1 + left.nodes + right.nodes;
        return new ReturnInfo(height, nodes);
    }

    // 满二叉树返回信息
    public static class ReturnInfo {
        int height;
        int nodes;

        public ReturnInfo(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }

    // 判断一棵树是不是平衡二叉树  左子树是平衡二叉树 && 右子树是平衡二叉树 && 左右子树深度 ≤ 1
    public static ReturnType isBBT(Node head) {
        if (head == null) return new ReturnType(true, 0);
        // 判断左子树是不是平衡二叉树
        ReturnType left = isBBT(head.left);
        // 判断右子树是不是平衡二叉树
        ReturnType right = isBBT(head.right);
        int height = Math.max(left.height, right.height) + 1;
        boolean isBalance = left.isBalance && right.isBalance && Math.abs(left.height - right.height) < 2;
        return new ReturnType(isBalance, height);
    }

    // 平衡二叉树返回类型
    public static class ReturnType {
        // 是不是平衡二叉树
        public boolean isBalance;
        // 二叉树高度
        public int height;

        public ReturnType(boolean isBalance, int height) {
            this.isBalance = isBalance;
            this.height = height;
        }
    }

    // 给定两个节点,找到它们的最低公共祖先节点
    public static Node lowestCommonAncestor(Node head, Node node1, Node node2) {
        Map<Node, Node> fatherMap = new HashMap<>();
        // 把根节点添加到map
        fatherMap.put(head, head);
        processLCA(fatherMap, head);
        // 用一个set存放根节点到node1的节点
        Set<Node> node1Set = new HashSet<>();
        Node curr = node1;
        // 先将根节点加入set
        node1Set.add(head);
        // 如果一个节点的父节点不是它自己就添加(只有根节点的父节点才是它自己)
        while (curr != fatherMap.get(curr)) {
            node1Set.add(curr);
            // 获取当前节点的父节点,在下一次循环添加进去
            curr = fatherMap.get(curr);
        }
        // 逐个遍历node2的父节点
        curr = node2;
        while (curr != fatherMap.get(curr)) {
            if (node1Set.contains(curr)) {
                return curr;
            }
            curr = fatherMap.get(curr);
        }
        return head;
    }

    // 将每个节点和它的父节点放入map
    public static void processLCA(Map<Node, Node> fatherMap, Node head) {
        if (head == null) return;
        Node left = head.left;
        Node right = head.right;
        if (left != null) {
            fatherMap.put(left, head);
            processLCA(fatherMap, left);
        }
        if (right != null) {
            fatherMap.put(right, head);
            processLCA(fatherMap, right);
        }
    }

    // 递归找LCA
    public static Node LCARecur(Node head, Node node1, Node node2) {
        if (head == null || head == node1 || head == node2) return head;
        // 左边
        Node left = LCARecur(head.left, node1, node2);
        // 右边
        Node right = LCARecur(head.right, node1, node2);
        // 如果两边都找到了,说明该节点就是最近公共祖先节点,直接返回
        if (left != null && right != null){
            return head;
        }
        // 如果有一边为空就返回另外一边 等价于
        // if(left == null ) return right;
        // return left;
        return left != null ? left : right;
    }
}
