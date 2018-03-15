package com.cxj.leetcode;


public class MergeTwoSortedLists_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val) {
            ListNode tmp = l1;
            tmp.next = mergeTwoLists(l1.next, l2);
            return tmp;
        } else {
            ListNode tmp = l2;
            tmp.next = mergeTwoLists(l1, l2.next);
            return tmp;
        }

    }

    public ListNode createList(int[] input) {
        ListNode first = null, last = null;
        ListNode newNode;
        for (int i = 0; i < input.length; i++) {
            newNode = new ListNode(input[i]);
            newNode.next = null;
            if (first == null) {
                first = newNode;
                last = newNode;
            } else {
                last.next = newNode;
                last = newNode;
            }

        }
        return first;
    }

    public static void main(String[] args) {
//        int[] input = new int[]{1, 2, 5, 6};
//        ListNode l1 = new ListNode(1);
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        MergeTwoSortedLists_21 ms = new MergeTwoSortedLists_21();
        ListNode result = ms.mergeTwoLists(l1, l2);
        System.out.println(result.next);
    }
}
