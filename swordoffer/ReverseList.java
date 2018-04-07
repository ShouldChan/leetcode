package com.cxj.swordoffer;

/*
    反转单链表
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {

        ListNode result = null; //保存已经逆序的第一个节点
        ListNode next = null;   //保存待逆序的第一个节点
        while (head != null) {
            next = head.next;
            head.next = result;
            result = head;
            //head为1,result->head->null(result->1->null)
            //head为2，result->2->1->null
            //头插法思想
            head = next;
        }
        return result;

    }

    public ListNode recurRevList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = recurRevList(head.next);

        head.next.next = head;

        head.next = null;

        return p;
    }

    public static void main(String[] args) {
        ReverseList rl = new ReverseList();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
//        ListNode result = rl.reverseList(l1);
//        for (int i = 0; i < 4; i++) {
//            System.out.println(result.val);
//            result = result.next;
//        }
        System.out.println("----------recursive-------------");
        ListNode re = rl.recurRevList(l1);
        for (int i = 0; i < 4; i++) {
            System.out.println(re.val);
            re = re.next;
        }
    }

}