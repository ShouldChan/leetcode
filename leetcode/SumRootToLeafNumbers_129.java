package com.cxj.leetcode;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * <p>
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * <p>
 * Find the total sum of all root-to-leaf numbers.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3]
 * 1
 * / \
 * 2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * Example 2:
 * <p>
 * Input: [4,9,0,5,1]
 * 4
 * / \
 * 9   0
 * / \
 * 5   1
 * Output: 1026
 * Explanation:
 * The root-to-leaf path 4->9->5 represents the number 495.
 * The root-to-leaf path 4->9->1 represents the number 491.
 * The root-to-leaf path 4->0 represents the number 40.
 * Therefore, sum = 495 + 491 + 40 = 1026.
 *
 *
 * 总体 使用pathsum的递归法即可求得
 */
public class SumRootToLeafNumbers_129 {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        addSum(root, sum);
        return sum;
    }

    public void addSum(TreeNode root, int curNum) {
        if (root == null)
            return;
        curNum = curNum * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += curNum;
            return;
        }
        if (root.left != null)
            addSum(root.left, curNum);
        if (root.right != null)
            addSum(root.right, curNum);
    }

    public static void main(String[] args) {
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

        SumRootToLeafNumbers_129 sn = new SumRootToLeafNumbers_129();
        System.out.println(sn.sumNumbers(root));
    }
}