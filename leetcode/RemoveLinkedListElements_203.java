package com.cxj.leetcode;

public class RemoveLinkedListElements_203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;

        ListNode result = new ListNode(0);
        result.next=head;
        ListNode p = result;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else
                p = p.next;
        }

        return result.next;
    }

    public static void main(String[] args) {
        RemoveLinkedListElements_203 rl = new RemoveLinkedListElements_203();
        ListNode head = new ListNode(1);
//        ListNode l1 = new ListNode(2);
//        ListNode l2 = new ListNode(2);
//        ListNode l3 = new ListNode(2);
//        ListNode l4 = new ListNode(4);
//        ListNode l5 = new ListNode(6);
//        head.next = l1;
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
        ListNode result = rl.removeElements(head, 1);
        System.out.println("----");
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}