package JiebiTree;

import java.util.ArrayList;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/8/26
 * @description 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class FindPath {
    /**
     * time complexity O(n)
     * space complexity O(n)
     *
     * @param root
     * @param target
     * @return
     */
    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        dfs(root, target, new ArrayList<>());
        return ret;
    }

    public void dfs(TreeNode root, int target, ArrayList<Integer> list) {
        if (root == null)
            return;
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            ret.add(new ArrayList<>(list));
        } else {
            dfs(root.left, target, list);
            dfs(root.right, target, list);
        }
        list.remove(list.size() - 1); //代码走到这里，表明要回溯，代表当前path中的root节点我已经不需要了
    }
}
