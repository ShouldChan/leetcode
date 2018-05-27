package com.cxj.leetcode;

public class BalancedBinaryTree_110 {

    public int getDepth(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + Math.max(getDepth(node.left), getDepth(node.right));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return false;
        if (!isBalanced(root.left) || !isBalanced(root.right))
            return false;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (Math.abs(left - right) <= 1)
            return true;
        return false;
    }

    public static void main(String[] args) {
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
        BalancedBinaryTree_110 bt = new BalancedBinaryTree_110();
        System.out.println(bt.isBalanced(root));
    }
}