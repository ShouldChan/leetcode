package com.cxj.leetcode;

public class Numberof1Bits_191 {
    public int hammingWeight(int n) {
        int flag = 1;
        int count = 0;
        while (flag != 0) {
            if ((flag & n) != 0)
                count++;
            flag <<= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Numberof1Bits_191 nb = new Numberof1Bits_191();
        System.out.println(nb.hammingWeight(128));
    }
}