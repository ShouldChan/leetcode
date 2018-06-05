package com.cxj.leetcode;

/**
 * 思路：
 * 解决方法有三种：
 * 1、暴力迭代两个链表结点比较相等，时间复杂度O(n^2)
 * 2、改变链表数据结构，将c3结点指向A链表表头，即构成循环链表。此时该问题就变为了Linked List Cycle II
 * 3、从表尾对齐两链表，截去长的链表多余部分，使得两链表长度相等，然后每次移动一个结点，判断指针是否相等
 * <p>
 * 因为题目条件要求空间复杂度O(1)，所以1不行。
 * 因为条件2要求保留原来数据结构（其实修改数据结构改为循环，
 * 判断结果之后再恢复解开循环也就不算改变数据结构了。。）所以2不行。
 */
public class IntersectionofTwoLinkedLists_160 {
    public int getListLength(ListNode head) {
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }
        return length;
    }

    public ListNode getListNode(ListNode head, int count) {
        int i = count;
        ListNode p = head;
        while (--i > 0 && p != null) {
            p = p.next;
        }
        return p;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;
        int alength = getListLength(l1), blength = getListLength(l2);
        if (alength > blength) {
            l1 = getListNode(headA, alength - blength + 1);
        } else {
            l2 = getListNode(headB, blength - alength + 1);
        }
        while (l1 != null && l2 != null) {
            if (l1 == l2)
                return l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        IntersectionofTwoLinkedLists_160 tl = new IntersectionofTwoLinkedLists_160();

        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(3);
        ListNode c1 = new ListNode(4);
        ListNode c2 = new ListNode(7);
        ListNode c3 = new ListNode(9);
        ListNode b1 = new ListNode(-1);
        ListNode b2 = new ListNode(0);
        ListNode b3 = new ListNode(23);

        c1.next = c2;
        c2.next = c3;
        a1.next = a2;
        a2.next = c1;
        b1.next = b2;
        b2.next = b3;
        b3.next = c1;
        ListNode inter = tl.getIntersectionNode(a1, b1);
        while (inter != null) {
            System.out.println(inter.val);
            inter = inter.next;
        }

    }
}