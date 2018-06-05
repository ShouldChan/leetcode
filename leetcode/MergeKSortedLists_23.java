package com.cxj.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists_23 {
    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        List<ListNode> heads = new ArrayList<>();

        for (int i = 0; i < lists.length; i++) {
            heads.add(lists[i]);
        }
        while (heads.size() > 1) {
            List<ListNode> head2 = new ArrayList<>();
            for (int i = 0; i + 1 < heads.size(); i += 2) {
                ListNode l1 = heads.get(i);
                ListNode l2 = heads.get(i + 1);
                head2.add(mergeTwoLists(l1, l2));
            }
            //上述循环 如果heads.size()是奇数的话，最后一个就没加进去，所以需要判断表头个数是否为奇数然后加进去
            if (heads.size() % 2 == 1) {
                head2.add(heads.get(heads.size() - 1));
            }
            heads = new ArrayList<ListNode>(head2);
        }
        return heads.get(0);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null, l, p = l1, q = l2;
//        确认头节点
        if (p != null && q != null) {
            if (p.val < q.val) {
                head = p;
                p = p.next;
            } else {
                head = q;
                q = q.next;
            }
        } else if (p == null) {
            head = q;
            return head;
        } else if (q == null) {
            head = p;
            return head;
        }
        //-------------
        l = head;// 把head赋给了l，l就指向head的那一条链，对这条链进行排序
        while (p != null && q != null) {
            if (p.val < q.val) {
                l.next = p;
                l = p;
                p = p.next;
            } else {
                l.next = q;
                l = q;
                q = q.next;
            }
        }
        if (p == null)
            l.next = q;
        if (q == null)
            l.next = p;
        return head;
    }
}