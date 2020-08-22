package JiebiLinkedlist;

import basic.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/7/28
 * @description 约瑟夫环问题
 */
public class JosephRing {
    /**
     * 公式法求解
     * f(n,m)=(f(n-1,m)+m)%n
     * n表示n个人，m表示报到号码为m的人被杀掉 f(n,m)为最后幸存者的下标
     *
     * @param n
     * @param m
     * @return
     */
    public int functionDP(int n, int m) {
        if (n == 1) {
            return 0;
        }
        return (functionDP(n - 1, m) + m) % n;
    }

    /**
     * 通过公式法转换，可以使用迭代循环来求解
     *
     * @param n
     * @param m
     * @return
     */
    public int funcIter(int n, int m) {
        int p = 0;
        for (int i = 2; i <= n; i++) {
            p = (p + m) % i;
        }
        return p + 1;
    }

    /**
     * 使用循环链表
     *
     * @param head
     * @param m
     * @return
     */
    public int funcLinkedList(ListNode head, int m) {
        ListNode p = head.next;
        ListNode pre = head;
        ListNode stay = pre;
        //先让p指针走一圈回到出发点
        while (pre.next != head) {
            p = p.next;
            pre = pre.next;
        }
        int count = 1;
        while (p.next != p) {
            //如果count==m的时候，这个人就要被杀掉，就把这个人从链表中踢出
            if (count == m) {
                p = p.next;
                pre.next = p;
                count = 1;

            } else {
                p = p.next;
                pre = pre.next;
                count++;
            }
//            System.out.print(p.val + " ");
        }
        return p.val;
    }

    //使用队列
    public int funcQueue(int[] array,int n, int m){
        Queue<Integer> queue=new LinkedList<>();
        //入队列
        for(int i=0;i<array.length;i++){
            queue.offer(array[i]);
        }

        int count=0;
        while(queue.size()!=1){
            Integer person=queue.poll();
            count++;
            if(count%m==0){
                //杀死
                System.out.println(person.intValue());
            }else{
                //放回
                queue.offer(person);
            }
        }
        return queue.poll();
    }
    //使用数组+立flag

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7};
//        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int n = input.length;
        int m = 3;
        JosephRing jr = new JosephRing();
        System.out.println("幸存者是:");
        //使用公式法递归求解
        System.out.println(jr.functionDP(n, m) + 1);

        //使用循环
        System.out.println(jr.funcIter(n, m));

        //使用循环链表
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node1;
        int result = jr.funcLinkedList(node1, m);
        System.out.println("幸存者是:");
        System.out.println(result);

        System.out.println("使用队列：");
        System.out.println(jr.funcQueue(input,n,m));
    }
}
