package com.cxj.leetcode;

public class ExcelSheetColumnNumber_171 {
    public int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result * 26 + (s.charAt(i) - 'A' + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber_171 es = new ExcelSheetColumnNumber_171();
        System.out.println(es.titleToNumber("YZ"));
    }
}