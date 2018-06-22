package com.cxj.basic;

import java.util.Scanner;
import java.util.Stack;

public class SingleLinkedList {
    public static void main(String[] args) {
        SingleLinkedList sl = new SingleLinkedList();
//        逆序构造单链表
//        ListNode head=null;
//        ListNode result=sl.construct(head);
//        while(result!=null){
//            System.out.println(result.val);
//            result=result.next;
//        }

//      反转单链表
        ListNode head = new ListNode(0);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(5);
        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        ListNode result = sl.reverse_fun4(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    /**
     * 逆序构造单链表
     * 例如：输入数据：1 2 3 4 5 6，构造单链表：6->5->4->3->2->1。
     */
    public ListNode construct() {
        ListNode pre = null;
        Scanner sc = new Scanner(System.in);
//        输入单链表的总节点个数为n
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            ListNode cur = new ListNode(sc.nextInt());
            cur.next = pre;
            pre = cur;
        }
        return pre;
    }

    /**
     * 借助栈实现反转链表
     * 时间复杂度O(n)  2*n
     * 空间复杂度O(n)
     *
     * @param head
     * @return
     */
    public ListNode reverse_fun1(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }
//        使用一个dumy来作为一个返回结果的指针
        ListNode dumy = new ListNode(0);
        ListNode end = dumy;
//        尾插法 end每次都指向最后一个元素
        while (!stack.empty()) {
            ListNode cur = new ListNode(stack.pop());
            end.next = cur;
            end = cur;

        }
        end.next = null;
        return dumy.next;
    }

    /**
     * 使用头插法逆序反转
     * 时间复杂度O(n)
     * 空间复杂度O(n) 每次new了一个
     *
     * @param head
     * @return
     */
    public ListNode reverse_fun2(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode cur = new ListNode(head.val);
            cur.next = pre;
            pre = cur;
            head = head.next;
        }
        return pre;
    }

    /**
     * 使用递归
     *
     * @param head
     * @return
     */
    public ListNode reverse_fun3(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newNode = reverse_fun3(head.next);

        head.next.next = head;
        head.next = null;

        return newNode;
    }

    /**
     * 使用只有O(1)空间的做法
     * @param head
     * @return
     */
    public ListNode reverse_fun4(ListNode head){
        ListNode result=null;
        ListNode next=null;
        while(head!=null){
            next=head.next;
            head.next=result;
            result=head;
            head=next;
        }
        return result;
    }
}