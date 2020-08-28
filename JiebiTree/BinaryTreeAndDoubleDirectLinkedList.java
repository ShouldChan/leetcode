package JiebiTree;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/8/27
 * @description 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class BinaryTreeAndDoubleDirectLinkedList {

    public TreeNode Convert(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        //先递归处理左子树,相当于把左子树已经完整的转换成双向链表，返回值为左子树链表的头节点
        TreeNode left = Convert(root.left);
        //根节点追加到左子树链表的末尾(链表尾插)
        //先找到链表的末尾(right相当于是next,left相当于prev)
        TreeNode leftTail = left;
        while (leftTail != null && leftTail.right != null) {
            leftTail = leftTail.right;
        }
        if (leftTail != null) {
            leftTail.right = root;
            root.left = leftTail;
        }


        //最后递归处理右子树(得到右子树的头节点）
        TreeNode right = Convert(root.right);
        if (right != null) {
            root.right = right;
            right.left = root;
        }
        //left不为空返回left，为空的话就返回right
        return left != null ? left : root;
    }
}
