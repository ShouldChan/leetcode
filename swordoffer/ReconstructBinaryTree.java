package com.cxj.swordoffer;

import java.util.Arrays;

/**
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * Arrays.copyOfRange(T[] origin, int from,int to)
 * 将一个原始数组从小标from开始复制 直至小标to，生成一个新数组
 */
public class ReconstructBinaryTree {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0 || pre.length != in.length)
            return null;
        TreeNode node = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) {
                node.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1),
                        Arrays.copyOfRange(in, 0, i));
                node.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length),
                        Arrays.copyOfRange(in, i + 1, in.length));
            }
        }
        return node;
    }

    //    递归实现二叉树先序遍历
    public void preOrder(TreeNode node) {
        if (node != null) {
            System.out.println(node.val);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    //    递归实现二叉树中序遍历
    public void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.val);
            inOrder(node.right);
        }
    }

    //    递归实现二叉树后序遍历
    public void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.val);
        }
    }

    //    使用队列实现二叉树层次遍历
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

//        层次遍历

//        先序遍历
        System.out.println("PreOrder:\n");
        rb.preOrder(node);

//        中序遍历
        System.out.println("InOrder:\n");
        rb.inOrder(node);

//        后序遍历
        System.out.println("PostOrder:\n");
        rb.postOrder(node);
    }
}