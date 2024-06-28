package com.du.algorithm.utils;

import java.util.Arrays;

/**
 * @Author : Du YingJie (2548425238@qq.com)
 * @Description : [对数器，测试使用工具类]
 * @Version : [v1.0]
 * @Date : [2022/3/3 1:08]
 */
public class ArraySortLogarithmicDetector {

    /**
     * Java Arrays.sort 排序
     *
     * @param arr 数组
     */
    public static void rightMethod(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     * 生成一个随机数组
     *
     * @param size  长度
     * @param value [value]的随机数
     * @return 一个随机数组
     */
    public static int[] generateRandomArrayByValue(int size, int value) {
        //Math.random() -> double [0,1)
        //(int) ((size + 1) * Math.random()) -> [0,size]整数
        // 生成长度随机[0, size]的数组
        int[] arr = new int[(int) ((size + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            // 一个随机数减去另一个随机数，生成[-value, value]的随机数
            arr[i] = (int) ((value + 1) * Math.random());
        }
        return arr;
    }

    /**
     * 生成一个随机数组
     *
     * @param size  长度
     * @param value [-value, value]的随机数
     * @return 一个随机数组
     */
    public static int[] generateRandomArray(int size, int value) {
        //Math.random() -> double [0,1)
        //(int) ((size + 1) * Math.random()) -> [0,size]整数
        // 生成长度随机[0, size]的数组
        int[] arr = new int[(int) ((size + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            // 一个随机数减去另一个随机数，生成[-value, value]的随机数
            arr[i] = (int) ((value + 1) * Math.random()) - (int) (value * Math.random());
        }
        return arr;
    }

    /**
     * 判断两个数组是否相等
     *
     * @param arr1 Arrays.sort 排序后的数组
     * @param arr2 自己写的代码  排序后的数组
     * @return 两个数组是否相等
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null))
            return false;
        if (arr1 == null && arr2 == null)
            return true;
        if (arr1.length != arr2.length)
            return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }
        return true;
    }
}
