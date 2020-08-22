package JiebiTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/8/6
 * @description 二叉树的镜像
 */
public class TreeMirror {
    public void mirror(TreeNode root) {
        if (root == null)
            return;
        postOrder(root);
    }

    public TreeNode postOrder(TreeNode node) {
        if (node == null)
            return null;
        else {
            TreeNode tmp1 = postOrder(node.right);
            TreeNode tmp2 = postOrder(node.left);
            node.left = tmp1;
            node.right = tmp2;
        }
        return node;
    }

    public void levelPrint(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
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

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        TreeMirror tm = new TreeMirror();
        tm.mirror(node1);
        tm.levelPrint(node1);
    }
}
