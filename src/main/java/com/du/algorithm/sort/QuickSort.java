package com.du.algorithm.sort;

import com.du.algorithm.utils.ArraySortLogarithmicDetector;

import java.util.Arrays;

/**
 * @Author : Du YingJie (2548425238@qq.com)
 * @Description : [快速排序]
 * @Version : [v1.0]
 * @Date : [2022/3/2 18:19]
 */
public class QuickSort {

    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            int[] randomArray = ArraySortLogarithmicDetector.generateRandomArray(100, 100);
            int[] copy = Arrays.copyOf(randomArray, randomArray.length);
            ArraySortLogarithmicDetector.rightMethod(copy);
            quickSort(randomArray);
            if (!ArraySortLogarithmicDetector.isEqual(copy, randomArray)) {
                System.out.println("算法出错");
                break;
            }
        }
    }

    private static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    private static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[]{less + 1, more};
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
