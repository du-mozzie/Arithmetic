package com.du.algorithm.question;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Du YingJie (2548425238@qq.com)
 * @Description : [
 * <p>
 * 在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，
 * 盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。
 * 移动圆盘时受到以下限制:
 * (1) 每次只能移动一个盘子;
 * (2) 盘子只能从柱子顶端滑出移到下一根柱子;
 * (3) 盘子只能叠在比它大的盘子上。
 * <p>
 * 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
 * <p>
 * 你需要原地修改栈。
 * @Version : [v1.1]
 * @Date : [2022/5/26 14:25]
 */
public class Hanota {

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(2);
        A.add(1);
        A.add(0);
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        movePlant(A.size(), A, B, C);
        for (int i = C.size() - 1; i >= 0; i--) {
            System.out.println(C.get(i));
        }
    }

    /**
     * @param size      需要移动的盘子的数量
     * @param start     起始的柱子
     * @param auxiliary 辅助柱子
     * @param target    目标柱子
     */
    public static void movePlant(int size, List<Integer> start, List<Integer> auxiliary, List<Integer> target) {
        //当只剩一个盘子时，直接将它从第一个柱子移动到第三个柱子
        if (size == 1) {
            target.add(start.remove(start.size() - 1));
            return;
        }
        //首先将 n-1 个盘子，从第一个柱子移动到第二个柱子
        movePlant(size - 1, start, target, auxiliary);
        //然后将最后一个盘子移动到第三个柱子上
        target.add(start.remove(start.size() - 1));
        //最后将第二个柱子上的 n-1 个盘子，移动到第三个柱子上
        movePlant(size - 1, auxiliary, start, target);

    }
}
