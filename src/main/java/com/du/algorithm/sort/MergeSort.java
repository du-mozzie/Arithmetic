package com.du.algorithm.sort;

import com.du.algorithm.utils.ArraySortLogarithmicDetector;

import java.util.Arrays;

/**
 * @Author : Du YingJie (2548425238@qq.com)
 * @Description : [归并排序]
 * @Version : [v1.0]
 * @Date : [2022/3/1 19:33]
 */
public class MergeSort {

    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            int[] randomArray = ArraySortLogarithmicDetector.generateRandomArray(100, 100);
            int[] copy = Arrays.copyOf(randomArray, randomArray.length);
            ArraySortLogarithmicDetector.rightMethod(copy);
            mergeSort(randomArray);
            if (!ArraySortLogarithmicDetector.isEqual(copy, randomArray)) {
                System.out.println("算法出错");
                break;
            }
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int l, int r) {
        if (l == r) return;
        int mid = l + ((r - l) >> 1);
        process(arr, l, mid);
        process(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }
}