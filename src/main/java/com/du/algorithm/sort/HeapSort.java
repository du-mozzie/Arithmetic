package com.du.algorithm.sort;

import com.du.algorithm.utils.ArraySortLogarithmicDetector;

import java.util.Arrays;

/**
 * @Author : Du YingJie (2548425238@qq.com)
 * @Description : [堆排序]
 * @Version : [v1.0]
 * @Date : [2022/3/3 16:08]
 */
public class HeapSort {

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            int[] sort = ArraySortLogarithmicDetector.generateRandomArray(100, 100);
            int[] right = Arrays.copyOf(sort, sort.length);
            ArraySortLogarithmicDetector.rightMethod(right);
            heapSort(sort);
            if (!ArraySortLogarithmicDetector.isEqual(right, sort)) {
                System.out.println("算法出错");
                break;
            }
        }
    }

    // TODO 目前只有实现正数的排序
    private static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        // 把数组变为大根堆,数是一个个给的
        //for (int i = 0; i < arr.length; i++) {
        //    heapInsert(arr, i);
        //}

        // 把数组变为大根堆,数是直接给的一个数组
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }

        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    // 某个数index是否比它的父节点的数小，如果比父节点的数大，跟父节点交换位置
    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 某个数在index位置，能否往下移动(是否比子节点的数大)
    private static void heapify(int[] arr, int index, int heapSize) {
        // 左子节点
        int left = index * 2 + 1;
        while (left < heapSize) {
            // 比较左子节点跟右子节点，比较大的数等下跟父节点进行比较，先判断右子节点是否有越界
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
