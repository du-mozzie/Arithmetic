package com.du.algorithm.question;

/**
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 * <p>
 * 返回 你可以获得的最大乘积 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 * <p>
 * 输入: n = 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 *
 * @author : Du
 * @date : [2024/6/28 15:32]
 */
public class IntegerBreak {

    public static void main(String[] args) {
        for (int i = 2; i < 20; i++) {
            // 随机数
            int p1 = integerBreak(i);
            int p2 = dp(i);
            if (p1 != p2) {
                System.out.println("error");
            }
        }
        // System.out.println(integerBreak(31));
    }

    public static int integerBreak(int n) {
        return process(n);
    }

    private static int process(int rest) {
        if (rest == 1) {
            return 1;
        }
        int res = 0;
        for (int i = 1; i < rest; i++) {
            res = Math.max(res, i * Math.max(rest - i, process(rest - i)));
        }
        return res;
    }
    
    public static int dp(int n){
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int res = 0;
            for (int j = 1; j < i; j++) {
                res = Math.max(res, j * Math.max(i - j, dp[i - j]));
            }
            dp[i] = res;
        }
        return dp[n];
    }
}
