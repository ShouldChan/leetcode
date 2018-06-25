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

//        反转单链表
//        ListNode head = new ListNode(0);
//        ListNode l1 = new ListNode(2);
//        ListNode l2 = new ListNode(3);
//        ListNode l3 = new ListNode(5);
//        head.next = l1;
//        l1.next = l2;
//        l2.next = l3;
//        ListNode result = sl.reverse_fun4(head);
//        while (result != null) {
//            System.out.println(result.val);
//            result = result.next;
//        }

//        链表升序操作
//        ListNode head = new ListNode(6);
//        ListNode l1 = new ListNode(8);
//        ListNode l2 = new ListNode(3);
//        ListNode l3 = new ListNode(5);
//        head.next = l1;
//        l1.next = l2;
//        l2.next = l3;
//
//        sl.ascSort(head,l3.next);
//        while(head!=null){
//            System.out.println(head.val);
//            head=head.next;
//        }

//        合并两个有序单链表
//        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(4);
//        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(3);
//        l2.next.next = new ListNode(4);
//        ListNode result = sl.mergerTwoSortedLists(l1,l2);
//        while(result!=null){
//            System.out.println(result.val);
//            result=result.next;
//        }

//        返回链表倒数第k个节点
        ListNode head = new ListNode(6);
        ListNode l1 = new ListNode(8);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(5);
        head.next = l1;
        l1.next = l2;
        l2.next = l3;

        ListNode result=sl.findKthtoTail(head,3);
        System.out.println(result.val);
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

    /**
     * 实现单链表的升序
     * 使用快排的思想
     * @param begin  链表的第一个节点不是头节点
     * @param end   链表的最后一个节点的next，为null
     */
    public void ascSort(ListNode begin, ListNode end){
        if(begin==end||begin.next==end)
            return;
        int pivot = begin.val;
        ListNode i=begin;
        ListNode j=begin.next;
        while(j!=end){
            if(j.val<pivot){
                i=i.next;
                int temp=i.val;
                i.val=j.val;
                j.val=temp;
            }
            j=j.next;
        }
        int temp=i.val;
        i.val=begin.val;
        begin.val=temp;

        ascSort(begin,i);
        ascSort(i.next,end);
    }

    /**
     * 合并两个有序单链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergerTwoSortedLists(ListNode l1, ListNode l2){
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1.val<l2.val){
            ListNode tmp=l1;
            tmp.next=mergerTwoSortedLists(l1.next,l2);
            return tmp;
        }else{
            ListNode tmp=l2;
            tmp.next=mergerTwoSortedLists(l1,l2.next);
            return tmp;
        }
    }

    /**
     * 返回链表倒数第k个节点
     * @param head
     * @param k
     * @return
     */
    public ListNode findKthtoTail(ListNode head, int k){
        if(head==null||k<0)
            return null;
        ListNode first = head;
        ListNode second = head;
        for(int i=0;i<k;i++){
            if(second!=null)
                second=second.next;
            else
                return null;
        }
        while(second!=null){
            first=first.next;
            second=second.next;
        }
        return first;
    }
}