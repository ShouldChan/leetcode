package JiebiTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/7/30
 * @description 二叉树遍历
 */
public class ReconstructBinaryTree {
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
        System.out.println("LevelTranse:\n");
        rb.levelTranse(node);
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

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0 || pre.length != in.length) {
            return null;
        }
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

    /**
     * 层次遍历
     *
     * @param node
     */
    public void levelTranse(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (queue.size() != 0) {
            TreeNode tmp = queue.poll();
            System.out.println(tmp.val);
            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
            }
        }
    }

    /**
     * 二叉树先序遍历
     *
     * @param node
     */
    public void preOrder(TreeNode node) {
        if (node != null) {
            System.out.println(node.val);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 二叉树中序遍历
     *
     * @param node
     */
    public void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.val);
            inOrder(node.right);
        }
    }

    public void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.val);
        }
    }

}
