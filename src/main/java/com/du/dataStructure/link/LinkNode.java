package com.du.dataStructure.link;

import lombok.Data;

/**
 * @Author : Du YingJie (2548425238@qq.com)
 * @Description : [链表]
 * @Version : [v1.1]
 * @Date : [2022/5/20 1:12]
 */
@Data
public class LinkNode {

    public int val;
    public LinkNode next;

    public LinkNode(int x) {
        val = x;
        next = null;
    }
}
