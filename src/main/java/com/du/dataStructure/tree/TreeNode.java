package com.du.dataStructure.tree;

import lombok.Data;

/**
 * @Author : Du YingJie (2548425238@qq.com)
 * @Description : [二叉树]
 * @Version : [v1.1]
 * @Date : [2022/5/20 14:07]
 */
@Data
public class TreeNode {
    public Integer value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(Integer data) {
        this.value = data;
    }
}