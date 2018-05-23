package com.cxj.leetcode;

/**
 * remove duplicates from sorted list---83
 * use two points to remove duplicates
 * and then use head-insert function to return the result list
 */
public class RemoveDuplicatesfromSortedList_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        ListNode p = head;
        ListNode r = head;
        ListNode result = r;

        head = head.next;
        while (head != null) {
            if (p.val != head.val) {
                //two points to remove duplicates
                p = p.next;
                p.val = head.val;
                //use head-insert function
                r.next = p;
                r = p;
            }
            head = head.next;
        }
        p.next = null;
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(3);
        RemoveDuplicatesfromSortedList_83 rd = new RemoveDuplicatesfromSortedList_83();
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode result = rd.deleteDuplicates(l1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}