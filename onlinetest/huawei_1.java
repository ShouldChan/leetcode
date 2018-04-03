package com.cxj.onlinetest;

public class huawei_1 {
    // center expension
    public String centerExpend(String s) {
        if (s.length() == 0)
            return null;
        if (s.length() == 1)
            return s;
        String longest = s.substring(0, 1);
        for (int i = 0; i <= s.length() - 1; i++) {
            // Odd: "abcba"
            String tmp = getlongestSubstring(s, i, i);
            if (tmp.length() > longest.length())
                longest = tmp;
            // Even: "abba"
            tmp=getlongestSubstring(s, i, i+1);
            if(tmp.length()>longest.length())
                longest=tmp;
        }
        return longest;
    }

    public String getlongestSubstring(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        String subs = s.substring(begin + 1, end);
        return subs;
    }

    public static void main(String[] args) {
        huawei_1 hw=new huawei_1();
        String result=hw.centerExpend("12321abc");
        System.out.println(result.length());
    }


}