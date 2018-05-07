package com.cxj.leetcode;

import java.util.Scanner;

/**
 * 在java中的Math类中有三种方法对浮点数取整
 floor //向下取整
 ceil //向上取整
 round //四舍五入取整
 */
public class SqrtX_69 {
    public int mySqrt(int x){
        double result= Math.sqrt(x);
        return (int)Math.floor(result);

    }
    public static void main(String[] args) {
        SqrtX_69 sx=new SqrtX_69();
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        System.out.println(sx.mySqrt(x));
    }
}