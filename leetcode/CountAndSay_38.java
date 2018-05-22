package com.cxj.leetcode;

//useless problem
public class CountAndSay_38 {
    public String countAndSay(int n) {
        StringBuilder cur = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            StringBuilder pre = cur;
            cur = new StringBuilder();
            for (int j = 0, count = 1; j < pre.length(); j++) {
                if (j == pre.length()-1 || pre.charAt(j) != pre.charAt(j+1)) {
                    cur.append(count).append(pre.charAt(j));
                    count = 1;
                } else count++;
            }
        }
        return cur.toString();

    }

    public static void main(String[] args) {
        CountAndSay_38 cas=new CountAndSay_38();
        System.out.println(cas.countAndSay(1211));
    }
}