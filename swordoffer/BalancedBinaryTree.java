package com.cxj.swordoffer;

/**
 * 题目描述：输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 思路：
 * 平衡二叉树 一颗二叉树任意节点的左右子树高度不超过1
 * 1）root为空，height=0, balanced=false;
 * 2）左子树或者右子树不是平衡二叉树，返回false
 * 3）如果左子树和右子树都是平衡二叉树了就获取左右的高度,balanced=true
 */
public class BalancedBinaryTree {
    //    普通做法
    //    逻辑判断
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null)
            return false;
        if (!IsBalanced_Solution(root.left) || !IsBalanced_Solution(root.right))
            return false;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (Math.abs(left - right) <= 1) return true;
        else
            return false;
    }

    //    获取二叉树深度
    public int getDepth(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(getDepth(node.left), getDepth(node.right));
    }

//    优化剪枝的思想，效率更高
//    一边遍历一边判断是否平衡
//    public boolean IsBalanced_Solution(TreeNode root) {
//        return getDepth(root) != -1;
//    }
//
//    private int getDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int leftHeight = getDepth(root.left);
//        if (leftHeight == -1) {
//            return -1;
//        }
//        int rightHeight = getDepth(root.right);
//        if (rightHeight == -1) {
//            return -1;
//        }
//        return Math.abs(leftHeight - rightHeight) > 1 ? -1 : 1 + Math.max(leftHeight, rightHeight);
//    }

    public static void main(String[] args) {
        ReconstructBinaryTree rb = new ReconstructBinaryTree();
        /**
         *          1
         *        2    3
         *      4    5   6
         *        7     8
         *        左右子树的高度不超过1
         */
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode node = rb.reConstructBinaryTree(pre, in);
//        System.out.println(node.left.val);
        BalancedBinaryTree avl = new BalancedBinaryTree();
        System.out.println(avl.getDepth(node));
        System.out.println(avl.IsBalanced_Solution(node));
    }
}