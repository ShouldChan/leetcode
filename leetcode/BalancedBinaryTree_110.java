package com.cxj.leetcode;

public class BalancedBinaryTree_110 {

    public int getDepth(TreeNode node) {
        if (node == null)
            return 0;
        int leftHeight = getDepth(node.left);
        if (leftHeight == -1)
            return -1;
        int rightHeight = getDepth(node.right);
        if (rightHeight == -1)
            return -1;
        return Math.abs(leftHeight - rightHeight) > 1 ? -1 : 1 + Math.max(leftHeight, rightHeight);
    }

    public boolean isBalanced(TreeNode root) {
        return getDepth(root) != -1;
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