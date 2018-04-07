package com.cxj.swordoffer;

/**
 * 问题描述：求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 * 思路：n(n+1)/2
 */
public class SumSolution {
    public int Sum_Solution(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        SumSolution ss = new SumSolution();
        System.out.println(ss.Sum_Solution(10));
    }
}