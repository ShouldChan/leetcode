package com.cxj.leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class PlusOne_66 {
    public int[] plusOne(int[] digits) {
        int carry=1;
        for(int i=digits.length-1;i>=0;i--){
            int val=digits[i]+carry;
            if(val==10)
                carry=1;
            else
                carry=0;
            digits[i]=val%10;
            if(carry==0)
                break;

        }
        if(carry==1){
            digits=new int[digits.length+1];
            digits[0]=1;
        }
        return digits;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int len=sc.nextInt();
        int[] digits=new int[len];
        for(int i=0;i<len;i++){
            digits[i]=sc.nextInt();
        }
//        int[] digits={9,8,7,6,5,4,3,2,1,0};
//        int[] digits={9,9,9,9};
        PlusOne_66 po=new PlusOne_66();
        int[] result=po.plusOne(digits);
        System.out.println(Arrays.toString(result));
    }
}