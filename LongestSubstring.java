package com.cxj.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// PS: the longest substring is without repeating
// BF algorithm time complexity: O(n^3)
class BruteForce {
	public int lengthOfLongestSubstring(String s) {
		int n = s.length();
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j <= n; j++) {
				// if the i_th has repeat character, it means the "if" won't do
				// and ans is as a temp variable to store the bigest one.
				if (allUnique(s, i, j))
					ans = Math.max(ans, j - i);
				// System.out.println(ans);
			}
		}
		return ans;
	}

	public boolean allUnique(String s, int start, int end) {
		Set<Character> set = new HashSet<>();
		for (int i = start; i < end; i++) {
			Character ch = s.charAt(i);
			// System.out.println(ch);
			if (set.contains(ch))
				return false;
			set.add(ch);
		}
		// System.out.println(set);
		return true;
	}
}

public class LongestSubstring {
	public int lengthofLongestSubstring(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int ans = 0, i = 0, j = 0;
		while (i < n && j < n) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				ans = Math.max(ans, j - i);
			} else {
				set.remove(s.charAt(i++));
			}
		}
		return ans;
	}

	public int optimizeLenofLongestSubstring(String s) {
		int n = s.length();
		int ans = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0, j = 0; j < n; j++) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);
			}
			ans = Math.max(ans, j - i + 1);
			map.put(s.charAt(j), j + 1);
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BruteForce bf = new BruteForce();
		int result = bf.lengthOfLongestSubstring("pwwkew");
		// System.out.println(result);
		LongestSubstring ls = new LongestSubstring();
		result = ls.lengthofLongestSubstring("abcabcbb");
		result = ls.optimizeLenofLongestSubstring("pwwkew");
		System.out.println(result);
	}

}
