package JiebiLinkedlist;

import basic.ListNode;

import java.util.List;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/8/21
 * @description 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class MergeTwoSortedList {
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
        ListNode list1 = new ListNode(1);
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(5);
        ListNode list2 = new ListNode(2);
        ListNode c = new ListNode(4);
        list1.next = a;
        a.next = b;
        list2.next = c;
        MergeTwoSortedList mt = new MergeTwoSortedList();
        ListNode result = mt.Merge(list1, list2);
        while (result != null) {
            System.out.print(result.val + "\t");
            result=result.next;
        }
    }
}
