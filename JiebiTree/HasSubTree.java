package JiebiTree;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/8/19
 * @description 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class HasSubTree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;
        return dfs(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    public boolean dfs(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        return root1.val == root2.val && dfs(root1.left, root2.left) && dfs(root1.right, root2.right);
    }


}
