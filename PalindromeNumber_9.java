package com.cxj.leetcode;

// 数字翻转
public class PalindromeNumber_9 {
    public boolean isPalindrome(int x) {
        int tmp = x;
        int res = 0;
        if (x < 0)
            return false;
        while (tmp != 0) {
            res = res * 10 + tmp % 10;
            tmp /= 10;
        }

        return x == res;
    }

    public static void main(String[] args) {
        PalindromeNumber_9 pn = new PalindromeNumber_9();
        int[] testArray = {12321, -456,123421,998558};
        for(int i=0;i<testArray.length;i++){
            System.out.println(pn.isPalindrome(testArray[i]));
        }

    }
}