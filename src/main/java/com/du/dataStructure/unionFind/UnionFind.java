package com.du.dataStructure.unionFind;

import lombok.Data;

import java.util.*;

/**
 * 包装并查集的元素
 *
 * @Author : Du YingJie (2548425238@qq.com)
 * @Description : [元素]
 * @Version : [v1.1]
 * @Date : [2022/5/29 9:34]
 */
public class UnionFind {

    @Data
    public static class Element<V> {

        private V value;

        public Element(V value) {
            this.value = value;
        }

    }

    public static class UnionFindSet<V> {
        // 元素的集合
        public Map<V, Element<V>> elementMap;
        // key 元素 value 该元素的父
        public Map<Element<V>, Element<V>> fatherMap;
        // key 某个集合的代表元素 value 当前集合的大小
        public Map<Element<V>, Integer> sizeMap;

        // 初始化一个空的并查集
        public UnionFindSet() {
            this.elementMap = new HashMap<>();
            this.fatherMap = new HashMap<>();
            this.sizeMap = new HashMap<>();
        }

        /**
         * 通过一个list集合初始化并查集
         *
         * @param list 给定的集合
         */
        public UnionFindSet(List<V> list) {
            this.elementMap = new HashMap<>();
            this.fatherMap = new HashMap<>();
            this.sizeMap = new HashMap<>();
            Iterator<V> iterator = list.iterator();
            // 迭代list添加到集合
            while (iterator.hasNext()) {
                V node = iterator.next();
                Element<V> element = new Element<>(node);
                this.elementMap.put(node, element);
                // 一开始每个元素的父节点都是自己
                this.fatherMap.put(element, element);
                // 一开始每个集合大小都是1
                this.sizeMap.put(element, 1);
            }
        }

        /**
         * 添加一个节点
         *
         * @param node 需要添加的节点
         */
        public void addNode(V node) {
            Element<V> element = new Element<>(node);
            this.elementMap.put(node, element);
            // 一开始每个元素的父节点都是自己
            this.fatherMap.put(element, element);
            // 一开始每个集合大小都是1
            this.sizeMap.put(element, 1);
        }

        /**
         * 给定一个element，往上查找，把代表元素找到
         *
         * @param element 元素
         * @return 元素父节点
         */
        private Element<V> findHead(Element<V> element) {
            Queue<Element<V>> path = new ArrayDeque<>();
            while (element != fatherMap.get(element)) {
                path.add(element);
                // 把父节点的父节点压栈,一直到head节点
                element = fatherMap.get(element);
            }
            // 把栈里面的每个元素的父节点都直接指向它们最顶部的元素，维护了并查集每个节点串起来的链长度都是2，查询、合并复杂度都是O(1)
            while (!path.isEmpty()) {
                fatherMap.put(path.poll(), element);
            }
            return element;
        }

        /**
         * 判断两个节点是不是在同一个集合里面
         *
         * @param a 节点a
         * @param b 节点b
         * @return 两个节点是否在同一个集合中 在 true 不在 false;
         */
        public boolean isSameSet(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                // 它们的头节点是不是同一个
                return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
            }
            return false;
        }

        /**
         * 把给的两个节点合并到同一个元素
         *
         * @param a 节点a
         * @param b 节点b
         */
        public void union(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                Element<V> aHead = findHead(elementMap.get(a));
                Element<V> bHead = findHead(elementMap.get(b));
                // 这两个节点的head节点不是同一个节点才需要合并
                if (aHead != bHead) {
                    // 子节点较多的元素
                    Element<V> big = sizeMap.get(aHead) >= sizeMap.get(bHead) ? aHead : bHead;
                    // 子节点较少的元素
                    Element<V> small = big == aHead ? bHead : aHead;
                    // 把small父节点挂到big上
                    fatherMap.put(small, big);
                    // 把big节点长度 += small节点长度
                    sizeMap.put(big, sizeMap.get(big) + sizeMap.get(small));
                    // 删除small节点的长度记录
                    sizeMap.remove(small);
                }
            }
        }
    }
}
