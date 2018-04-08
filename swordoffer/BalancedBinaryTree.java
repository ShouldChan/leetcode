package com.cxj.swordoffer;

/**
 * 题目描述：输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 思路：
 * 1）root为空，height=0, balanced=false;
 * 2）root->left==null&&root->right==null,height=1,balanced=true
 * 3）对左右子树递归，返回最高子树高度+1,balanced=true;高度差>1，false
 */
public class BalancedBinaryTree {


    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getDepth(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getDepth(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        return Math.abs(leftHeight - rightHeight) > 1 ? -1 : 1 + Math.max(leftHeight, rightHeight);
    }

//    public int getDepth(TreeNode node) {
//        if (node == null)
//            return 0;
////        else if (node.left == null && node.right == null)
////            return 1;
//        else {
//            int leftHeight = getDepth(node.left);
//            int rightHeight = getDepth(node.right);
//            System.out.println("left\t" + leftHeight);
//            int height = (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
//            return Math.abs(leftHeight - rightHeight) > 1 ? 0 : height;
////            return height;
//        }
//    }
//
//    public boolean judge_AVL(TreeNode node) {
//        System.out.println(getDepth(node));
//        return getDepth(node) != 0;
//    }

    public static void main(String[] args) {
        ReconstructBinaryTree rb = new ReconstructBinaryTree();
        /**
         *          1
         *        2    3
         *      4    5   6
         *        7     8
         */
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode node = rb.reConstructBinaryTree(pre, in);
        System.out.println(node.left.val);
        BalancedBinaryTree avl = new BalancedBinaryTree();
        System.out.println(avl.getDepth(node));
        System.out.println(avl.IsBalanced_Solution(node));
    }
}