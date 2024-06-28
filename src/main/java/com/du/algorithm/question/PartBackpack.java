package com.du.algorithm.question;

/**
 * @Author : Du YingJie (2548425238@qq.com)
 * @Description : [部分背包]
 * @Version : [v1.1]
 * @Date : [2022/5/15 18:11]
 */
public class PartBackpack {

    // 物品数量
    private final static int N = 5;

    // 背包容量
    private final static int W = 100;

    // 物品价值数组
    private final static int[] v = {0, 65, 20, 30, 60, 40};

    // 物品重量数组
    private final static int[] w = {0, 30, 10, 20, 50, 40};

    // 物品单位价值
    private final static double[] vm = new double[N + 1];

    // 存放结果数组
    private final static double[] ANSWER = new double[N + 1];

    public static void main(String[] args) {
        for (int i = 1; i < N; i++) {
            vm[i] = (double) v[i] / w[i];
        }
        System.out.println(maxValue(v, w, vm));
        for (int i = 1; i < N; i++) {
            System.out.printf("%.1f ", ANSWER[i]);
        }
    }

    private static double maxValue(int[] v, int[] w, double[] vm) {
        double result = 0.0;
        int tempW = W;
        for (int i = 1; i < N; i++) {
            if (tempW == 0) break;
            // 如果能全装就全部装进去
            if (tempW >= w[i]) {
                result += v[i];
                tempW -= w[i];
                ANSWER[i] = 1;
            } else {
                // 不能全装的时候装部分
                double part = tempW * ((double) v[i] / w[i]);
                result += part;
                tempW = 0;
                ANSWER[i] = part / v[i];
            }
        }
        return result;
    }
}
