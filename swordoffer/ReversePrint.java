package com.cxj.swordoffer;


import java.util.ArrayList;
import java.util.Stack;

public class ReversePrint {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> arraylist = new ArrayList<Integer>();
        ListNode t = listNode;
        while (t != null) {
            stack.push(t.val);
            t = t.next;
        }

        while (!stack.empty()) {
            arraylist.add(stack.pop());
        }
        return arraylist;
    }

    public static void main(String[] args) {
        ReversePrint rp = new ReversePrint();

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = null;


        ArrayList<Integer> result = rp.printListFromTailToHead(l1);

//        System.out.println(result.size());
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}