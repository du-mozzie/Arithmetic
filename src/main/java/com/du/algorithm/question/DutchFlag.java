package com.du.algorithm.question;

/**
 * @Author : Du YingJie (2548425238@qq.com)
 * @Description : [荷兰国旗问题]
 * @Version : [v1.0]
 * @Date : [2022/3/2 17:06]
 */
public class DutchFlag {

    /**
    问题一
    给定一个数组arr，和一个数num，请把小于等于num的数放在数组的左边，
    大于num的数放在数组的右边。要求额外空间复杂度0(1)，时间复杂度0(N)

    问题二(荷兰国旗问题)
    给定一个数组arr，和一个数num，
    请把小于num的数放在数组的左边，等于num的数放在数组的中间，
    大于num的数放在数组的右边。要求额外空间复杂度0(1)，时间复杂度0(N)
    */
    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 3, 1, 4, 2, 1, 7, 3, 20};
        int[] result = answerTwo(arr, 3);
        for (int i : result) {
            System.out.print(i + "\t");
        }
    }

    private static int[] answerOne(int[] arr, int num) {
        int lessArea = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= num) {
                int temp = arr[i];
                arr[i] = arr[++lessArea];
                arr[lessArea] = temp;
            }
        }
        return arr;
    }

    private static int[] answerTwo(int[] arr, int num) {
        int lessArea = -1;
        int gtArea = arr.length;
        int i = 0;
        while (i < arr.length && i < gtArea) {
            if (arr[i] < num) {
                int temp = arr[i];
                arr[i] = arr[++lessArea];
                arr[lessArea] = temp;
                i++;
            } else if (arr[i] > num) {
                int temp = arr[i];
                arr[i] = arr[--gtArea];
                arr[gtArea] = temp;
            } else {
                i++;
            }
        }
        return arr;
    }
}
