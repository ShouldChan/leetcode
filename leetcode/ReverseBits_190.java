package com.cxj.leetcode;

public class ReverseBits_190 {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n&1;
            n >>>= 1;
            if (i < 31) {
                result <<= 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseBits_190 rb = new ReverseBits_190();
        System.out.println(Integer.toBinaryString(10));
        int result=rb.reverseBits(10);
        System.out.println(Integer.toBinaryString(result));

    }
}