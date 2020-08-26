package JiebiTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/8/26
 * @description 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> rltList = new ArrayList<>();
        if (root == null) {
//            System.out.println(rltList);
            return rltList;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() != 0) {
            TreeNode tmp = queue.poll();
            rltList.add(tmp.val);
            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
            }
        }
        return rltList;
    }

    public static void main(String[] args) {
        PrintFromTopToBottom pf = new PrintFromTopToBottom();
        pf.PrintFromTopToBottom(null);
    }
}
