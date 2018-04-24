package com.cxj.onlinetest;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {
    public T t;
    private TreeNode<T> parent;
    public List<TreeNode<T>> nodelist;

    public TreeNode(T type) {
        t = type;
        parent = null;
        nodelist = new ArrayList<TreeNode<T>>();
    }

    public TreeNode<T> getParent() {
        return parent;
    }
}