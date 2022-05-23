package com.du.algorithm.sort;

import com.du.algorithm.utils.ArraySortLogarithmicDetector;

import java.util.Arrays;

/**
 * @Author : Du YingJie (2548425238@qq.com)
 * @Description : [插入排序]
 * @Version : [v1.0]
 * @Date : [2022/3/1 15:02]
 */
public class InsertionSort {

    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            int[] randomArray = ArraySortLogarithmicDetector.generateRandomArray(100, 100);
            int[] copy = Arrays.copyOf(randomArray, randomArray.length);
            ArraySortLogarithmicDetector.rightMethod(copy);
            insertionSort(randomArray);
            if (!ArraySortLogarithmicDetector.isEqual(copy, randomArray)) {
                System.out.println("算法出错");
                break;
            }
        }
    }

    private static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                arr[j] ^= arr[j + 1];
                arr[j + 1] ^= arr[j];
                arr[j] ^= arr[j + 1];
            }
        }
    }
}
