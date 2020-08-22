package JiebiLinkedlist;

import basic.ListNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/6/15
 * @description 1.给一个单链表，判断其中是否有环的存在；
 * 2.如果存在环，找出环的入口点；
 * 3.如果存在环，求出环上节点的个数；
 * 4.如果存在环，求出链表的长度；
 * 5.如果存在环，求出环上距离任意一个节点最远的点（对面节点）；
 * 6.（扩展）如何判断两个无环链表是否相交；
 * 7.（扩展）如果相交，求出第一个相交的节点；
 */
public class IsRingInLinkedList {
    /**
     * 判断单链表是否有环
     *
     * @param head
     * @return
     */
    public static boolean IsRingExists(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 如果存在环，找出环的入口点；
     *
     * @param head
     * @return
     */
    public static Map<Integer, Object> getEntranceNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        //若快慢指针走完了，即为null，说明没有环
        if (slow == null || fast.next == null) {
            System.out.println("isRingExists: false, no entrance listnode.");
            return null;
        }
        /*
          证明从头开始走和从快慢指针相遇的节点走，能找到出口点。
          假设从头节点A到入口点B的距离步数为a，在环内距离入口点的步数为x，环的长度步数为r，在环内走的圈数为n，
          全程单链表长度为L，慢指针走了s步后相遇。
          因为快慢指针相遇肯定在环里面，极端就是在入口处相遇，加上快慢指针在环内之间的距离不会超过环的长度r，
          所以在相遇时慢指针都没有走满一周。（比如，在环里入口处开始走，慢指针走一半，快指针都走完一圈了）
          2s = s + n*r
          s = n * r
          s = (n-1) * r + r
          a + x = (n-1) * r + (L-a)  因为环的长度=链表总长度-头节点到入口处的距离
          a = (n-1) * r + (L-a-x)
          所以证明了 左边从链表头节点走到相遇点 = 右边从相遇点开始走到入口点
         */
        ListNode p1 = head;
        int count = 1;
        ListNode p2 = slow;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            count++;
        }
        Map<Integer, Object> resultMap = new HashMap<>();
        resultMap.put(1, (ListNode) p1);
        resultMap.put(2, (Integer) count);
        return resultMap;
    }

    /**
     * 如果存在环，求出环上节点的个数；
     * 相遇之后让其中一个指针继续走一圈就完事儿了
     *
     * @param head
     * @return
     */
    public static int getRingNum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }

        ListNode meetNode = slow;
        slow = slow.next;
        int count = 1;
        while (slow != meetNode) {
            slow = slow.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3;
        boolean result = IsRingExists(node1);
        System.out.println("-----------IsRingExists----------");
        System.out.println(result);

        Map<Integer, Object> resultMap = getEntranceNode(node1);
        System.out.println("-----------getEntranceNode----------");
        System.out.println(((ListNode) resultMap.get(1)).val);
        System.out.println((Integer) resultMap.get(2));

        int resultRingNum = getRingNum(node1);
        System.out.println("-----------getRingNum----------");
        System.out.println(resultRingNum);
    }
}
