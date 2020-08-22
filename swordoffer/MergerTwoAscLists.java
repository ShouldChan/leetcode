package swordoffer;

import basic.ListNode;

/**
 * 合并两个单增链表 维持单调不减规则
 * 单调不减：{单调递增}+{单调不减不增}
 */
public class MergerTwoAscLists {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1.val < list2.val) {
            ListNode tmp = list1;
            tmp.next = Merge(list1.next, list2);
            return tmp;
        } else {
            ListNode tmp = list2;
            tmp.next = Merge(list1, list2.next);
            return tmp;
        }

    }

    public static void main(String[] args) {
        ListNode list1_1 = new ListNode(1);
        ListNode list1_2 = new ListNode(2);
        ListNode list1_3 = new ListNode(5);
        ListNode list2_1 = new ListNode(0);
        ListNode list2_2 = new ListNode(4);
        ListNode list2_3 = new ListNode(8);
        list1_1.next = list1_2;
        list1_2.next = list1_3;
        list2_1.next = list2_2;
        list2_2.next = list2_3;

        MergerTwoAscLists mtal = new MergerTwoAscLists();
        ListNode list = mtal.Merge(list1_1, list2_1);
        for (int i = 0; i < 6; i++) {
            System.out.println(list.val);
            list = list.next;
        }
    }
}