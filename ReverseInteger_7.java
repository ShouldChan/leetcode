package com.cxj.leetcode;

public class ReverseInteger_7 {

    public int reverse(int x) {
        String s = Integer.toString(x);
        StringBuilder sb = new StringBuilder(s);

        StringBuilder resultSb = new StringBuilder();
        //1.until s[s.length()-1]!="0" (first)
        int j = sb.length() - 1;
        while (sb.charAt(j) == '0') {
            j--;
        }
        if (sb.charAt(0) == '-') {
            String str = sb.substring(1, j+1);
            StringBuilder tempSb = new StringBuilder(str);
            tempSb.reverse();
            String halfStr=tempSb.toString();
            int result=Integer.parseInt(halfStr);
            result=0-result;
            return result;

        } else {
            String str = sb.substring(0, j+1);
            StringBuilder tempSb = new StringBuilder(str);
            tempSb.reverse();
            String resultStr=tempSb.toString();
            int result=Integer.parseInt(resultStr);
            return result;
        }

    }


    public static void main(String[] args) {
        ReverseInteger_7 ri = new ReverseInteger_7();
        int result = ri.reverse(-1234230);
        System.out.println(result);
    }

}