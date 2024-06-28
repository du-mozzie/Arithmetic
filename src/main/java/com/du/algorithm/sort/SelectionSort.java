package com.du.algorithm.sort;

import com.du.algorithm.utils.ArraySortLogarithmicDetector;

import java.util.Arrays;

/**
 * @Author : Du YingJie (2548425238@qq.com)
 * @Description : [选择排序]
 * @Version : [v1.0]
 * @Date : [2022/3/1 8:35]
 */
public class SelectionSort {

    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            int[] randomArray = ArraySortLogarithmicDetector.generateRandomArray(100, 100);
            int[] copy = Arrays.copyOf(randomArray, randomArray.length);
            ArraySortLogarithmicDetector.rightMethod(copy);
            selectionSort(randomArray);
            if (!ArraySortLogarithmicDetector.isEqual(copy, randomArray)) {
                System.out.println("算法出错");
                break;
            }
        }
    }

    private static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}
