package com.cxj.onlinetest;

public class Tree<T> {
    public TreeNode<T> root;

    public Tree() {
    }

    ;

    public void addNode(TreeNode<T> node, T newNode) {
        if (node == null)
            if (root == null) {
                root = new TreeNode<T>(newNode);
            } else {
                TreeNode<T> temp = new TreeNode<T>(newNode);
                node.nodelist.add(temp);
            }
    }


}