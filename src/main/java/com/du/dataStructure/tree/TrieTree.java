package com.du.dataStructure.tree;

/**
 * @Author : Du YingJie (2548425238@qq.com)
 * @Description : [前缀树]
 * @Version : [v1.1]
 * @Date : [2022/5/24 15:28]
 */
public class TrieTree {

    // 前缀树节点
    public class TrieNode {
        // 经过此节点的个数
        public int pass;
        // 以此节点结束的个数
        public int end;
        // 前缀树节点表,存放了该节点后面的节点    a -> a (nexts[0]), a -> b (nexts[1])...
        // 数据量大可以使用HaspMap<Char, Node> nexts;
        // 想要数据有序TreeMap<Char, Node> nexts;
        public TrieNode[] nexts;

        public TrieNode() {
            this.pass = 0;
            this.end = 0;
            /**
             * 0 - 25, a-z 26个小写字母
             * nexts[0] == null 没有走向'a'的路
             * nexts[0] != null 有走向'a'的路
             * ...
             * nexts[25] == null 有走向'z'的路
             */
            this.nexts = new TrieNode[31];
        }
    }

    // 前缀树
    public class Trie {
        // 维护一个唯一的根节点
        public TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        // 加入一个字典到前缀树
        public void insert(String word) {
            if (word == null) {
                return;
            }
            // 把word转为一个字符数组
            char[] words = word.toCharArray();
            // 把当前节点指向root
            TrieNode node = root;
            // node节点pass++
            node.pass++;
            // 用一个index记录当前字符应该走哪条路
            int index = 0;
            for (int i = 0; i < words.length; i++) {
                // 对应的node.nexts[index]存在,就说明之前已经有词典走过这条路了
                // 当前的字符减 a 的ASCII码(97) a - a = 0; b - a = 1; 让a-z,从0-25排放
                index = words[i] - 'a';
                // 判断当前节点后面是否存在nexts[index],不存在新建
                if (node.nexts[index] == null) {
                    node.nexts[index] = new TrieNode();
                }
                // 把当前节点指向下一个nexts[index]节点
                node = node.nexts[index];
                node.pass++;
            }
            // 当words遍历完,说明当前节点有一个字典是已此结束
            node.end++;
        }

        // 删除一个词
        public void delete(String word) {
            // 先判断是否有个词
            if (search(word) != 0) {
                char[] words = word.toCharArray();
                TrieNode node = root;
                int index = 0;
                node.pass--;
                for (int i = 0; i < words.length; i++) {
                    // 如果一个节点的pass-- == 0 后直接把这个节点删掉
                    if (--node.nexts[index].pass == 0) {
                        // Java GC会直接释放内存, c++要遍历到底层去析构
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }

        // word这个单词在之前加入过几次
        public int search(String word) {
            if (word == null) {
                return 0;
            }
            char[] words = word.toCharArray();
            int index;
            TrieNode node = root;
            for (int i = 0; i < words.length; i++) {
                index = words[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        // 所有加入的字符串中,有几个是以pre这个字符串作为前缀的
        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] pres = pre.toCharArray();
            int index;
            TrieNode node = root;
            for (int i = 0; i < pres.length; i++) {
                index = pres[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.pass;
        }
    }
}
