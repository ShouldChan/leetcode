package com.cxj.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 * 解题思路：每行两端为1，中间的元素是上一行的两两相邻的元素相加得到的
 */
public class PascalsTriangle_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> curlist = new ArrayList<>();
            if (i == 1)
                curlist.add(1);
            else if (i == 2) {
                curlist.add(1);
                curlist.add(1);
            } else if (i > 2) {
                curlist.add(1);
                List<Integer> last = lists.get(lists.size() - 1);
                for (int j = 0; j < last.size() - 1; j++) {
                    curlist.add(last.get(j) + last.get(j + 1));
                }
                curlist.add(1);
            }
            lists.add(curlist);
        }
        return lists;
    }

    public static void main(String[] args) {
        PascalsTriangle_118 pt=new PascalsTriangle_118();
        List<List<Integer>> lists=pt.generate(5);
        System.out.println(lists);
    }

}