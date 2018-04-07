package com.cxj.swordoffer;

/**
 * 问题描述：求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 * 思路：利用逻辑与的短路特性实现递归终止
 */
public class SumSolution {
    public int Sum_Solution(int n) {
        return n * (n + 1) / 2;
    }

    public int sum(int n) {
        int sum = n;
        boolean ans = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }

    public static void main(String[] args) {
        SumSolution ss = new SumSolution();
        System.out.println(ss.sum(10));
    }
}