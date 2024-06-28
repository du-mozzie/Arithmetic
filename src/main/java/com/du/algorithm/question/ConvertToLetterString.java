package com.du.algorithm.question;

/**
 * @Author : Du YingJie (2548425238@qq.com)
 * @Description : [
 * 规定1和A对应、2和B对应、3和C对应...
 * 那么一个数字字符串比如"111"，就可以转化为"AAA"、"KA"和"AK"。
 * 给定一个只有数字字符组成的字符串str，返回有多少种转化结果。
 * ]
 * @Version : [v1.1]
 * @Date : [2022/5/26 23:10]
 */
public class ConvertToLetterString {

    public static void main(String[] args) {
        int[] str = {1, 2, 7};
        System.out.println(process(str, 0));
    }

    /**
     * @param str 数字字符串
     * @param i   当前位置
     * @return 转换方案有几种
     */
    public static int process(int[] str, int i) {
        // 当前是0的时候不能转换,只能跟前面结合转换
        if (i < str.length && str[i] == 0) return 0;
        if (i >= str.length - 1) return 1;
        // 每个数字都可以单独转换
        int res = process(str, i + 1);
        // 数字组合转换,i 跟 i + 1转换, 需要 <= 26才行
        if (i + 1 < str.length && Integer.parseInt(str[i] + String.valueOf(str[i + 1])) <= 26) {
            res += process(str, i + 2);
        }
        return res;
    }
}
