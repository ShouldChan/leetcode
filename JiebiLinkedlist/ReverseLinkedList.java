package JiebiLinkedlist;

import basic.ListNode;

import java.util.List;
import java.util.Stack;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/6/8
 * @description 反转链表
 */
public class ReverseLinkedList {
    /**
     * time O(n)
     * space O(1)
     */
    public ListNode reverseLinkedList(ListNode head) {
        ListNode result = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = result;
            result = head;
            head = next;
        }
        return result;
    }

    /**
     * 头插法的思想
     * 时间复杂度O（n）
     * 空间复杂度O（n）
     */
    public static ListNode reverseLinkedListByHeadInsert(ListNode head) {
        //定义一个指针用来指向逆序的结果,包括中间过程的逆序的结果。
        ListNode pre = null;
        while (head != null) {
            ListNode cur = new ListNode(head.val);
            //头插法把这个节点放在已经逆序的链表的前面
            cur.next = pre;
            //让pre指向新加入的逆序节点，这样构成了一条更新的逆序链表
            pre = cur;
            head = head.next;
        }
        return pre;
    }

    /**
     * 借助栈
     * 时间复杂度O（n）
     * 空间复杂度O（n）
     *
     * @param head
     * @return
     */
    public static ListNode reverseLinkedListByStackKindA(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }
        // 定义一个指针指向未操作前的尾指针 用来返回逆序的结果。
        ListNode revHead = new ListNode(0);
        ListNode end = revHead;

        //中间需要定义一个临时指针来存储出栈的临时链表节点
        while (!stack.isEmpty()) {
            ListNode cur = new ListNode(stack.pop());
            end.next = cur;
            end = cur;
        }
        end.next = null;
        return revHead.next;
    }

    public static ListNode reverseLinkedListByStackKindB(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        ListNode reverseHead = new ListNode(0);
        ListNode end = reverseHead;

        ListNode cur = new ListNode(0);
        while (!stack.isEmpty()) {
            cur = stack.pop();
            end.next = cur;
            end = cur;
        }
        end.next = null;
        return reverseHead.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        /*
        System.out.println("-----------ByStack Kind A----------");
        ListNode resultA = reverseLinkedListByStackKindA(node1);
        while (resultA != null) {
            System.out.println(resultA.val);
            resultA = resultA.next;
        }

        System.out.println("-----------ByStack Kind B----------");
        ListNode resultB = reverseLinkedListByStackKindB(node1);
        while (resultB != null) {
            System.out.println(resultB.val);
            resultB = resultB.next;
        }
        */

        System.out.println("-----------ByHeadInsert Kind C----------");
        ListNode resultC = reverseLinkedListByHeadInsert(node1);
        while (resultC != null) {
            System.out.println(resultC.val);
            resultC = resultC.next;
        }
    }
}
