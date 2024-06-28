package com.du.algorithm.question;

/**
 * @Author : Du YingJie (2548425238@qq.com)
 * @Description : [01背包问题]
 * @Version : [v1.1]
 * @Date : [2022/5/14 20:55]
 */
public class ZeroOneBackpack {

    // 物品数量
    private final static int N = 4;

    // 背包容量
    private final static int W = 5;

    // 物品价值数组
    private final static int[] v = {0, 2, 4, 5, 6};

    // 物品重量数组
    private final static int[] w = {0, 1, 2, 3, 4};

    // 存放01背包问题答案数组
    private final static int[][] RESULT = new int[N + 1][W + 1];

    public static void main(String[] args) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                RESULT[i][j] = RESULT[i - 1][j];
                // 判断当前背包容量是否还能装的下第i个物品
                if (j >= w[i]) {
                    RESULT[i][j] = Math.max(RESULT[i][j], RESULT[i - 1][j - w[i]] + v[i]);
                }
            }
        }
        System.out.println(RESULT[N][W]);
        for (int i = 0; i < RESULT.length; i++) {
            for (int j = 0; j < RESULT[i].length; j++) {
                System.out.print(RESULT[i][j] + "\t");
            }
            System.out.println();
        }
    }
}