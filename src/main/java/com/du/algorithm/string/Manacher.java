package com.du.algorithm.string;

/**
 * Manacher算法解决的问题
 * 字符串str中，最长回文子串的长度如何求解?
 * 如何做到时间复杂度0(N)完成?
 *
 * @Author : Du YingJie (2548425238@qq.com)
 * @Description : [Manacher算法]
 * @Version : [v1.1]
 * @Date : [2022/5/30 13:03]
 */
public class Manacher {

    /**
     * 计算字符串最长回文长度
     *
     * @param s 字符串
     * @return 最长长度
     */
    public static int maxLcpsLength(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] str = manacherString(s);
        // 回文半径数组
        int[] pArr = new int[str.length];
        // 回文右边界的再往右一个位置  最右的有效区是R-1位置
        int R = -1;
        // 中心
        int C = -1;
        // 扩出来的最大值
        int max = Integer.MIN_VALUE;
        // 每一个位置都求回文半径
        for (int i = 0; i != str.length; i++) {
            // i至少的回文区域, 先给pArr[i]
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            // 判断当前i至少的回文区域是不是在数组范围内
            while (i + pArr[i] < str.length && i - pArr[i] > -1) {
                // 判断i的左半径范围外第一个字符 跟 右半径范围外第一个字符 是不是相等
                if (str[i + pArr[i]] == str[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > R) {
                // 更新R C
                R = i + pArr[i];
                C = i;
            }
            // 记录最大值
            max = Math.max(max, pArr[i]);
        }
        // 处理串的半径 跟原串的关系 半径 - 1
        return max - 1;
    }

    /**
     * 将给定的串添加#, 1221 -> #1#2#2#1#
     *
     * @param s 要转换的字符串
     * @return 转换后的字符数组
     */
    public static char[] manacherString(String s) {
        char[] charArr = new char[s.length() * 2 + 1];
        char[] str = s.toCharArray();
        int index = 0;
        for (int i = 0; i < charArr.length; i++) {
            charArr[i] = (i & 1) == 0 ? '#' : str[index++];
        }
        return charArr;
    }

}
