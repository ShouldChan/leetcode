package com.cxj.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidPalindrome_125 {
    public boolean isPalindrome(String s) {
        if (s.isEmpty())
            return true;
        String regEx = "[^a-zA-Z0-9]";
        Pattern pattern = Pattern.compile(regEx);

        Matcher matcher = pattern.matcher(s);


        String str = matcher.replaceAll("");
        if (str.isEmpty())
            return true;
        str = str.toLowerCase();
        System.out.println(str);
        int begin = 0;
        int end = str.length() - 1;
        while (begin != end && begin < str.length() && end >= 0) {
            if (str.charAt(begin) != str.charAt(end))
                return false;
            begin++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome_125 vp = new ValidPalindrome_125();
        System.out.println(vp.isPalindrome("0P"));
    }
}