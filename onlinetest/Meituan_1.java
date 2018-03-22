package com.cxj.onlinetest;

import java.util.Scanner;

public class Meituan_1 {
    public int compare(String s, String t) {
        if (s.length() < t.length()) {
            String temp = s;
            t = temp;
            s = t;
        }
        char[] ss, tt;
        ss = s.toCharArray();
        tt = t.toCharArray();

        int count = 0;
        for (int i = 0; i < ss.length - tt.length + 1; i++) {
            count += dis(ss, i, tt);
        }
        return count;
    }


    public int dis(char[] ss, int start, char[] tt) {
        int count = 0;
        for (int i = 0; i < tt.length; i++) {
            if (ss[i + start] != tt[i])
                count += 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Meituan_1 mt = new Meituan_1();

        Scanner in=new Scanner(System.in);
        String s=in.nextLine();
        String t=in.nextLine();
        int result = mt.compare(s,t);
        System.out.println(result);

    }
}