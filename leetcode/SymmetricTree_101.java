package com.cxj.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p>
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 */
public class SymmetricTree_101 {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    public boolean isSymmetric_Queue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (queue.size() != 0) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            queue.offer(t1.left);
            queue.offer(t2.right);
            queue.offer(t1.right);
            queue.offer(t2.left);
        }
        return true;
    }

    public static void main(String[] args) {
        SymmetricTree_101 st = new SymmetricTree_101();
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r2 = new TreeNode(2);
        TreeNode l1l1 = new TreeNode(3);
        TreeNode l1r2 = new TreeNode(4);
        TreeNode r2l1 = new TreeNode(4);
        TreeNode r2r2 = new TreeNode(3);
        root.left = l1;
        root.right = r2;
        l1.left = l1l1;
        l1.right = l1r2;
        r2.left = r2l1;
        r2.right = r2r2;
        System.out.println(st.isSymmetric(root));
        System.out.println(st.isSymmetric_Queue(root));
    }
}