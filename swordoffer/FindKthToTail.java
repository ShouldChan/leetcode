package com.cxj.swordoffer;

/**
 * 题目描述:
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 若k大于链表长度，则返回null
 */
public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0)
            return null;
        ListNode first = head;
        ListNode second = head;

        for (int i = 0; i < k; i++) {
            if (second != null)
                second = second.next;
            else
                return null;
        }
        while (second != null) {
            first = first.next;
            second = second.next;
        }

        return first;
    }

    public static void main(String[] args) {
        FindKthToTail fk = new FindKthToTail();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        System.out.println(fk.FindKthToTail(l1, 2).val);
    }
}