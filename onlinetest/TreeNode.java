package com.cxj.onlinetest;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {


    private T cont;

    private TreeNode<T> parent;
    private List<TreeNode<T>> nodelist;

    public TreeNode(T cont) {
        this.cont = cont;
        this.parent = null;
        this.nodelist = new ArrayList<TreeNode<T>>();
    }

    public T getCont() {
        return cont;
    }

    public void setCont(T cont) {
        this.cont = cont;
    }

    public TreeNode<T> getParent() {
        return parent;
    }

    public void setParent(TreeNode<T> parent) {
        this.parent = parent;
    }

    public List<TreeNode<T>> getNodelist() {
        return nodelist;
    }

    public void setNodelist(List<TreeNode<T>> nodelist) {
        this.nodelist = nodelist;
    }

}