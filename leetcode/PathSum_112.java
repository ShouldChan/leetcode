package com.cxj.leetcode;

/**
 * Description:
 * Given a binary tree and a sum, determine if the tree has a
 * root-to-leaf path such that adding up all the values along
 * the path equals the given sum.
 */
public class PathSum_112 {
    boolean result = false;

    public boolean hasPathSum(TreeNode root, int sum) {

        addPSum(root, 0, sum);
        return result;

    }

    public void addPSum(TreeNode root, int curNum, int sum) {
        if (root == null)
            return;
        curNum += root.val;
        if (root.left == null && root.right == null)
            if (curNum == sum)
                result = true;
        if (root.left != null)
            addPSum(root.left, curNum, sum);
        if (root.right != null)
            addPSum(root.right, curNum, sum);
    }

    public static void main(String[] args) {
        PathSum_112 ps=new PathSum_112();
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r2 = new TreeNode(2);
        TreeNode l1l1 = new TreeNode(3);
//        TreeNode l1r2 = new TreeNode(4);
        TreeNode r2l1 = new TreeNode(4);
        TreeNode r2r2 = new TreeNode(3);
        root.left = l1;
        root.right = r2;
        l1.left = l1l1;
//        l1.right = l1r2;
        r2.left = r2l1;
        r2.right = r2r2;
        System.out.println(ps.hasPathSum(root,7));
    }
}