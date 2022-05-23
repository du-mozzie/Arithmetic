package com.du.algorithm.question;

/**
 * @Author : Du YingJie (2548425238@qq.com)
 * @Description : [求小和问题，一个数组中，右边的数比左边的数大的数的和，求整个数组的小和]
 * @Version : [v1.0]
 * @Date : [2022/3/2 0:02]
 */
public class SmallSum {

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 1, 6, 20};
        System.out.println(process(arr, 0, arr.length - 1));
    }

    public static int process(int[] arr, int l, int r) {
        if (l == r) return 0;
        int mid = l + ((r - l) >> 1);
        return process(arr, l, mid) + process(arr, mid + 1, r) + merge(arr, mid, l, r);
    }

    private static int merge(int[] arr, int mid, int l, int r) {
        int[] help = new int[r - l + 1];
        int i = 0, p1 = l, p2 = mid + 1, res = 0;
        while (p1 <= mid && p2 <= r) {
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        return res;
    }

}
