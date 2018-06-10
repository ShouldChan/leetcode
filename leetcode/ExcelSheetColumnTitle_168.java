package com.cxj.leetcode;

public class ExcelSheetColumnTitle_168 {

    public String convertToTitle(int n) {
//        整合循环后的写法 因为要+‘A’，所以n要-1
        return n == 0 ? "" : convertToTitle((n - 1) / 26) + (char) ('A' + ((n - 1) % 26));
    }

    public String convertToTitle_loop(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            --n;
            sb.insert(0, (char) ('A' + (n % 26)));
            n /= 26;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ExcelSheetColumnTitle_168 es = new ExcelSheetColumnTitle_168();
        System.out.println(es.convertToTitle(676));
        StringBuffer sb = new StringBuffer();
        sb.insert(0, "23");
        sb.insert(0, "5");
        System.out.println(sb.toString());
        System.out.println(es.convertToTitle_loop(677));
    }
}