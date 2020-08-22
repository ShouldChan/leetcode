package swordoffer;

import java.util.LinkedList;
import java.util.Queue;

public class TreeDepth {
    //    层次遍历来求深度
    public int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0, nextcount = 1, depth = 0;//nextcount记录每一层的节点个数 根节点这一层初始化nextcount为1
        while (queue.size() != 0) {
            TreeNode temp = queue.poll();
            count++;
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
            if (count == nextcount) {
                nextcount = queue.size();
                count = 0;
                depth++;
            }

        }
        return depth;
    }

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
        TreeDepth td = new TreeDepth();
        System.out.println(td.TreeDepth(node));
    }
}