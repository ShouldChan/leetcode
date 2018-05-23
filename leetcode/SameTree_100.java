package com.cxj.leetcode;

/**
 * Input:     1         1
 * / \       / \
 * 2   3     2   3
 * <p>
 * [1,2,3],   [1,2,3]
 * <p>
 * Output: true
 */
public class SameTree_100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val == q.val) {
            boolean f1 = isSameTree(p.left, q.left);
            boolean f2 = isSameTree(p.right, q.right);
            return f1 && f2;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        SameTree_100 st = new SameTree_100();
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        TreeNode q = new TreeNode(1);
//        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        System.out.println(st.isSameTree(p, q));
    }
}