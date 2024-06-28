package com.du.algorithm.question;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Du YingJie (2548425238@qq.com)
 * @Description : [N皇后问题
 * 给定一个N xN的棋盘，要在棋盘上摆放N个皇后，
 * 并且满足N个皇后中任意两个皇后都不处于
 * 同一行、同一列、同一条斜线上(正斜线、反斜线)
 * ]
 * @Version : [v1.1]
 * @Date : [2022/5/11 22:23]
 */
public class NQueen {

    public static void main(String[] args) {
        List<List<String>> result = new ArrayList<>();
        // n皇后问题
        int n = 4;
        // 存放排好的皇后的位置
        int[] record = new int[n];
        List<List<String>> list = NQueen(0, n, result, record);
        System.out.println("N皇后方案数：" + list.size());
        // 打印N皇后
        for (List<String> stringList : list) {
            for (String s : stringList) {
                System.out.println(s);
            }
            System.out.println("-----------------------");
        }
    }

    /**
     * @param row    当前是第几行
     * @param n      几皇后
     * @param result 存放结果的集合
     * @return 结果集
     */
    public static List<List<String>> NQueen(int row, int n, List<List<String>> result, int[] record) {
        // 如果当前策略已经排好了，加到结果中去
        if (row == n) {
            result.add(arrayToList(record));
            return result;
        }
        for (int col = 0; col < n; col++) {
            // 试一下当前列能不能放皇后
            record[row] = col;
            // 如果可以就继续放下一个,否则把皇后放在下一列
            if (isValid(record, row)) {
                // 递归
                result = NQueen(row + 1, n, result, record);
            }
        }
        return result;
    }

    /**
     * 判断当前皇后跟之前的皇后位置有没有冲突
     *
     * @param record record[0]...record[row - 1]之前皇后的位置
     * @param row    当前行
     * @return 有效true else 无效 false
     */
    private static boolean isValid(int[] record, int row) {
        for (int i = 0; i < row; i++) {
            // 因为我们是按行来放的所有行肯定不会冲突,看一下列会不会冲突,跟斜线会不会冲突
            // 判断撇和捺方向, 是两个斜率为1和-1的直线, 则他们两个坐标 |y2 - y1| == |x2 - x1|
            if (record[i] == record[row] || Math.abs(row - i) == Math.abs(record[row] - record[i])) {
                return false;
            }
        }
        return true;
    }

    public static List<String> arrayToList(int[] record){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            StringBuilder buffer = new StringBuilder();
            for (int j = 0; j < record.length; j++) {
                if (j == record[i]){
                    buffer.append("Q ");
                }else {
                    buffer.append("* ");
                }
            }
            list.add(buffer.toString());
        }
        return list;
    }
}