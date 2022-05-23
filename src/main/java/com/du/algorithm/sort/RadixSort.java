package com.du.algorithm.sort;

import com.du.algorithm.utils.ArraySortLogarithmicDetector;

import java.util.Arrays;

/**
 * @Author : Du YingJie (2548425238@qq.com)
 * @Description : [基数排序]
 * @Version : [v1.0]
 * @Date : [2022/3/4 12:57]
 */
public class RadixSort {

    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            int[] sort = ArraySortLogarithmicDetector.generateRandomArrayByValue(100, 100);
            int[] right = Arrays.copyOf(sort, sort.length);
            ArraySortLogarithmicDetector.rightMethod(right);
            radixSort(sort);
            if (!ArraySortLogarithmicDetector.isEqual(right, sort)) {
                System.out.println("算法出错");
                break;
            }
        }
    }

    private static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        radixSort(arr, 0, arr.length - 1, maxBits(arr, 0, arr.length - 1));
    }

    // 获取排序区间最大的数的位数
    private static int maxBits(int[] arr, int l, int r) {
        int max = Integer.MIN_VALUE;
        for (int i = l; i < r; i++) {
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    private static void radixSort(int[] arr, int l, int r, int digit) {
        // 10进制
        final int radix = 10;
        int i, j;
        // 有多少个数准备多少个空间
        int[] bucket = new int[r - l + 1];
        // 最大有几位就进出几次
        for (int d = 1; d <= digit; d++) {
            // 10个空间
            // count[0] 当前位(d位)是e的数字有多少个
            // count[1] 当前位(d位)是(0和1)的数字有多少个
            // count[2] 当前位(d位)是(0、1和2)的数字有多少个count[i]当前位(d位)是(0~i)的数字有多少个
            int[] count = new int[radix];
            // 计算d位0-9的数字有几个
            for (i = l; i <= r; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }
            // 计算1-9 d位<=自己的数有几个
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }
            // 将arr数组按count个数放入bucket中
            for (i = r; i >= l; i--) {
                j = getDigit(arr[i], d);
                // 将arr[i] 放入bucket对应位置
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }
            // 将bucket排好数字重新放入数组中
            for (i = l, j = 0; i <= r; i++, j++) {
                arr[i] = bucket[i];
            }
        }
    }

    /**
     * 计算数字x d位的数字
     *
     * @param x 需要计算的数字
     * @param d 第几位
     * @return 该位的数字
     */
    private static int getDigit(int x, int d) {
        return Math.abs(((x / ((int) Math.pow(10, d - 1))) % 10));
    }
}
