package com.cxj.leetcode;

public class ReverseInteger_7 {

    public int reverse(int x) {
        if (x == 0)
            return 0;
        String s = Integer.toString(x);
        StringBuilder sb = new StringBuilder(s);

        StringBuilder resultSb = new StringBuilder();

        int j = sb.length() - 1;
        while (sb.charAt(j) == '0') {
            j--;
        }
        if (sb.charAt(0) == '-') {
            String str = sb.substring(1, j + 1);
            StringBuilder tempSb = new StringBuilder(str);
            tempSb.reverse();
            String halfStr = tempSb.toString();
            long result = Long.parseLong(halfStr.trim());
            result = 0 - result;
            if (result < Integer.MIN_VALUE)
                return 0;
            else {
                int resultLast = (int) result;
                return resultLast;
            }

        } else {
            String str = sb.substring(0, j + 1);
            StringBuilder tempSb = new StringBuilder(str);
            tempSb.reverse();
            String resultStr = tempSb.toString();
            long result = Long.parseLong(resultStr.trim());
            if (result > Integer.MAX_VALUE)
                return 0;
            else{
                int resultLast = (int)result;
                return resultLast;
            }

        }

    }


    public static void main(String[] args) {
        ReverseInteger_7 ri = new ReverseInteger_7();
        int result = ri.reverse(1534236469);
        System.out.println(result);
    }

}