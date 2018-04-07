package com.cxj.swordoffer;

/**
 * 题目描述
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Exponent {
    public static double Power(double base, int exponent) {
        double result = 1;
        for (int i = 0; i < Math.abs(exponent); i++) {
            result *= base;
        }
        if (exponent < 0)
            result = 1 / result;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Power(2.5,-2));
    }
}