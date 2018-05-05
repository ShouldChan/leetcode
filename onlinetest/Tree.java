package com.cxj.onlinetest;

public class Tree<T> {

    private TreeNode<T> root;

    public TreeNode<T> getRoot() {
        return root;
    }

    public Tree(TreeNode<T> root) {
        this.root = root;
    }

//    添加节点

    public void addNode(TreeNode<T> node, TreeNode<T> newNode) {
        if (node == null) {
            if (root == null) {
                root = newNode;
            }
        } else {
            node.getNodelist().add(newNode);
        }
    }

    //    遍历节点
    public void traversal(TreeNode<T> root) {
        System.out.println(root.getCont());
        for (TreeNode<T> temp : root.getNodelist()) {
            traversal(temp);
        }

    }

//    //    查找newNode结点
//    public TreeNode<T> search(TreeNode<T> root, T searchCont) {
//        if (searchCont == null)
//            return null;
//        TreeNode<T> result = null;
//        searchHelp(root, result, searchCont);
//        return result;
//    }
//
//
//    public void searchHelp(TreeNode<T> root, TreeNode<T> result, T searchCont) {
//        if (root.getCont() == searchCont) {
//            result.setCont(root.getCont());
//            result.setNodelist(root.getNodelist());
//            result.setParent(root.getParent());
//        }
//
//        for (TreeNode<T> temp : root.getNodelist()) {
//            searchHelp(temp, result, searchCont);
//        }
//    }


    public static void main(String[] args) {
        TreeNode<String> root = new TreeNode<>("My");
        TreeNode<String> node1 = new TreeNode<>("Name");
        TreeNode<String> node2 = new TreeNode<>("is");
        TreeNode<String> node3 = new TreeNode<>("Should");
        TreeNode<String> node4 = new TreeNode<>("Chan");
        Tree<String> tree = new Tree(root);
        tree.addNode(root, node1);
        tree.addNode(node1, node2);
        tree.addNode(node1, node3);
        tree.addNode(node1, node4);

        tree.traversal(root);

        System.out.println("------------To be happy-------");
    }
}