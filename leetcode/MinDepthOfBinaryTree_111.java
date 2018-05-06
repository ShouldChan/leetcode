package com.cxj.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinDepthOfBinaryTree_111 {
//    11ms 递归求最小高度
//    使用map保存每次node节点 <每个节点，每个节点对应的最小高度>
    static Map<TreeNode,Integer> map=new HashMap<>();
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        if(map.containsKey(root))
            return map.get(root);
        if(minDepth(root.left)==0){
            map.put(root,1+minDepth(root.right));
            return 1+minDepth(root.right);
        }

        if(minDepth(root.right)==0){
            map.put(root,1+minDepth(root.left));
            return 1+minDepth(root.left);
        }

        map.put(root,1+Math.min(minDepth(root.left),minDepth(root.right)));
        return 1+Math.min(minDepth(root.left),minDepth(root.right));

    }

//    1ms 使用层序遍历的思想求最小高度

    /**
     * 每一层的放入一个队列 然后弹出的时候判断每个节点是不是叶子节点
     * @param root
     * @return
     */
    public int minDepth_level(TreeNode root){
        if(root==null)
            return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int count=0,depth=0,levelcount=1;
        while(queue.size()!=0){
            TreeNode temp=queue.poll();
            count++;
            if(temp.left!=null)
                queue.offer(temp.left);
            if(temp.right!=null)
                queue.offer(temp.right);

            if(levelcount==count){
                levelcount=queue.size();
                count=0;
                depth++;
            }
//            判断是不是叶子节点
            if(temp.left==null&&temp.right==null)
                if(count==0) //如果是该层的最后节点 因为计算到该层最后一个节点的时候depth++了。
                    return depth;
                else //如果不是该层的最后节点
                    return depth+1;
        }
        return depth;
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(0);
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);

//        root.left=node1;
//        root.right=node2;
//        node2.left=node3;
//        node3.right=node4;
        root.left=node1;
        node1.left=node2;
        node2.left=node3;
        node3.right=node4;

        MinDepthOfBinaryTree_111 mdbt=new MinDepthOfBinaryTree_111();
        System.out.println(mdbt.minDepth(root));
    }
}