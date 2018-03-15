package com.cxj.leetcode;

public class LongestPalindromicSubstring_5 {
    // Time Limit exceed
    public String longestPalindrome(String s) {
        if (s == null)
            return null;
        if (s.length() <= 1)
            return s;
        int maxLen = 0;
        String longestStr = s.substring(0, 1);
        int length = s.length();
        int[][] table = new int[length][length];
        for (int i = 0; i < length; i++) {
            table[i][i] = 1;
        }
        // 双叠字的情况
        for (int i = 0; i <= length - 2; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                table[i][i + 1] = 1;
                longestStr = s.substring(i, i + 2);
            }
            // if (s.charAt(i) == s.charAt(i + 2)) {
            // table[i][i + 2] = 1;
            // longestStr = s.substring(i, i + 3);
            // }
        }
        // l为子串长度
        for (int l = 3; l <= length; l++) {
            for (int i = 0; i <= length - l; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    table[i][j] = table[i + 1][j - 1];
                    if (table[i][j] == 1) {
                        longestStr = s.substring(i, j + 1);
                    }
                } else {
                    table[i][j] = 0;
                }
            }
        }
        return longestStr;
    }

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

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LongestPalindromicSubstring_5 lp = new LongestPalindromicSubstring_5();
        String s = "cfsdfdsfaaa";
        String result = lp.centerExpend(s);
        System.out.println(result);

    }
}