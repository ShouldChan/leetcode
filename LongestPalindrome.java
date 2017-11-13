package com.cxj.leetcode;

public class LongestPalindrome {

	public String longestPalindrome(String s) {
		if (s == null)
			return null;
		if (s.length() <= 1)
			return s;
		int maxLen = 0;
		String longestStr = s.substring(0,1);
		int length = s.length();
		int[][] table = new int[length][length];
		for (int i = 0; i < length; i++) {
			table[i][i] = 1;
		}
		// 叠字的情况
		for (int i = 0; i < length - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				table[i][i + 1] = 1;
				longestStr = s.substring(i, i + 2);
			}
		}
		// l为子串长度
		for (int l = 3; l < length; l++) {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestPalindrome lp = new LongestPalindrome();
		String s = "abcda";
		String result = lp.longestPalindrome(s);
		System.out.println(result);
	}

}
