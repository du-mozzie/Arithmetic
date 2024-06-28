package com.du.algorithm.string;

/**
 * KMP算法解决的问题
 * 字符串str1和str2，str1是否包含str2，
 * 如果包含返回str2在str1中开始的位置。如何做到时间复杂度O(N)完成?
 *
 * @Author : Du YingJie (2548425238@qq.com)
 * @Description : [KMP算法]
 * @Version : [v1.1]
 * @Date : [2022/5/29 17:31]
 */
public class KMP {

    /**
     * KMP算法,求解str2在str1中开始的位置
     *
     * @param s 字符串1
     * @param m 字符串2
     * @return index位置 如果找不到 返回-1
     */
    public int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) return -1;
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        // str1指针
        int i1 = 0;
        // str2指针
        int i2 = 0;
        // 获取str2的next数组  O(M)
        int[] next = getNextArray(str2);
        // O(N)
        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) {
                // 相等时++
                i1++;
                i2++;
            } else if (i2 == 0) {
                // next[i2] == -1 i2最长前后缀=-1,只能移动i1,这个时候i2不动
                i1++;
            } else {
                i2 = next[i2];
            }
        }
        // i1 或者 i2越界; 如果i2越界了说明找到了结果,否则没找到返回-1
        return i2 == str2.length ? i1 - i2 : -1;
    }

    /**
     * 计算next数组
     *
     * @param str2 待查找的数组
     * @return next数组
     */
    private static int[] getNextArray(char[] str2) {
        if (str2.length == 1) return new int[]{-1};
        int[] next = new int[str2.length];
        // 0 位置 next = -1
        next[0] = -1;
        // 1 位置 next = 0
        next[1] = 0;
        // 从下标为2的位置开始求next
        int i = 2;
        // i - 1跟哪个位置的字符比 一开始i = 2, next[2 - 1] = 0,所以cn = 0
        // cn既是next[i - 1]的值, 也是str2[cn ( i-1 要跟字符串比较的位置 ) ]
        int cn = 0;
        while (i < str2.length) {
            // str2[i - 1]的位置是否等于str2[cn]位置的值
            if (str2[i - 1] == str2[cn]) {
                // 如果相等当前next[i] = next[i - 1] + 1;
                // next[i] = next[i - 1] + 1; i++; 可以优化代码为    cn 就是next[i - 1]的值
                next[i++] = ++cn;
            } else if (cn > 0) {
                // 如果不等于cn就跳到next[cn]的位置去
                cn = next[cn];
            } else {
                // 如果都不满足说明next[i] = 0;
                next[i] = 0;
            }
        }
        return next;
    }

}
