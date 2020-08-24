package JiebiLinkedlist;

import basic.ListNode;

import java.util.List;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/8/23
 * @description 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {
    public ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
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
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        FindKthToTail fk = new FindKthToTail();
        System.out.println(fk.findKthToTail(n1, 2).val);
    }

}
