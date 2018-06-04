package com.cxj.leetcode;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 使用归并排序，用递归划分表中点
 */
public class SortedList_148 {
    public static void main(String[] args) {
        SortedList_148 sl = new SortedList_148();
        ListNode head = new ListNode(4);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(-1);
        ListNode l3 = new ListNode(8);
        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        ListNode result = sl.sortList(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode fast = head,slow = head,l2 = null;
        //fast走两步，slow走一步，当fast到达表尾时，slow在链表中间位置
        while(fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }//此时fast在表尾，slow在中间
        l2 = slow.next; //第二条链表表头
        slow.next = null; //断开

        head = sortList(head);//分冶
        l2 = sortList(l2);

        return mergeTwoLists(l2, head);//合并
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null,l,p = l1,q = l2;
        //==确定头节点
        if(p!=null&&q!=null){
            if(p.val<q.val){
                head = p;
                p = p.next;
            }else{
                head = q;
                q = q.next;
            }
        }else if(p==null){
            head = q;
            return head;
        }else if(q==null){
            head = p;
            return head;
        }
        l = head;
        //===end

        while(p!=null&&q!=null){
            if(p.val<q.val){
                l.next = p;
                l = p;
                p = p.next;
            }else{
                l.next = q;
                l = q;
                q = q.next;
            }
        }

        if(p==null){
            l.next = q;
        }else if(q==null){
            l.next = p;
        }

        return head;
    }

}